package fr.solutec.services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
@Service
public class EventServices {
	@Autowired
	private static EventRepository eventRepository;
	@Autowired
	private DemandeRepository demandes;
	@Autowired
	private UserRepository userRepository;
	public List<Event> eventByMail(String mail){
		List<Event> eventFromMail = eventRepository.findAll();
		List<Demande> demandeAll = demandes.findAll();
		User user = userRepository.findByMail(mail).get(0);
		
		for (Demande demande : demandeAll) {
			if (demande.getUser().getId() == user.getId()) {
				eventFromMail.add(eventRepository.findOne(demande.getEvent().getIdEvent()));
			}
		}
		return eventFromMail;
	}
	
	public static Event getIdByDate(Date dateEvent) {
		/*List<Event> listEvent = eventRepository.findAll();
		Event retour = null;
		for (Event event : listEvent) {
			if (dateEvent.equals(event.getDate())) {
				retour=event;
			}
		}
		return retour;*/
		return eventRepository.findByDate(dateEvent);
	}
	
	public static Event createEvent(Event event) {
		
		return eventRepository.save(event);
	}		

}
