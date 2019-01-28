package fr.solutec.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	private EventRepository eventRepo;
	
	@Autowired
<<<<<<< HEAD
	private DemandeServices demandeServices;
=======
	private MailServices ms;
>>>>>>> branch 'master' of https://github.com/M0ssgreen/lunchcanadienbackend
	
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
	
	@RequestMapping(value="/mailDispo", method=RequestMethod.POST)
	public void envMail1(@RequestBody User u) {
		ms.envMail(u);
	}
	
	@RequestMapping(value="/mailMatch", method=RequestMethod.POST)
	public void envMailGroupe1(@RequestBody List<User> users) {
		ms.envMailGroupe(users);
		
	}
	
	@RequestMapping(value="/mailRappel", method=RequestMethod.POST)
	public void envMailRappel1(@RequestBody List<User> users) {
		ms.envMailRappel(users);
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
	
	@RequestMapping(value="/eventvalide/{mail}", method=RequestMethod.GET)
	public List<Event> getEventByMail(@PathVariable String mail){
		EventServices eventServices = new EventServices();
		return eventServices.eventByMail(mail);
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
