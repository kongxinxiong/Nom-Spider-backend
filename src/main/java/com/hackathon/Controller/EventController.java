package com.hackathon.Controller;

import com.hackathon.Pojo.Event;
import com.hackathon.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> showAllEvents () {
        return this.eventService.findAll();
    }
}
