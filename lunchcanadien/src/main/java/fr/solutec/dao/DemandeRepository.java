package fr.solutec.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
	List<Demande> findByEvent(Event event);
	List<Demande> findByEventId(Long eventId);
	List<Demande> findByUserId(Long userId);
}

