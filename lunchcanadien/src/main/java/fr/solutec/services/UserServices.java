package fr.solutec.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.web.*;
import groovyjarjarasm.asm.util.Printer;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> getByMail(String mail) {
		return this.userRepo.findByMail(mail);		
	}
	
	public User createUser(User user) {
		
		return userRepo.save(user);
	}
}