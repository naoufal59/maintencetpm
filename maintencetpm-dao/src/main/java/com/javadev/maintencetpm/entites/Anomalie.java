package com.javadev.maintencetpm.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anomalie {
	 @Id
     @GeneratedValue
	 private Long idAnomalie ;
	 private String description;
	 private String typeAnomalie;
	 private String Referrence;
	 private Boolean etat;
	 private Date dateanomalie;
	 @ManyToOne
	 @JoinColumn(name="code_equipement")
	 private Equipement equipement;
}
