package com.hackathon.Controller;

import com.hackathon.PO.Preference;
import com.hackathon.Service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class PreferenceController {
    @Autowired
    private PreferenceService preferenceService;
    @RequestMapping(value = "/preferences", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> showAllPreference() {
        return new ResponseEntity<Object> (this.preferenceService.findAll(),HttpStatus.OK);
    }
    @RequestMapping(value = "/preference", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> addPreference(@Valid Preference preference, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.preferenceService.save(preference),HttpStatus.OK);
    }
    @RequestMapping(value = "/preference", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> updatePreference(@Valid Preference preference, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.preferenceService.save(preference),HttpStatus.OK);
    }
    @RequestMapping(value = "/preference/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> deletePreferenceById(@PathVariable("id") Integer id) {
        this.preferenceService.deleteById(id);
        return new ResponseEntity<Object> ("successfully deleted",HttpStatus.OK);
    }

}
