package fr.solutec.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable Long id){
		return userRepo.findById(id);
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public User saveUser(@RequestBody User u){
		return userRepo.save(u);
	}
	
	@RequestMapping(value="/user", method = RequestMethod.PUT)
	public User modifUser(@PathVariable Long id, @RequestBody User u){
		u.setId(id);
		return userRepo.save(u);
	}
}
