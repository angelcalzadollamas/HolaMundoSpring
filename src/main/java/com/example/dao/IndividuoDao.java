package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.Individuo;

// anteriormente se dejaba class y se ponía @Repository. Ahora tan solo hay que cambiar class por interface
// crud repository es una librería de Spring Data
public interface IndividuoDao extends CrudRepository<Individuo, Long>{

}
