package fr.solutec.services;

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
	
	@Autowired
	private DemandeRepository demandeRepo;
	
	@Autowired
	private EventServices eventServices;
	
	@Autowired
	private UserServices userServices;
	
	public void matchEvent(Demande d) {
		String mail = d.getUser().getMail();
		String prenom = d.getUser().getPrenom();
		String nom = d.getUser().getNom();
		String entreprise = d.getUser().getEntreprise();
		Date date = d.getEvent().getDate();
		
	
		User user = new User();
		List<User> lstUser = this.userServices.getByMail(mail);
		List<Event> lstEvent  = this.eventServices.getIdByDate(date);
		Event event = new Event();
		
		if (lstUser.isEmpty()) {
			user.setMail(mail);
			user.setEntreprise(entreprise);
			user.setNom(nom);
			user.setPrenom(prenom);
			user = this.userServices.createUser(user); 
			lstUser = this.userServices.getByMail(mail);
			
		}
		
		
		user=lstUser.get(0);
		if ( lstEvent.isEmpty()) {
			event.setDate(date);
			event = this.eventServices.createEvent(event);
			lstEvent = this.eventServices.getIdByDate(date);
		}
		event=lstEvent.get(0);
		Demande demande = new Demande(event, user);
		createDemande(demande);
		
	}
	public void createDemande(Demande demande) {
		demandeRepo.save(demande);
	}
	
}
