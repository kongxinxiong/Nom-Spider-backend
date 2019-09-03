package com.hackathon.Controller;

import com.hackathon.PO.Event;
import com.hackathon.Service.EventService;
import com.hackathon.Util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EventController {
    @Autowired
    private EventService eventService;
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseResult> showAllEvents () {
        System.out.println("get all events");
        return new ResponseEntity<ResponseResult> (ResponseResult.success(this.eventService.findAll(),"success"), HttpStatus.OK);
    }
    @RequestMapping(value = "/event", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> addPreference(@RequestBody @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.eventService.save(event),HttpStatus.OK);
    }
    @RequestMapping(value = "/event", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> updatePreference(@RequestBody @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object> (this.eventService.save(event),HttpStatus.OK);
    }
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getEventById(@PathVariable("id") Integer id) {
        Optional<Event> event = this.eventService.findById(id);
        if (event.isPresent()) {
            return new ResponseEntity<Object>(event, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Object>("Event not found.", HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> deleteEventById(@PathVariable("id") Integer id) {
        this.eventService.deleteById(id);
        return new ResponseEntity<Object> ("successfully deleted",HttpStatus.OK);
    }

//    @RequestMapping(value = "/event/img", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<Object> uploadEventImage(@RequestParam("file") MultipartFile file) {
//        if (result.hasErrors()) {
//            return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<Object> (this.eventService.save(event),HttpStatus.OK);
//    }
}
