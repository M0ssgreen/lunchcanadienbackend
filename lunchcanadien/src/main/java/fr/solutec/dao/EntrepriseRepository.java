package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.solutec.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{

}
