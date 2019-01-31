package fr.solutec.services;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import fr.solutec.entities.Demande;
import fr.solutec.entities.Entreprise;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.services.EventServices;
import fr.solutec.services.UserServices;
import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EntrepriseRepository;

@Service
public class DemandeServices {
	@Autowired
	private DemandeRepository demandeRepository;
	private EventServices eventServices;
	private UserServices userServices;
	private MailServices mailServices;
	private EntrepriseRepository entrepriseRepo;
	
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

		List<Event> events  = eventServices.eventParEntreprise(this.eventServices.getIdByDate(demande.getEvent().getQuantieme()), users.get(0).getId());
		
		if (users.isEmpty()) {
			
			Entreprise entreprise = new Entreprise();
			entreprise.setId(demande.getUser().getId());
			demande.getUser().setEntreprise(entreprise);
			demande.getUser().setId(null);
			users.add(this.userServices.createUser(demande.getUser()));
		}
				
		if (events.isEmpty()) {
			demande.getEvent().setNom(null);
			events.add(this.eventServices.createEvent(demande.getEvent()));
		}
		while (nombreParticipant(events.get(0))>=6) {
			events.remove(0);
		}
		
		this.demandeRepository.save(new Demande(events.get(0), users.get(0)));
		
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
	public Demande getDemandeBy(String email, Long idEv) {
		List<Demande> lstDem = demandeRepository.findAll();
		while (!(lstDem.get(0).getUser().getEmail().equals(email) && lstDem.get(0).getEvent().getId().equals(idEv))) {
			lstDem.remove(0);
		}
		
		return lstDem.get(0);
	}
	
	public Demande saveComment(Demande d) {
		List<Demande> lstDemande= new ArrayList();
		lstDemande.add(getDemandeBy(d.getUser().getEmail(), d.getEvent().getId()));
		lstDemande.get(0).setCommentaire(d.getCommentaire());
		lstDemande.get(0).setNote(d.getNote());
		
		
		return demandeRepository.save(lstDemande.get(0));
	}

	
}
