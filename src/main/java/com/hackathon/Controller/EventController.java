package com.hackathon.Controller;

import com.hackathon.PO.Event;
import com.hackathon.PO.Preference;
import com.hackathon.PO.User;
import com.hackathon.Service.EventService;
import com.hackathon.Service.PreferenceService;
import com.hackathon.Service.UserService;
import com.hackathon.Util.POToVO;
import com.hackathon.Util.ResponseResult;
import com.hackathon.Util.VOToPO;
import com.hackathon.VO.EventVO;
import com.hackathon.VO.UserEventVO;
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
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private PreferenceService preferenceService;
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> showAllEvents () {
        System.out.println("get all events");
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.eventService.findAll(),"success"), HttpStatus.OK);
    }
    @RequestMapping(value = "/comingEvents", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> showAllComingEvents () {
        System.out.println("get all coming events");
        Set<Event> eventSet = this.eventService.findAll().stream().filter(t->{
            if (t.getStartDate()!=null && t.getStartDate().getTime()>new Date().getTime()){
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toSet());
        return new ResponseEntity<ResponseResult> (ResponseResult.success(eventSet,"success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseResult> addPreference(@RequestBody @Valid EventVO eventVO, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ResponseResult>(ResponseResult.fail(result.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        Event event = VOToPO.eventVOToPO(eventVO,new Event(),preferenceService,userService);
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
        System.out.println("getEventById:"+id);
        Optional<Event> event = this.eventService.findById(id);
        if (event.isPresent()) {
            EventVO eventVO = POToVO.eventPOToVO(event.get());
            return new ResponseEntity<ResponseResult>(ResponseResult.success(eventVO,"success"), HttpStatus.OK);
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

@RequestMapping(value = "/event/image", method = RequestMethod.POST)
public ResponseEntity<ResponseResult> uploadUserImage ( @RequestParam("file") MultipartFile file) {
    try {
        System.out.println(file);
        System.out.println("file");
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
        System.out.println("getUserPhoto:"+resultFile.getAbsolutePath());
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
    @RequestMapping(value = "/event/jointUser/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseResult> addEventJointUser (@RequestBody UserEventVO userEventVO) {
        Optional<User> user = this.userService.findById(Integer.valueOf(userEventVO.getUserID()));
        Optional<Event> event = this.eventService.findById(Integer.valueOf(userEventVO.getEventID()));
        if (user.isPresent() && event.isPresent()) {
            user.get().getUserJointEvents().add(event.get());
            this.userService.save(user.get());
            return new ResponseEntity<ResponseResult> (ResponseResult.success(userEventVO,"success"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.fail("userID or eventID not available."),HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/event/eventJointUsers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> getEventJointUsers(@PathVariable("id") Integer id) {
        Optional<Event> event = this.eventService.findById(id);
        if (event.isPresent()) {
            Set<User> userList = event.get().getEventJointUsers();
            Set<String> userNames = new HashSet<>();
            for (User user:userList) {
                userNames.add(user.getName());
            }
            return new ResponseEntity<ResponseResult> (ResponseResult.success(userNames,"success"),HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseResult> (ResponseResult.fail("no event found"),HttpStatus.OK);
        }
    }
}
