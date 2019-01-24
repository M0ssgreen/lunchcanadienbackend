package fr.solutec.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Event;

public interface EventRepository  extends JpaRepository<Event, Long> {

}
