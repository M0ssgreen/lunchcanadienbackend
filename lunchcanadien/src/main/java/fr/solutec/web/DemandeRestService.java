package fr.solutec.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.DemandeRepository;
import fr.solutec.entities.Demande;

@RestController
@CrossOrigin("*")
public class DemandeRestService {
	
	@Autowired
	private DemandeRepository demandeRepo;
	
	@RequestMapping(value="/demandes", method=RequestMethod.GET)
	public List<Demande> getDemande(){
		return demandeRepo.findAll();
	}
	
	@RequestMapping(value="/demandes/{id}", method=RequestMethod.GET)
	public Demande getUneDemande(@PathVariable Long id){
		return demandeRepo.findOne(id);
	}
	

	@RequestMapping(value="/demandes", method=RequestMethod.POST)
	public Demande saveDemande(Demande d) {
		return demandeRepo.save(d);
	}
	

	@RequestMapping(value="/demandeuser/{id}", method=RequestMethod.GET)
	public List<Demande> getDemandeUser(@PathVariable Long id){
		List<Demande> dems = demandeRepo.findAll();
		List<Demande> demsresult = new ArrayList();
		for (Demande dem:dems) {
			if (dem.getUser().getId()==id) {
				demsresult.add(dem);
			}
		}
		return demsresult;
	}
	
	
	
	


}
