package com.prueba.activos.service;

import java.util.List;

import com.prueba.activos.model.InventarioModel;

public interface InventarioService {
	
	public void crearInventario(InventarioModel inventario);
	public void actualizarInventario(InventarioModel inventario);
	public void borrarInventario(long id);
	public List<InventarioModel> obtenerInventario();
	public InventarioModel obtenerPorId(long id);
	public List<InventarioModel> obtenerPorNoInventario(String noInventario);
	public List<InventarioModel> obtenerPorNoAsignacion(String noAsignacion);
	public List<InventarioModel> obtenerPorAsignacionTipo(String asignacionTipo);

}
