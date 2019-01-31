package fr.solutec.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.EntrepriseRepository;
import fr.solutec.entities.Entreprise;

@RestController
@CrossOrigin("*")
public class EntrepriseRestService {
	
	@Autowired
	private EntrepriseRepository er;
	
	@RequestMapping(value="/entreprises", method=RequestMethod.GET)
	public List<Entreprise> getEntreprises(){
		return this.er.findAll();
	}
	
	@RequestMapping(value="/entreprise/{id}", method=RequestMethod.GET)
	public Entreprise getEntreprise(@PathVariable Long id){
		return er.findById(id).get();
	}
	
	@RequestMapping(value="/entreprise/{nom}", method=RequestMethod.GET)
	public Long getIdByEntreprise(@PathVariable String nom) {
		return  er.findByNom(nom).get(0).getId();
	}
	
}
