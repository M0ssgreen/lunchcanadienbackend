package fr.solutec.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

}

