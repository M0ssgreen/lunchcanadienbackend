package fr.solutec;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "fr.solutec.entities") 
@EnableJpaRepositories(basePackages = "fr.solutec.dao")
@ComponentScan(basePackages = {"fr.solutec.services", "fr.solutec.web"})
@SpringBootApplication
public class LunchcanadienApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LunchcanadienApplication.class, args);
	}
	

}

