package com.hackathon.Service;

import com.hackathon.Pojo.Event;
import com.hackathon.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event save (Event event) {
        return this.eventRepository.save(event);
    }

    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }
}
