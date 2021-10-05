package com.prueba.activos.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.activos.model.EmpleadoModel;
import com.prueba.activos.repository.EmpleadoRepo;
import com.prueba.activos.service.EmpleadoService;

@Service
public class EmpleadoServicioImpl implements EmpleadoService{
	
	@Autowired
	EmpleadoRepo repo;

	@Override
	public void crearEmpleado(EmpleadoModel empleado) {
		repo.save(empleado);		
	}

	@Override
	public void actualizarEmpleado(EmpleadoModel empleado) {
		repo.save(empleado);
		
	}

	@Override
	public void borrarEmpleado(long id) {
		repo.deleteById(id);		
	}

	@Override
	public List<EmpleadoModel> obtenerEmpleados() {
		return repo.findAll();
	}

	@Override
	public EmpleadoModel obtenerPorId(long id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new EntityNotFoundException("Empleado con id: " + id + " no fue encontrado");
		}
	}

	@Override
	public List<EmpleadoModel> obtenerPorNo(String noPersonal) {
		if(repo.findByNoPersonal(noPersonal).size() > 0) {
			return repo.findByNoPersonal(noPersonal);
		} else {
			throw new EntityNotFoundException("Empleado con no: " + noPersonal + " no fue encontrado");
		}
	}

	@Override
	public List<EmpleadoModel> obtenerPorCedula(String cedula) {
		if(repo.findByCedula(cedula).size() > 0) {
			return repo.findByCedula(cedula);
		} else {
			throw new EntityNotFoundException("Empleado con cedula: " + cedula + " no fue encontrado");
		}
	}

	@Override
	public List<EmpleadoModel> obtenerPorCargo(String cargo) {
		if(repo.findByCargo(cargo).size() > 0) {
			return repo.findByCargo(cargo);
		} else {
			throw new EntityNotFoundException("Empleado con cargo: " + cargo + " no fue encontrado");
		}
	}

	@Override
	public List<EmpleadoModel> obtenerPorArea(String area) {
		if(repo.findByArea(area).size() > 0) {
			return repo.findByArea(area);
		} else {
			throw new EntityNotFoundException("Empleado con area: " + area + " no fue encontrado");
		}
	}

}
