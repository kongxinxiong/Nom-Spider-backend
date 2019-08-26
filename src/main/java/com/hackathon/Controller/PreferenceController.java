package com.hackathon.Controller;

import com.hackathon.Pojo.Preference;
import com.hackathon.Service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PreferenceController {
    @Autowired
    private PreferenceService preferenceService;
    @RequestMapping(value = "/preferences", method = RequestMethod.GET)
    @ResponseBody
    public List<Preference> showAllPreference() {
        return this.preferenceService.findAll();
    }
}
