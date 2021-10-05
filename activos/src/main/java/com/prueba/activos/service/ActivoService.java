package com.prueba.activos.service;

import java.util.Date;
import java.util.List;

import com.prueba.activos.model.ActivoModel;

public interface ActivoService {
	
	public void crearActivo(ActivoModel activo);
	public void actualizarActivo(ActivoModel activo);
	public void borrarActivo(long id);
	public List<ActivoModel> obtenerActivos();
	public ActivoModel obtenerActivoPorId(long id);
	public List<ActivoModel> obtenerActivoPorSerial(String serial);
	public List<ActivoModel> obtenerActivosPorFecha(Date fechaCompra);
	public List<ActivoModel> obtenerActivosPorTipo(String tipo);

}
