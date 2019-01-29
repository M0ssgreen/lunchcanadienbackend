package fr.solutec;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.solutec.dao.DemandeRepository;
import fr.solutec.dao.EventRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Demande;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "fr.solutec.dao")
@ComponentScan(basePackages = {"fr.solutec.services", "fr.solutec.web", "fr.solutec.email"})
@SpringBootApplication
public class LunchcanadienApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LunchcanadienApplication.class, args);
	}
	

}

