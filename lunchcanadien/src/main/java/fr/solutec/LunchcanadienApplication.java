package fr.solutec;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;

@SpringBootApplication
public class LunchcanadienApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepos;
	private DemandeRepository demandeRepos;
	private EventRepository eventRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(LunchcanadienApplication.class, args);
	}

	@Override //ajout de données dans la bdd user
	public void run(String... args) throws Exception {
		userRepos.save(new User("toto", "jojo", "toto@gmail.com", "123456", "Solutec"));
		//demandeRepos.save(new Demande ( new Date(2018, 01, 24, 12, 00, 00), new Date(2018, 01, 24, 14, 00, 00)));
		//eventRepos.save(new Event(3, new Date(2018, 01, 24, 12, 00, 00), new Date(2018, 01, 24, 14, 00, 00), false));
		
	}

}

