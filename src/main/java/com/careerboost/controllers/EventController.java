package com.careerboost.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerboost.entity.Event;
import com.careerboost.service.EventService;

@RestController
@CrossOrigin("*")
@RequestMapping("/CareerBoost/events")
public class EventController {
	
	 	@Autowired
	    private EventService eventService;

	    @GetMapping
	    public List<Event> getAllEvents() {
	        return eventService.getAllEvents();
	    }

	    @PostMapping("/create")
	    public Event createEvent(@RequestBody Event event) {
	        return eventService.createEvent(event);
	    }

	    @PutMapping("/edit/{id}")
	    public Event editEvent(@RequestBody Event event, @PathVariable Long id) {
	        return eventService.editEvent(event, id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteEvent(@PathVariable Long id) {
	        return eventService.deleteEventById(id);
	    }

	    @GetMapping("/{id}")
	    public Event getEventById(@PathVariable Long id) {
	        return eventService.getEventById(id);
	    }

}
