package com.prueba.activos.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.prueba.activos.model.ActivoModel;
import com.prueba.activos.model.Mensaje;
import com.prueba.activos.service.ActivoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activos")
public class ActivoController {
	
	@Autowired
	ActivoService servicio;
	
	@PostMapping("/activo")
	public ResponseEntity<?> crearActivo(@RequestBody ActivoModel activo) {
		
		servicio.crearActivo(activo);
		
		return new ResponseEntity<> (
				new Mensaje(
						HttpStatus.OK,
						"Activo creado con exito",
						new Gson().toJson(activo)
						)
				,
				HttpStatus.OK
				);					
	}
	
	@PutMapping("/activo/{id}")
	public ResponseEntity<?> actualizarActivo(@RequestBody ActivoModel activo) {
		
		@SuppressWarnings("unused")
		ActivoModel tempActivo = servicio.obtenerActivoPorId(activo.getId());
		
		servicio.actualizarActivo(activo);
		
		return new ResponseEntity<> (
				new Mensaje(
						HttpStatus.OK,
						"Activo actualizado con exito",
						new Gson().toJson(activo)
						)
				,
				HttpStatus.OK
				);					
	}
	
	@DeleteMapping("/activo/{id}")
	public ResponseEntity<?> borrarActivo(@PathVariable long id) {
		
		ActivoModel tempActivo = servicio.obtenerActivoPorId(id);
		
		servicio.borrarActivo(id);
		
		return new ResponseEntity<> (
				new Mensaje(
						HttpStatus.OK,
						"Activo borrado con exito",
						new Gson().toJson(tempActivo)
						)
				,
				HttpStatus.OK
				);			
	}
	
	@GetMapping("")
	public ResponseEntity<?> obtenerActivos() {
		
		return new ResponseEntity<> (
				servicio.obtenerActivos()
				,
				HttpStatus.OK
				);	
	}	
	
	@GetMapping("/activo/{id}")
	public ResponseEntity<?> obtenerActivoPorId(@PathVariable long id) {
	
		return new ResponseEntity<> (
				servicio.obtenerActivoPorId(id)
				,
				HttpStatus.OK
				);	
	}
	
	@GetMapping("/activo/serial/{serial}")
	public ResponseEntity<?> obtenerActivoPorSerial(@PathVariable String serial) {
	
		return new ResponseEntity<> (
				servicio.obtenerActivoPorSerial(serial)
				,
				HttpStatus.OK
				);	
	}
	
	@GetMapping("/activo/fecha/{fecha}")
	public ResponseEntity<?> obtenerActivosPorFecha(@PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
	
		return new ResponseEntity<> (
				servicio.obtenerActivosPorFecha(fecha)
				,
				HttpStatus.OK
				);	
	}
	
	@GetMapping("/activo/tipo/{tipo}")
	public ResponseEntity<?> obtenerActivosPorTipo(@PathVariable String tipo) {
	
		return new ResponseEntity<> (
				servicio.obtenerActivosPorTipo(tipo)
				,
				HttpStatus.OK
				);	
	}

}
