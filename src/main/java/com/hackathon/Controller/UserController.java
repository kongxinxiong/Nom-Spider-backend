package com.hackathon.Controller;

import com.hackathon.Pojo.User;
import com.hackathon.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> showAllUsers () {
        return this.userService.findAll();
    }
}
