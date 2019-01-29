package fr.solutec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.solutec.dao.AdresseRepository;
import fr.solutec.entities.Adresse;

@Service
public class AdresseServices {
	
	
	@Autowired
	private AdresseRepository ar;
	
	public Adresse createAdresse(Adresse a) {
		return ar.save(a);
	}	
}
