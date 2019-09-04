package com.hackathon.Controller;

import com.hackathon.PO.Preference;
import com.hackathon.Service.EventService;
import com.hackathon.Service.PreferenceService;
import com.hackathon.Service.UserService;
import com.hackathon.Util.ResponseResult;
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
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private PreferenceService preferenceService;

    @RequestMapping(value = "/preferences", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> showAllPreference() {
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.preferenceService.findAll(),"success"),HttpStatus.OK);
    }
    @RequestMapping(value = "/preference", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseResult> addPreference(@RequestBody @Valid Preference preference, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ResponseResult>(ResponseResult.fail(result.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.preferenceService.save(preference),"success"),HttpStatus.OK);
    }
    @RequestMapping(value = "/preference", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResponseResult> updatePreference(@RequestBody @Valid Preference preference, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<ResponseResult>(ResponseResult.fail(result.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.preferenceService.save(preference),"success"),HttpStatus.OK);
    }
    @RequestMapping(value = "/preference/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResponseResult> deletePreferenceById(@PathVariable("id") Integer id) {
        this.preferenceService.deleteById(id);
        return new ResponseEntity<ResponseResult> (ResponseResult.success(null,"success"),HttpStatus.OK);
    }

}
