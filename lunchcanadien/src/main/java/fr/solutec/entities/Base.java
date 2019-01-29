package com.ams.back.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
}
