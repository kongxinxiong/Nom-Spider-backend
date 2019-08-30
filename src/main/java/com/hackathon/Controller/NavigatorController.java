package com.hackathon.Controller;

import com.hackathon.PO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigatorController {

    @RequestMapping(value = "/Nom-Spider", method = RequestMethod.GET)
    public String index() {
        System.out.println("home page");
        return "redirect:/index.html";
    }
}
