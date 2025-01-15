package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IndividuoDao;
import com.example.domain.Individuo;

// injectar esta clase como implementación del IndividuoService
@Service
public class IndividuoServiceImpl implements IndividuoService {
	
	@Autowired
	private IndividuoDao individuoDao;

	@Override
	@Transactional(readOnly=true)
	public List<Individuo> listaIndividuos() {
		return (List<Individuo>) individuoDao.findAll();
	}

	@Override
	// para que solo se modifique la base de datos (commit) en caso que todas las iteraciones sean exitosas
	@Transactional
	public void save(Individuo individuo) {
		individuoDao.save(individuo);
	}

	@Override
	@Transactional
	public void delete(Individuo individuo) {
		individuoDao.delete(individuo);
	}

	@Override
	@Transactional(readOnly=true)
	public Individuo findById(Long idIndividuo) {
		return individuoDao.findById(idIndividuo).orElse(null);
	}

}
