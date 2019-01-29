package fr.solutec.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.OneToMany;

@Entity
@Table(name = "EVENEMENT")
public class Event extend Base {

	private Instant quantieme;
	
	
}
