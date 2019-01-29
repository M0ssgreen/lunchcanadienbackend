package fr.solutec.dao;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Event;

public interface EventRepository  extends JpaRepository<Event, Long> {
	List<Event> findByQuantieme(Instant quantieme);
}
