package fr.solutec.services;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class EventServices {
	private EventRepository eventRepository;
	private DemandeRepository demandes;
	private UserRepository userRepository;
	public List<Event> eventByMail(String mail){
		List<Event> eventByMail = eventRepository.findAll();
		List<Demande> demandeAll = demandes.findAll();
		User user = userRepository.findByMail(mail);
		
		for (Demande demande : demandeAll) {
			if (demande.getUser().getId() == user.getId()) {
				eventByMail.add(eventRepository.findOne(demande.getEvent().getIdEvent()));
			}
		}
		return eventByMail;
	}
	
	@Autowired
	private static EventRepository eventRepo;
	
	public static Event getIdByDate(Date dateEvent) {
		return eventRepo.findByDate(dateEvent);
	}
	
	public static Event createEvent(Event event) {
		
		return eventRepo.save(event);
	}		

}
