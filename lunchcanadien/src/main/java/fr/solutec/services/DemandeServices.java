package fr.solutec.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.services.EventServices;
import fr.solutec.services.UserServices;
import fr.solutec.dao.DemandeRepository;

@RestController
@CrossOrigin("*")
public class DemandeServices {
	
	@Autowired
	private DemandeRepository demandeRepo;
	
	
	public void matchEvent(Demande d) {
		String mail = d.getUser().getMail();
		String prenom = d.getUser().getPrenom();
		String nom = d.getUser().getNom();
		String entreprise = d.getUser().getEntreprise();
		Date date = d.getEvent().getDate();
		
		
		
		
		User user = new User();
		UserServices userS = new UserServices();
		EventServices eventS = new EventServices();
		user=userS.getIdByMail(mail);
		Event event = new Event();
		event = eventS.getIdByDate(date);
		if (user==null) {
			user.setMail(mail);
			user.setEntreprise(entreprise);
			user.setNom(nom);
			user.setPrenom(prenom);
			user = userS.createUser(user);
			user=userS.getIdByMail(mail);
			
		}
		if (event==null) {
			event.setDate(date);
			event = eventS.createEvent(event);
			event = eventS.getIdByDate(date);
		}
		Demande demande = new Demande(event, user);
		createDemande(demande);
		
	}
	public void createDemande(Demande demande) {
		demandeRepo.save(demande);
	}
	
}
