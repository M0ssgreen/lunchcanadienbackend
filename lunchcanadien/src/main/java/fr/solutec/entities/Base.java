package fr.solutec.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class Base {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    private Long id;

    //@JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false)
    private Instant creation;

    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false)
    private Instant maj;

    
    
	public Base() {
		super();
	}
	
	

	public Base(Long id, Instant creation, Instant maj) {
		super();
		this.id = id;
		this.creation = creation;
		this.maj = maj;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreation() {
		return creation;
	}

	public void setCreation(Instant creation) {
		this.creation = creation;
	}

	public Instant getMaj() {
		return maj;
	}

	public void setMaj(Instant maj) {
		this.maj = maj;
	}
    
    
}


