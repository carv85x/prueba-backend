package com.prueba.activos.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.activos.model.AsignacionTipo;
import com.prueba.activos.model.InventarioModel;
import com.prueba.activos.repository.ActivoRepo;
import com.prueba.activos.repository.AreaRepo;
import com.prueba.activos.repository.EmpleadoRepo;
import com.prueba.activos.repository.InventarioRepo;
import com.prueba.activos.service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService{
	
	@Autowired
	InventarioRepo inventarioRepo;
	
	@Autowired
	ActivoRepo activoRepo;
	
	@Autowired
	AreaRepo areaRepo;
	
	@Autowired
	EmpleadoRepo empleadoRepo;

	@Override
	public void crearInventario(InventarioModel inventario) {
		// Revisar get activo existe
		if(activoRepo.findById(inventario.getActivo().getId()).isPresent()) 
			// Revisar tipo de asignacion (AREA o EMPLEADO)
			if(inventario.getAsignacionTipo().toString().equals("AREA")) {
				// Revisar que area existe
				if(areaRepo.findById(inventario.getArea().getId()).isPresent())
					inventarioRepo.save(inventario);	
				else
					throw new EntityNotFoundException("Area con id: " + inventario.getArea().getId() + " no fue encontrado");	
			} else if (inventario.getAsignacionTipo().toString().equals("EMPLEADO")) {
				// Revisar que empleado existe
				if(empleadoRepo.findById(inventario.getEmpleado().getId()).isPresent())
					inventarioRepo.save(inventario);	
				else
					throw new EntityNotFoundException("Empleado con id: " + inventario.getEmpleado().getId() + " no fue encontrado");	
			} else {
				System.out.println(inventario.getAsignacionTipo());
				throw new EntityNotFoundException("Tipo de Asignacion: " + inventario.getAsignacionTipo() + " no fue encontrado (Usar AREA o EMPLEADO)");
			}
		else
			throw new EntityNotFoundException("Activo con id: " + inventario.getActivo().getId() + " no fue encontrado");
	}

	@Override
	public void actualizarInventario(InventarioModel inventario) {
		// Revisar get activo existe
		if(activoRepo.findById(inventario.getActivo().getId()).isPresent()) 
			// Revisar tipo de asignacion (AREA o EMPLEADO)
			if(inventario.getAsignacionTipo().toString().equals("AREA")) {
				// Revisar que area existe
				if(areaRepo.findById(inventario.getArea().getId()).isPresent())
					inventarioRepo.save(inventario);	
				else
					throw new EntityNotFoundException("Area con id: " + inventario.getArea().getId() + " no fue encontrado");	
			} else if (inventario.getAsignacionTipo().toString().equals("EMPLEADO")) {
				// Revisar que empleado existe
				if(empleadoRepo.findById(inventario.getEmpleado().getId()).isPresent())
					inventarioRepo.save(inventario);	
				else
					throw new EntityNotFoundException("Empleado con id: " + inventario.getEmpleado().getId() + " no fue encontrado");	
			} else {
				System.out.println(inventario.getAsignacionTipo());
				throw new EntityNotFoundException("Tipo de Asignacion: " + inventario.getAsignacionTipo() + " no fue encontrado (Usar AREA o EMPLEADO)");
			}
		else
			throw new EntityNotFoundException("Activo con id: " + inventario.getActivo().getId() + " no fue encontrado");
	}

	@Override
	public void borrarInventario(long id) {
		inventarioRepo.deleteById(id);
	}

	@Override
	public List<InventarioModel> obtenerInventario() {
		return inventarioRepo.findAll();
	}

	@Override
	public InventarioModel obtenerPorId(long id) {
		if(inventarioRepo.findById(id).isPresent()) {
			return inventarioRepo.findById(id).get();
		} else {
			throw new EntityNotFoundException("Inventario con id: " + id + " no fue encontrado");
		}
	}

	@Override
	public List<InventarioModel> obtenerPorNoInventario(String noInventario) {
		if(inventarioRepo.findByNoInventario(noInventario).size() > 0) {
			return inventarioRepo.findByNoInventario(noInventario);
		} else {
			throw new EntityNotFoundException("Inventario con no de inventario: " + noInventario + " no fue encontrado");
		}
	}

	@Override
	public List<InventarioModel> obtenerPorAsignacionTipo(String asignacionTipo) {
		
		// Validar asignacionTipo 
		AsignacionTipo enumTipo;
		if(asignacionTipo != null && !asignacionTipo.equals(""))			
			enumTipo = AsignacionTipo.valueOf(asignacionTipo.toUpperCase());
		else
			throw new IllegalArgumentException("Tipo de Asignacion tiene que ser AREA o EMPLEADO");
		
		if(inventarioRepo.findByAsignacionTipo(enumTipo).size() > 0) {
			return inventarioRepo.findByAsignacionTipo(enumTipo);
		} else {
			throw new IllegalArgumentException("Inventario con no de tipo de asignacion: " + enumTipo + " no fue encontrado");
		}
	}

}
