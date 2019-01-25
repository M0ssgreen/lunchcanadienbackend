package fr.solutec.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class EventRestService {
	@Autowired
	private EventRepository eventRepo;
	
	@RequestMapping(value="/events", method=RequestMethod.GET)
	public List<Event> getEvents(){
		return eventRepo.findAll();
	}
	

	@RequestMapping(value="/events", method=RequestMethod.POST)
	public Event saveEvent(@RequestBody Event e){
		return eventRepo.save(e);
	}
	
	@RequestMapping(value="/events/{id}",method=RequestMethod.DELETE)
	public boolean suppUser(@PathVariable Long id) {
		
		eventRepo.delete(id);
		return true;
	}
	
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.PUT)
	public Event modifEvent(@PathVariable Long id, @RequestBody Event e){
		 e.setIdEvent(id);
		 return eventRepo.save(e);
	}
	
	@RequestMapping(value="/event/{id}", method=RequestMethod.GET)
	public Event getEventById(@PathVariable Long id){
		return eventRepo.findOne(id);
	}
}
