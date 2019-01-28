package fr.solutec.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.services.EventServices;
import fr.solutec.services.UserServices;
import fr.solutec.dao.DemandeRepository;

@Service
public class DemandeServices {
	private DemandeRepository demandeRepository;
	private EventServices eventServices;
	private UserServices userServices;
	
	@Autowired
	public DemandeServices(DemandeRepository demandeRepository, EventServices eventServices,
			UserServices userServices) {
		super();
		this.demandeRepository = demandeRepository;
		this.eventServices = eventServices;
		this.userServices = userServices;
	}

	public void matchEvent(Demande demande) {		

		List<User> users = this.userServices.getByMail(demande.getUser().getMail());
		List<Event> events  = this.eventServices.getIdByDate(demande.getEvent().getDate());
		if (users.isEmpty()) {
			users = new ArrayList<User>();
			users.add(this.userServices.createUser(demande.getUser()));
		}
		
		if (events.isEmpty()) {
			events = new ArrayList<Event>();
			events.add(this.eventServices.createEvent(demande.getEvent()));
		}
		
		this.demandeRepository.save(new Demande(events.get(0), users.get(0)));
		
	}

	public void createDemande(Demande demande) {
		this.demandeRepository.save(demande);
	}
	
}
