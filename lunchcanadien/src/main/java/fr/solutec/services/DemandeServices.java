package fr.solutec.services;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.solutec.entities.Demande;
import fr.solutec.entities.Entreprise;
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
	private MailServices mailServices;
	
	@Autowired
	public DemandeServices(DemandeRepository demandeRepository, EventServices eventServices,
			UserServices userServices, MailServices mailServices) {
		super();
		this.demandeRepository = demandeRepository;
		this.eventServices = eventServices;
		this.mailServices = mailServices;
		this.userServices = userServices;
	}

	public void matchEvent(Demande demande) {		

		List<User> users = this.userServices.getByMail(demande.getUser().getEmail());

		List<Event> events  = this.eventServices.getIdByDate(demande.getEvent().getQuantieme());
		
		if (users.isEmpty()) {
			Entreprise entreprise = new Entreprise();
			entreprise.setId(101L);
			demande.getUser().setEntreprise(entreprise);
			users.add(this.userServices.createUser(demande.getUser()));
		}
				
		if (events.isEmpty()) {

			events.add(this.eventServices.createEvent(demande.getEvent()));
		}
		while (nombreParticipant(events.get(0))>=6) {
			users.remove(0);
		}
		//try {
		this.demandeRepository.save(new Demande(events.get(0), users.get(0)));
		//} catch (SQLIntegrityConstraintViolationException e) {
		//	System.out.println("disponiblités redondante");
		//}
		mailServices.envMail(users.get(0));
		if (nombreParticipant(events.get(0))==3) {
			mailServices.envMailOrganisateur(users.get(0).getEntreprise().getUser(), events.get(0));
		}
		if ((nombreParticipant(events.get(0))>=4) && (events.get(0).getStatut()==1)) {
			mailServices.envMailGroupe(users);
		}
		
		
		
	}

	public void createDemande(Demande demande) {
		this.demandeRepository.save(demande);
	}
	
	public int nombreParticipant(Event event) {
		List<Demande> lstDemande = demandeRepository.findByEvent(event);
		return lstDemande.size();
	}
	public List<Demande> getDemandesByEvent(Event event){
		List<Demande> lstDemande = demandeRepository.findByEvent(event);
		return lstDemande;
	}
	
	public List<Demande> liste() {
		return this.demandeRepository.findAll();
	}
	

	public List<Demande> listeEnfonctionDeLeventId(Long eventId) {
		return this.demandeRepository.findByEventId(eventId);
	}
	public void saveCommentByMail()

	
}
