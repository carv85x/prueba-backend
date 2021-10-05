package com.prueba.activos.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.activos.model.InventarioModel;
import com.prueba.activos.repository.InventarioRepo;
import com.prueba.activos.service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService{
	
	@Autowired
	InventarioRepo repo;

	@Override
	public void crearInventario(InventarioModel inventario) {
		repo.save(inventario);		
	}

	@Override
	public void actualizarInventario(InventarioModel inventario) {
		repo.save(inventario);
	}

	@Override
	public void borrarInventario(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<InventarioModel> obtenerInventario() {
		return repo.findAll();
	}

	@Override
	public InventarioModel obtenerPorId(long id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new EntityNotFoundException("Inventario con id: " + id + " no fue encontrado");
		}
	}

	@Override
	public List<InventarioModel> obtenerPorNoInventario(String noInventario) {
		if(repo.findByNoInventario(noInventario).size() > 0) {
			return repo.findByNoInventario(noInventario);
		} else {
			throw new EntityNotFoundException("Inventario con no de inventario: " + noInventario + " no fue encontrado");
		}
	}

	@Override
	public List<InventarioModel> obtenerPorNoAsignacion(String noAsignacion) {
		if(repo.findByNoAsignacion(noAsignacion).size() > 0) {
			return repo.findByNoAsignacion(noAsignacion);
		} else {
			throw new EntityNotFoundException("Inventario con no de no de asignacion: " + noAsignacion + " no fue encontrado");
		}
	}

	@Override
	public List<InventarioModel> obtenerPorAsignacionTipo(String asignacionTipo) {
		if(repo.findByAsignacionTipo(asignacionTipo).size() > 0) {
			return repo.findByAsignacionTipo(asignacionTipo);
		} else {
			throw new EntityNotFoundException("Inventario con no de tipo de asignacion: " + asignacionTipo + " no fue encontrado");
		}
	}

}
