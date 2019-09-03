package com.hackathon.Controller;

import com.hackathon.PO.Event;
import com.hackathon.Service.EventService;
import com.hackathon.Util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EventController {
    @Autowired
    private EventService eventService;
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> showAllEvents () {
        System.out.println("get all events");
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.eventService.findAll(),"success"), HttpStatus.OK);
    }
    @RequestMapping(value = "/event", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseResult> addPreference(@RequestBody @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ResponseResult>(ResponseResult.fail(result.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.eventService.save(event),"success"),HttpStatus.OK);
    }
    @RequestMapping(value = "/event", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResponseResult> updatePreference(@RequestBody @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ResponseResult>(ResponseResult.fail(result.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.eventService.save(event),"success"),HttpStatus.OK);
    }
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> getEventById(@PathVariable("id") Integer id) {
        Optional<Event> event = this.eventService.findById(id);
        if (event.isPresent()) {
            return new ResponseEntity<ResponseResult>(ResponseResult.success(event,"success"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<ResponseResult>(ResponseResult.fail("Event not found."), HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResponseResult> deleteEventById(@PathVariable("id") Integer id) {
        this.eventService.deleteById(id);
        return new ResponseEntity<ResponseResult> (ResponseResult.success(null,"success"),HttpStatus.OK);
    }

@RequestMapping(value = "event/image", method = RequestMethod.POST)
public ResponseEntity<ResponseResult> uploadUserImage (@RequestParam("uploadFile") MultipartFile file) {
    try {
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"temp/uploadedFiles/event/";
        String destFileName = path + fileName;
        File destFile = new File(destFileName);
        destFile.getParentFile().mkdirs();

        file.transferTo(destFile);
        System.out.println("destFile:"+destFile);
        return new ResponseEntity(ResponseResult.success(fileName,"success"), HttpStatus.OK);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return new ResponseEntity(ResponseResult.fail("fail to upload file."),HttpStatus.BAD_REQUEST);
    } catch (IOException e) {
        e.printStackTrace();
        return new ResponseEntity(ResponseResult.fail("fail to upload file."),HttpStatus.BAD_REQUEST);
    }
}
    @RequestMapping(value = "/event/image/{filename}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUserPhoto (HttpServletRequest request, HttpServletResponse response, @PathVariable("filename") String filename) {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"temp/uploadedFiles/event/";
        File resultFile = new File (path,filename);
        System.out.println("path:"+resultFile.getAbsolutePath());
        if (resultFile.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
            response.setContentType("multipart/form-data;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName="+ filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(resultFile);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return new ResponseEntity<String>("success",HttpStatus.OK);
        }
        return new ResponseEntity<String>("cannot download this file",HttpStatus.OK);
    }
}
