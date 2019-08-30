package com.hackathon.Controller;

import com.hackathon.PO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigatorController {

    @RequestMapping(value = "/Nom-Spider", method = RequestMethod.GET)
    public String index() {
        System.out.println("home page");
        return "redirect:/index.html";
    }

    @RequestMapping(value = "/api/login/{username}", method = RequestMethod.GET)
    public ResponseEntity<String> login(@PathVariable("username") String username) {
        System.out.println("login");
        return new ResponseEntity<String>(username, HttpStatus.OK);
    }
}
