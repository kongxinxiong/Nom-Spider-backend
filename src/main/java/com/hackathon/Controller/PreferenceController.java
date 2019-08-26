package com.hackathon.Controller;

import com.hackathon.PO.Preference;
import com.hackathon.Service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Preference>> showAllPreference() {
        return new ResponseEntity<List<Preference>> (this.preferenceService.findAll(),HttpStatus.OK);
    }
}
