package com.prueba.activos.service;

import java.util.List;

import com.prueba.activos.model.EmpleadoModel;

public interface EmpleadoService {
	
	public void crearEmpleado(EmpleadoModel empleado);
	public void actualizarEmpleado(EmpleadoModel empleado);
	public void borrarEmpleado(long id);
	public List<EmpleadoModel> obtenerEmpleados();
	public EmpleadoModel obtenerPorId(long id);
	public List<EmpleadoModel> obtenerPorNo(String noPersonal);
	public List<EmpleadoModel> obtenerPorCedula(String cedula);
	public List<EmpleadoModel> obtenerPorCargo(String cargo);
	public List<EmpleadoModel> obtenerPorArea(String area);

}
