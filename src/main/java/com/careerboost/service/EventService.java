package com.careerboost.service;

import java.util.List;

import com.careerboost.entity.Event;

public interface EventService {
	
	List<Event> getAllEvents();
    Event createEvent(Event event);
    Event editEvent(Event event, Long id);
    String deleteEventById(Long id);
    Event getEventById(Long id);
}

