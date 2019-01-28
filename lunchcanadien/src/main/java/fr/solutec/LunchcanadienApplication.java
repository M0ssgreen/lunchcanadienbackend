package fr.solutec;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.email.MailServices;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;


@SpringBootApplication
public class LunchcanadienApplication {

	//@Autowired
	//private MailServices mailServices;
	/*
	@Autowired
	private UserRepository userRepos;
	@Autowired
	private DemandeRepository demandeRepos;
	@Autowired
	private EventRepository eventRepos;
	*/

	
	public static void main(String[] args) {
		SpringApplication.run(LunchcanadienApplication.class, args);
	}

	//@Override //ajout de données dans la bdd user
	public void run(String... args) throws Exception {
		//userRepos.save(new User("toto", "jojo", "toto@gmail.com", "123456", "Solutec"));
		//demandeRepos.save(new Demande ( new Date(2018, 01, 24, 12, 00, 00), new Date(2018, 01, 24, 14, 00, 00)));
		//eventRepos.save(new Event(3, Datetime(2018-01-24 12:00:00), new Date(2018, 01, 24, 14, 00, 00), false));
		String contenuMail = "Hello";
		String sujetMail = "Test2";
		String mailDestinataire = "anais.poujouly@hotmail.fr";
		MailServices mailServices = new MailServices();
		mailServices.envoyerMail(contenuMail, mailDestinataire, sujetMail);
	}

}

