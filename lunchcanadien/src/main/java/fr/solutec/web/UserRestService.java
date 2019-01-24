package fr.solutec.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.solutec.dao.UserRepository;
import fr.solutec.entities.User;

public class UserRestService {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<User> getUsers(){
		return userRepo.findAll();
	}
}
