package fr.solutec.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.AdresseRepository;
import fr.solutec.entities.Adresse;
import fr.solutec.services.AdresseServices;


@RestController
@CrossOrigin("*")
public class AdresseRestService {
	
	@Autowired
	private AdresseRepository ar;
	
	
	@RequestMapping(value="/adresses", method=RequestMethod.GET)
	public List<Adresse> getAdresses(){
		return ar.findAll();
	}
	
	@RequestMapping(value="/adresse", method=RequestMethod.POST)
	public Adresse createAdresse(@RequestBody Adresse adresse){
		return ar.save(adresse);
	}
}
