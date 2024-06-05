package com.careerboost.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerboost.entity.Event;
import com.careerboost.repository.EventRepository;
import com.careerboost.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event createEvent(Event event) {
        validateEvent(event);
        setDefaultValues(event);
        event.setCreatedDateTime(LocalDateTime.now());
        return eventRepository.save(event);
    }

    @Override
    public Event editEvent(Event newEvent, Long id) {
        Event event = eventRepository.findById(id).orElseThrow();
        updateEventDetails(event, newEvent);
        event.setUpdateDateTime(LocalDateTime.now());
        return eventRepository.save(event);
    }

    @Override
    public String deleteEventById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow();
        eventRepository.delete(event);
        return "Record deleted successfully";
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    private void validateEvent(Event event) {
        if (event.getTitle() == null || event.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title is required.");
        }
        if (event.getLocation() == null || event.getLocation().isEmpty()) {
            throw new IllegalArgumentException("Location is required.");
        }
        if (event.getDate() == null) {
            throw new IllegalArgumentException("Date is required.");
        }
        if (event.getTime() == null) {
            throw new IllegalArgumentException("Time is required.");
        }
        if (event.getCurrency() == null || event.getCurrency().isEmpty()) {
            throw new IllegalArgumentException("Currency is required.");
        }
        if (event.getIsActive() == null) {
            event.setIsActive(true); // Default to active
        }
    }

    private void setDefaultValues(Event event) {
        if (event.getSeoTitle() == null || event.getSeoTitle().isEmpty()) {
            event.setSeoTitle(event.getTitle());
        }
        if (event.getSeoDescription() == null || event.getSeoDescription().isEmpty()) {
            event.setSeoDescription(event.getContent() != null ? event.getContent().substring(0, Math.min(150, event.getContent().length())) : "");
        }
        if (event.getCanonicalURL() == null || event.getCanonicalURL().isEmpty()) {
            event.setCanonicalURL(event.getPageURL());
        }
        if (event.getCreatedDateTime() == null) {
            event.setCreatedDateTime(LocalDateTime.now());
        }
        if (event.getUpdateDateTime() == null) {
            event.setUpdateDateTime(LocalDateTime.now());
        }
    }

    private void updateEventDetails(Event event, Event newEvent) {
        event.setLocation(newEvent.getLocation());
        event.setPrice(newEvent.getPrice());
        event.setDiscountPrice(newEvent.getDiscountPrice());
        event.setRegistrationURL(newEvent.getRegistrationURL());
        event.setDate(newEvent.getDate());
        event.setTime(newEvent.getTime());
        event.setTimeZone(newEvent.getTimeZone());
        event.setCurrency(newEvent.getCurrency());
        event.setTitle(newEvent.getTitle());
        event.setImage(newEvent.getImage());
        event.setContent(newEvent.getContent());
        event.setCategory(newEvent.getCategory());
        event.setAuthor(newEvent.getAuthor());
        event.setPublishedDate(newEvent.getPublishedDate());
        event.setPageURL(newEvent.getPageURL());
        event.setSeoTitle(newEvent.getSeoTitle());
        event.setSeoDescription(newEvent.getSeoDescription());
        event.setSeoKeyword(newEvent.getSeoKeyword());
        event.setCanonicalURL(newEvent.getCanonicalURL());
        event.setCreatedBy(newEvent.getCreatedBy());
        event.setUpdatedBy(newEvent.getUpdatedBy());
        event.setIsActive(newEvent.getIsActive());
        event.setMode(newEvent.getMode());
    }

}
