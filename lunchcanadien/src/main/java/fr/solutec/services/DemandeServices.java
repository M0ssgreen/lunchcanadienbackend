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
	private static DemandeRepository demandeRepo;
	
	
	public static void matchEvent(String mail, Date date, String prenom, String nom, String entreprise) {
		User user = new User();
		user=UserServices.getIdByMail(mail);
		Event event = new Event();
		event = EventServices.getIdByDate(date);
		if (user==null) {
			user.setMail(mail);
			user.setEntreprise(entreprise);
			user.setNom(nom);
			user.setPrenom(prenom);
			user = UserServices.createUser(user);
			user=UserServices.getIdByMail(mail);
			
		}
		if (event==null) {
			event.setDate(date);
			event = EventServices.createEvent(event);
			event = EventServices.getIdByDate(date);
		}
		Demande demande = new Demande(event, user);
		createDemande(demande);
		
	}
	public static void createDemande(Demande demande) {
		demandeRepo.save(demande);
	}
	
}
