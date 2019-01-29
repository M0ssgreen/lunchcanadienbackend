package fr.solutec.services;
import java.util.ArrayList;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.AdresseRepository;
import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Adresse;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
@Service
public class EventServices {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private DemandeRepository demandes;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdresseRepository adresseRepository;

	
	public List<Event> eventByMail(String email){
		List<Event> eventFromMail = new ArrayList();

		List<Demande> demandeAll = demandes.findAll();

		User user = userRepository.findByEmail(email).get(0);
		
		for (Demande demande : demandeAll) {
			if (demande.getUser().getId() == user.getId()) {
				eventFromMail.add(eventRepository.findById(demande.getEvent().getId()).get());
			}
		}
		return eventFromMail;
	}
	
	public List<Event> getIdByDate(Instant dateEvent) {
		/*List<Event> listEvent = eventRepository.findAll();
		Event retour = null;
		for (Event event : listEvent) {
			if (dateEvent.equals(event.getDate())) {
				retour=event;
			}
		}
		return retour;*/
		return eventRepository.findByQuantieme(dateEvent);
	}
	
	public Event createEvent(Event event) {
		
		return eventRepository.save(event);
	}	
	
	public Event setRestoEvent(Long idEvent, String resto, Long idAdresse) {
		Event e = eventRepository.findById(idEvent).get();
		e.setResto(resto);
		Adresse a = adresseRepository.findById(idAdresse).get();
		e.setAdresse(a);
		return eventRepository.save(e);
	}
	
	public List<User> getEventUsers(Long idEvent) {
		List<User> users = new ArrayList();
		List<User> usersInfo = new ArrayList();
		List<Demande> demandeAll = demandes.findAll();
		
		for (Demande demande : demandeAll) {
			
			if (demande.getEvent().getId()==idEvent) {
				System.out.println(users);
				users.add(demande.getUser());
			}else {System.out.println(users);}
			
		}
		
		return users;
	}

}
