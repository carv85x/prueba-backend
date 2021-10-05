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
import com.prueba.activos.model.AreaModel;
import com.prueba.activos.model.Mensaje;
import com.prueba.activos.service.AreaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/areas")
public class AreaController {
	
	@Autowired
	AreaService servicio;
	
	@PostMapping("/area")
	public ResponseEntity<?> crearArea(@RequestBody AreaModel area) {
		
		servicio.crearArea(area);
		
		return new ResponseEntity<>(
				new Mensaje(
						HttpStatus.OK,
						"Area creada con exito",
						new Gson().toJson(area)
						)
				,
				HttpStatus.OK
				);
	}
	
	@PutMapping("/area/{id}")
	public ResponseEntity<?> actualizarArea(@RequestBody AreaModel area) {
		
		@SuppressWarnings("unused")
		AreaModel tempArea = servicio.obtenerAreaPorId(area.getId());
		
		servicio.actualizarArea(area);
		
		return new ResponseEntity<>(
				new Mensaje(
						HttpStatus.OK,
						"Area actualizada con exito",
						new Gson().toJson(area)
						)
				,
				HttpStatus.OK
				);
	}
	
	@DeleteMapping("/area/{id}")
	public ResponseEntity<?> borrarArea(@PathVariable long id) {
		
		AreaModel tempArea = servicio.obtenerAreaPorId(id);
		
		servicio.borrarArea(id);
		
		return new ResponseEntity<>(
				new Mensaje(
						HttpStatus.OK,
						"Area borrada con exito",
						new Gson().toJson(tempArea)
						)
				,
				HttpStatus.OK
				);		
	}
	
	@GetMapping("/area/{id}")
	public ResponseEntity<?> obtenerAreaPorId(@PathVariable long id) {
		
		return new ResponseEntity<>(
				servicio.obtenerAreaPorId(id),
				HttpStatus.OK
				);		
	}
	
	@GetMapping("/area/no/{no}")
	public ResponseEntity<?> obtenerAreaPorNo(@PathVariable String no) {
		
		return new ResponseEntity<>(
				servicio.obtenerAreaPorNo(no),
				HttpStatus.OK
				);		
	}
	
	@GetMapping("")
	public ResponseEntity<?> obtenerAreas() {
		
		return new ResponseEntity<>(
				servicio.obtenerAreas(),
				HttpStatus.OK
				);	
	}	

}
