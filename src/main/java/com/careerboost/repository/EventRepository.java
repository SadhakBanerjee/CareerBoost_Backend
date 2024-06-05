package com.careerboost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerboost.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
