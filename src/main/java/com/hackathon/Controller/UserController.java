package com.hackathon.Controller;

import com.hackathon.PO.Event;
import com.hackathon.PO.User;
import com.hackathon.Service.EventService;
import com.hackathon.Service.PreferenceService;
import com.hackathon.Service.UserService;
import com.hackathon.Util.ResponseResult;
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
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private PreferenceService preferenceService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> showAllUsers () {
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.userService.findAll(),"success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseResult> addUser (@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ResponseResult>(ResponseResult.fail(result.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.userService.save(user),"success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResponseResult> updateUser (@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ResponseResult> (ResponseResult.fail(result.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.userService.save(user),"success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResponseResult> deleteUser (@PathVariable("id") Integer id) {
        this.userService.deleteById(id);
        return new ResponseEntity<ResponseResult> (ResponseResult.success(null,"success"), HttpStatus.OK);
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> getUserById (@PathVariable("id") Integer id) {
        Optional<User> user = this.userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<ResponseResult> (ResponseResult.success(user,"success"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseResult.fail("user not found"),HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseResult> login(@RequestBody User user) {
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
        System.out.println("login successful");
        HashMap<String, String> errorMsg = new HashMap<>();
        errorMsg.put("message","invalid username or password");
        if (user.getUsername() != null || user.getPassword() != null) {
            User result = this.userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (result == null) {
                return new ResponseEntity<ResponseResult>(ResponseResult.fail("invalid username or password"),HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<ResponseResult>(ResponseResult.success(result,"success"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseResult>(ResponseResult.fail("invalid username or password"), HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "user/image", method = RequestMethod.POST)
    public ResponseEntity<ResponseResult> uploadUserImage (@RequestParam("uploadFile") MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"temp/uploadedFiles/user/";
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
    @RequestMapping(value = "/user/image/{filename}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUserPhoto (HttpServletRequest request, HttpServletResponse response, @PathVariable("filename") String filename) {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"temp/uploadedFiles/user/";
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
    @RequestMapping(value = "/user/userCreatedEvents/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> getUserCreatedEvents (@PathVariable("id") Integer id) {
        Optional<User> user = this.userService.findById(id);
        Set<Event> eventList = user.get().getUserCreatedEvents();
        return new ResponseEntity<ResponseResult> (ResponseResult.success(eventList,"success"), HttpStatus.OK);
    }
    @RequestMapping(value = "/user/userJointEvents/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> getUserJointEvents (@PathVariable("id") Integer id) {
        Optional<User> user = this.userService.findById(id);
        Set<Event> eventList = user.get().getUserJointEvents();
        return new ResponseEntity<ResponseResult> (ResponseResult.success(eventList,"success"), HttpStatus.OK);
    }
    @RequestMapping(value = "/user/userInterestEvents/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> getUserInterestEvents (@PathVariable("id") Integer id) {
        Optional<User> user = this.userService.findById(id);
        Set<Event> eventList = user.get().getUserInterestEvents();
        return new ResponseEntity<ResponseResult> (ResponseResult.success(eventList,"success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/favorateEvent/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseResult> addUserFavorateEvents (@RequestBody UserEventVO userEventVO) {
        Optional<User> user = this.userService.findById(userEventVO.getUserID());
        Optional<Event> event = this.eventService.findById(userEventVO.getEventID());
        if (user.isPresent() && event.isPresent()) {
            user.get().getUserInterestEvents().add(event.get());
            this.userService.save(user.get());
            return new ResponseEntity<ResponseResult> (ResponseResult.success(userEventVO,"success"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.fail("userID or eventID not available."),HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/user/jointEvent/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseResult> addUserJointEvents (@RequestBody UserEventVO userEventVO) {
        Optional<User> user = this.userService.findById(userEventVO.getUserID());
        Optional<Event> event = this.eventService.findById(userEventVO.getEventID());
        if (user.isPresent() && event.isPresent()) {
            user.get().getUserJointEvents().add(event.get());
            this.userService.save(user.get());
            return new ResponseEntity<ResponseResult> (ResponseResult.success(userEventVO,"success"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.fail("userID or eventID not available."),HttpStatus.BAD_REQUEST);
    }
}
