package com.prueba.activos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.activos.model.InventarioModel;

public interface InventarioRepo extends JpaRepository<InventarioModel, Long>{
	
	public List<InventarioModel> findByNoInventario(String noInventario);
	public List<InventarioModel> findByNoAsignacion(String noAsignacion);
	public List<InventarioModel> findByAsignacionTipo(String asignacionTipo);

}
