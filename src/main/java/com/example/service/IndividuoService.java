package com.example.service;

import java.util.List;

import com.example.domain.Individuo;

public interface IndividuoService {

	// métodos para nuestro CRUD
	
	public List<Individuo> listaIndividuos();
	
	public void save(Individuo individuo);
	
	public void delete(Individuo individuo);
	
	public Individuo findById(Long idIndividuo);
	
}
