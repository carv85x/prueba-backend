package com.prueba.activos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.prueba.activos.model.EmpleadoModel;
import com.prueba.activos.model.Mensaje;
import com.prueba.activos.service.EmpleadoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService servicio;

	@PostMapping("/empleado")
	public ResponseEntity<?> createEmpleado(@RequestBody EmpleadoModel empleado) {
		
		servicio.crearEmpleado(empleado);
		
		return new ResponseEntity<>(
				new Mensaje(
						HttpStatus.OK,
						"Empleado creado con exito",
						new Gson().toJson(empleado)
						)
				,
				HttpStatus.OK
				);
	}

	@PutMapping("/empleado/{id}")
	public ResponseEntity<?> actualizarEmpleado(@RequestBody EmpleadoModel empleado) {
		
		@SuppressWarnings("unused")
		EmpleadoModel tempEmp = servicio.obtenerPorId(empleado.getId());
		
		servicio.crearEmpleado(empleado);
		
		return new ResponseEntity<>(
				new Mensaje(
						HttpStatus.OK,
						"Empleado actualizado con exito",
						new Gson().toJson(empleado)
						)
				,
				HttpStatus.OK
				);
		
	}

	@DeleteMapping("/empleado/{id}")
	public ResponseEntity<?> borrarEmpleado(@PathVariable long id) {
		
		EmpleadoModel tempEmp = servicio.obtenerPorId(id);
		
		servicio.borrarEmpleado(id);
		
		return new ResponseEntity<>(
				new Mensaje(
						HttpStatus.OK,
						"Empleado borrado con exito",
						new Gson().toJson(tempEmp)
						)
				,
				HttpStatus.OK
				);
		
	}

	@GetMapping("")
	public ResponseEntity<?> obtenerEmpleados() {
		
		return new ResponseEntity<>(
				servicio.obtenerEmpleados(),
				HttpStatus.OK
				);
	}

	@GetMapping("/empleado/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable long id) {

		return new ResponseEntity<>(
				servicio.obtenerPorId(id),
				HttpStatus.OK
				);
	}

	@GetMapping("/empleado/no/{no}")
	public ResponseEntity<?> obtenerPorNo(@PathVariable String noPersonal) {
		
		return new ResponseEntity<>(
				servicio.obtenerPorNo(noPersonal),
				HttpStatus.OK
				);
	}

	@GetMapping("/empleado/cedula/{cedula}")
	public ResponseEntity<?> obtenerPorCedula(@PathVariable String cedula) {
		
		return new ResponseEntity<>(
				servicio.obtenerPorCedula(cedula),
				HttpStatus.OK
				);
	}

	@GetMapping("/empleado/cargo/{cargo}")
	public ResponseEntity<?> obtenerPorCargo(@PathVariable String cargo) {
		
		return new ResponseEntity<>(
				servicio.obtenerPorCargo(cargo),
				HttpStatus.OK
				);
	}

	@GetMapping("/empleado/area/{area}")
	public ResponseEntity<?> obtenerPorArea(@PathVariable String area) {
		
		return new ResponseEntity<>(
				servicio.obtenerPorArea(area),
				HttpStatus.OK
				);
	}

}
