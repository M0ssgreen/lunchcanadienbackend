package fr.solutec.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		
		
		List<User> lstUser = new ArrayList();
		List<Event> lstEvent = new ArrayList();
		User user = new User();
		UserServices userS = new UserServices();
		EventServices eventS = new EventServices();
		lstUser=userS.getIdByMail(mail);
		lstEvent = eventS.getIdByDate(date);
		Event event = new Event();
		
		if (lstUser==null) {
			user.setMail(mail);
			user.setEntreprise(entreprise);
			user.setNom(nom);
			user.setPrenom(prenom);
			user = userS.createUser(user);
			lstUser=userS.getIdByMail(mail);
			
			
		}
		user=lstUser.get(0);
		if (lstEvent==null) {
			event.setDate(date);
			event = eventS.createEvent(event);
			lstEvent = eventS.getIdByDate(date);
		}
		event=lstEvent.get(0);
		Demande demande = new Demande(event, user);
		createDemande(demande);
		
	}
	public void createDemande(Demande demande) {
		demandeRepo.save(demande);
	}
	
}
