package fr.solutec.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.UserRepository;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class UserRestService {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> getUsers(@RequestParam("email") String email){
		if (email != null) {
			return this.userRepo.findByEmail(email);
		}
		return userRepo.findAll();
	}
	//bite
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable Long id){
		return userRepo.findById(id).get();
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public User saveUser(@RequestBody User u){
		return userRepo.save(u);
	}
		
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
	public User modifUser(@PathVariable Long id, @RequestBody User u){
		 u.setId(id);
		 return userRepo.save(u);
	}
	
	

}




