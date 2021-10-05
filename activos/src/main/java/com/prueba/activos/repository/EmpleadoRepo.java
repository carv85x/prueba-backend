package com.prueba.activos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.activos.model.EmpleadoModel;

public interface EmpleadoRepo extends JpaRepository<EmpleadoModel, Long>{
	
	public List<EmpleadoModel> findByNoPersonal(String noPersonal);
	public List<EmpleadoModel> findByCedula(String cedula);
	public List<EmpleadoModel> findByCargo(String cargo);
	public List<EmpleadoModel> findByArea(String area);
	
}
