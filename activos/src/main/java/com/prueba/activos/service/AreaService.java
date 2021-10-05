package com.prueba.activos.service;

import java.util.List;

import com.prueba.activos.model.AreaModel;

public interface AreaService {

	public void crearArea(AreaModel area);
	public void actualizarArea(AreaModel area);
	public void borrarArea(long id);
	public AreaModel obtenerAreaPorId(long id);
	public List<AreaModel> obtenerAreaPorNo(String noArea);
	public List<AreaModel> obtenerAreas();
}
