package com.hackathon.Controller;

import com.hackathon.PO.User;
import com.hackathon.Service.UserService;
import com.hackathon.Util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.HashMap;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> showAllUsers () {
        return new ResponseEntity<Object> (this.userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> addUser (@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.userService.save(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> updateUser (@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object> (result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.userService.save(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> deleteUser (@PathVariable("id") Integer id) {
        this.userService.deleteById(id);
        return new ResponseEntity<Object> ("successfully deleted", HttpStatus.OK);
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
}
