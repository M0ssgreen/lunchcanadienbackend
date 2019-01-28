package fr.solutec.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.EventRepository;
import fr.solutec.entities.Event;

@RestController
@CrossOrigin("*")
public class EventServices {
	
	@Autowired
	private static EventRepository eventRepo;
	
	public static Event getIdByDate(Date dateEvent) {
		return eventRepo.findByDate(dateEvent);
	}
	
	public static Event createEvent(Event event) {
		
		return eventRepo.save(event);
	}
		
	
}
