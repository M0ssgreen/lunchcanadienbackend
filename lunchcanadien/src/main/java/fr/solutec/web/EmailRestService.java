package fr.solutec.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.services.MailServices;


@RestController
@CrossOrigin("*")
public class EmailRestService {
	
	@Autowired
	private MailServices ms;
	
	
	@RequestMapping(value="/mailDispo", method=RequestMethod.POST)
	public void envMail1(@RequestBody User u) {
		ms.envMail(u);
	}
	
	@RequestMapping(value="/mailConf", method=RequestMethod.POST)
	public void envMailOrga(@RequestBody User user) {
		ms.envMailOrganisateur(user);
	}
	
	@RequestMapping(value="/mailMatch", method=RequestMethod.POST)
	public void envMailGroupe1(@RequestBody List<User> users) {
		ms.envMailGroupe(users);
		
	}
	
	@RequestMapping(value="/mailRappel", method=RequestMethod.POST)
	public void envMailRappel1(@RequestBody List<User> users) {
		ms.envMailRappel(users);
	}
}
