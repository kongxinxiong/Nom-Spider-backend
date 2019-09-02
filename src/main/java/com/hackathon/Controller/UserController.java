package com.hackathon.Controller;

import com.hackathon.PO.User;
import com.hackathon.Service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;

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
    public ResponseEntity<Object> login(@RequestBody User user) {
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
        System.out.println("login successful");
        if (user.getUsername() != null || user.getPassword() != null) {
            User result = this.userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            return new ResponseEntity<Object>(result, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("invalid username or password", HttpStatus.OK);
    }
//    @RequestMapping(valus
//    public ResponseEntity<Object> uploadUserImage (HttpServletRequest req, @RequestParam("file") MultipartFile file, Model m) {
//        try {
//            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
//            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
//            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
//            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
//            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
//            File destFile = new File(destFileName);
//            destFile.getParentFile().mkdirs();
//            //5.把浏览器上传的文件复制到希望的位置
//            file.transferTo(destFile);
//            //6.把文件名放在model里，以便后续显示用
//            m.addAttribute("fileName", fileName);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return "上传失败," + e.getMessage();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "上传失败," + e.getMessage();
//        }
//
//        return "showImg";
//        return new ResponseEntity<Object> (this.userService.save(user), HttpStatus.OK);
//    }
}
