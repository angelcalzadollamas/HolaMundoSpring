package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Individuo;
import com.example.service.IndividuoService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorREST {
	
	// Autowired para poder injectar nuestro Dao
	@Autowired
	private IndividuoService individuoService;

	// Declarar variables desde application.properties
	@Value("${indice.hola2}")
	private String hola2;
	
	@GetMapping("/")
	public String comienzo(Model model) {
		
		// pasarle a nuestro controlador los individuos
		List<Individuo> individuos = individuoService.listaIndividuos();
		
		String hola = "Estamos probando mensajes";
		
		log.info("Estoy ejecutando el controlador MVC");
		model.addAttribute("hola", hola);
		model.addAttribute("hola2", hola2);
		model.addAttribute("individuos", individuos);
		
		return "indice";
	}
	
	// Controlador que nos lleva al formulario
	// Recibe un objeto de tipo individuo porque Spring Boot crea una instancia vacía que se conectará con los valores marcados en el form
	@GetMapping("/anexar")
	public String anexar (Individuo individuo) {
		return "cambiar";
	}
	
	// @Valid para validación
	@PostMapping("/salvar")
	public String salvar(@Valid Individuo individuo, Errors error) {
		// comprobamos si hay errores de validación
		if(error.hasErrors()) {
			return "cambiar";
		}
		
		individuoService.save(individuo);
		return "redirect:/";
	}
	
	@GetMapping("/modificar/{individuoId}")
	public String modificar(@PathVariable Long individuoId, Model model) {
		log.info("valor de individuoId: " + individuoId);
		Individuo individuo = individuoService.findById(individuoId);
		model.addAttribute("individuo", individuo);
		return "cambiar";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Individuo individuo) {
		log.info("se está eliminando el individuo con id: " + individuo.getIdIndividuo());
		individuoService.delete(individuo);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
