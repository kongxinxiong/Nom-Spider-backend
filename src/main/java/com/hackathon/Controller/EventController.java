package com.hackathon.Controller;

import com.hackathon.PO.Event;
import com.hackathon.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class EventController {
    @Autowired
    private EventService eventService;
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> showAllEvents () {
        return new ResponseEntity<Object> (this.eventService.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/event", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> addPreference(@Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.eventService.save(event),HttpStatus.OK);
    }
    @RequestMapping(value = "/event", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> updatePreference(@Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.eventService.save(event),HttpStatus.OK);
    }
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> deletePreferenceById(@PathVariable("id") Integer id) {
        this.eventService.deleteById(id);
        return new ResponseEntity<Object> ("successfully deleted",HttpStatus.OK);
    }
}
