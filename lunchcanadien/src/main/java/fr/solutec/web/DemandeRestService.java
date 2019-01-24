package fr.solutec.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.DemandeRepository;
import fr.solutec.entities.Demande;

@RestController
public class DemandeRestService {
	
	@Autowired
	private DemandeRepository demandeRepo;
	
	@RequestMapping(value="/demandes", method=RequestMethod.GET)
	public List<Demande> getDemande(){
		return demandeRepo.findAll();
	}
	

}
