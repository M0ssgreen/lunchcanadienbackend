package fr.solutec.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByMail(String mail);
}
