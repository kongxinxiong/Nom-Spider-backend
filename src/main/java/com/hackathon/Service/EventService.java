package com.hackathon.Service;

import com.hackathon.PO.Event;
import com.hackathon.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public void deleteById (Integer id) {
        this.eventRepository.deleteById(id);
    }
    public Optional<Event> findById(Integer id) {
        return this.eventRepository.findById(id);
    }
}
