package fr.solutec.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.EventRepository;
import fr.solutec.web.DemandeRestService;
import fr.solutec.dao.UserRepository;
import fr.solutec.email.MailServices;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;

import fr.solutec.services.EventServices;
import fr.solutec.services.DemandeServices;

@RestController
@CrossOrigin("*")
public class EventRestService {
	@Autowired
	private MailServices ms;
	private EventServices eventServices;
	private EventRepository eventRepo;
	@Autowired
	private DemandeServices demandeServices;

	
	@Autowired
	public EventRestService(EventRepository eventRepo, DemandeServices demandeServices, MailServices ms,
			EventServices eventServices) {
		super();
		this.eventRepo = eventRepo;
		this.demandeServices = demandeServices;
		this.ms = ms;
		this.eventServices = eventServices;
	}


	@RequestMapping(value="/events", method=RequestMethod.GET)
	public List<Event> getEvents(){
		return this.eventRepo.findAll();
	}
	

	/*@RequestMapping(value="/events", method=RequestMethod.POST)
	public Event saveEvent(@RequestBody Event e){
		return eventRepo.save(e);
	}*/
	
	@RequestMapping(value="/events", method=RequestMethod.POST)
	public void saveEvent(@RequestBody Demande d){

		this.demandeServices.matchEvent(d);
	}
	
	
	@RequestMapping(value="/events/{id}",method=RequestMethod.DELETE)
	public boolean suppUser(@PathVariable Long id) {
		
		eventRepo.deleteById(id);
		return true;
	}
	
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.PUT)
	public Event modifEvent(@PathVariable Long id, @RequestBody Event e){
		 e.setId(id);
		 return eventRepo.save(e);
	}
	
	@RequestMapping(value="/event/{id}", method=RequestMethod.GET)
	public Event getEventById(@PathVariable Long id){
		return eventRepo.findById(id).get();
	}
	
	@RequestMapping(value="/eventvalide", method=RequestMethod.GET)
	public List<Event> getEventByMail(@RequestParam("email") String email){
		
			return this.eventServices.eventByMail(email);
		
	}
	
	
	/*@RequestMapping(value="/eventnonvalid/all/{id}", method=RequestMethod.GET)
	public List<Event> getEventByDemandes(@PathVariable Long id){
		List<Demande> dems = new DemandeRestService.getDemandeUser(id);
		
		List<Event> eventsresult = new ArrayList();
		for (Demande dem:dems) {
			eventsresult.add(dem.getIdEvent()) ;
			}
		
		return eventsresult;
	}*/
	
	
}
