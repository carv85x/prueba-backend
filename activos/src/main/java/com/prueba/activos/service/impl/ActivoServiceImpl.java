package com.prueba.activos.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.activos.model.ActivoModel;
import com.prueba.activos.repository.ActivoRepo;
import com.prueba.activos.service.ActivoService;

@Service
public class ActivoServiceImpl implements ActivoService {
	
	@Autowired
	ActivoRepo repo;

	@Override
	public void crearActivo(ActivoModel activo) {
		repo.save(activo);		
	}

	@Override
	public void actualizarActivo(ActivoModel activo) {
		repo.save(activo);		
	}

	@Override
	public void borrarActivo(long id) {
		repo.deleteById(id);	
	}

	@Override
	public List<ActivoModel> obtenerActivos() {
		return repo.findAll();
	}

	@Override
	public ActivoModel obtenerActivoPorId(long id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new EntityNotFoundException("Activo con id: " + id + " no fue encontrado");
		}
	}

	@Override
	public List<ActivoModel> obtenerActivoPorSerial(String serial) {
		if(repo.findBySerial(serial).size() > 0) {
			return repo.findBySerial(serial);
		} else {
			throw new EntityNotFoundException("Activo con serial: " + serial + " no fue encontrado");
		}
	}

	@Override
	public List<ActivoModel> obtenerActivosPorFecha(Date fechaCompra) {
		if(repo.findByFechaCompra(fechaCompra).size() > 0) {
			return repo.findByFechaCompra(fechaCompra);
		} else {
			throw new EntityNotFoundException("Activo con fechaCompra: " + fechaCompra + " no fue encontrado");
		}
	}

	@Override
	public List<ActivoModel> obtenerActivosPorTipo(String tipo) {
		if(repo.findByTipo(tipo).size() > 0) {
			return repo.findByTipo(tipo);
		} else {
			throw new EntityNotFoundException("Activo con tipo: " + tipo + " no fue encontrado");
		}
	}

}
