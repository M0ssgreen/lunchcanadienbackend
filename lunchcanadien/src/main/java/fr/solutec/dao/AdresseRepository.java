package fr.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import fr.solutec.entities.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
