package com.prueba.activos.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.activos.model.AreaModel;
import com.prueba.activos.repository.AreaRepo;
import com.prueba.activos.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	AreaRepo repo;

	@Override
	public void crearArea(AreaModel area) {
		repo.save(area);
		
	}

	@Override
	public void actualizarArea(AreaModel area) {
		repo.save(area);		
	}

	@Override
	public void borrarArea(long id) {
		repo.deleteById(id);		
	}

	@Override
	public AreaModel obtenerAreaPorId(long id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new EntityNotFoundException("Area con id: " + id + " no fue encontrada");
		}		
	}

	@Override
	public List<AreaModel> obtenerAreaPorNo(String noArea) {
		if(repo.findByNoArea(noArea).size() > 0) {
			return repo.findByNoArea(noArea);
		} else {
			throw new EntityNotFoundException("Area con Numero de Area: " + noArea + " no fue encontrada");
		}		
	}

	@Override
	public List<AreaModel> obtenerAreas() {
		return repo.findAll();
	}
	
	
}
