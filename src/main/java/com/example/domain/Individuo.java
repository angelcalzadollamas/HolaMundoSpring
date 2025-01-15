package com.example.domain;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

// uso más facil de getters y setters con lombok
@Data
// que sea una clase de entidad
@Entity
// Anotación para la variante de nombre (en BD con i y en clase con I)
@Table(name = "individuo")
public class Individuo implements Serializable {
	
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIndividuo;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	private String telefono;
	
	@NotEmpty
	@Email
	private String correo;
	
	private String edad;
	
	

}
