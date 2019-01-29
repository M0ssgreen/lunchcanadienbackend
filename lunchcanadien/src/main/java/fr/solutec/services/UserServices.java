package fr.solutec.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.web.*;

@Service
public class UserServices {
	
	private DemandeServices demandeServices;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getByMail(String mail) {

		return this.userRepo.findByEmail(mail);
	}
	
	public User createUser(User user) {
		
		return userRepo.save(user);
	}
	public List<User> getUserByEvent(Event event){
		List<Demande> demandes = this.demandeServices.getDemandesByEvent(event);
		List<User> users= new ArrayList();
		for (Demande d:demandes) {
			users.add(userRepo.findById(d.getUser().getId()).get());
		}
		return users;
	}
}
