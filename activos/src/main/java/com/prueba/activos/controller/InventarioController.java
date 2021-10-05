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
import com.prueba.activos.model.InventarioModel;
import com.prueba.activos.model.Mensaje;
import com.prueba.activos.service.InventarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/inventario")
public class InventarioController {
	
	@Autowired
	InventarioService servicio;

	@PostMapping("/inventario")
	public ResponseEntity<?> crearInventario(@RequestBody InventarioModel inventario) {

		servicio.crearInventario(inventario);
		
		return new ResponseEntity<> (
				new Mensaje(
						HttpStatus.OK,
						"Inventario creado con exito",
						new Gson().toJson(inventario)
						)
				,
				HttpStatus.OK
				);				
	}

	@PutMapping("/inventario/{id}")
	public ResponseEntity<?> actualizarInventario(@RequestBody InventarioModel inventario) {
		
		@SuppressWarnings("unused")
		InventarioModel tempInv = servicio.obtenerPorId(inventario.getId());
		
		servicio.actualizarInventario(inventario);
		
		return new ResponseEntity<> (
				new Mensaje(
						HttpStatus.OK,
						"Inventario actualizado con exito",
						new Gson().toJson(inventario)
						)
				,
				HttpStatus.OK
				);				
	}

	@DeleteMapping("/inventario/{id}")
	public ResponseEntity<?> borrarInventario(@PathVariable long id) {
		
		InventarioModel tempInv = servicio.obtenerPorId(id);
		
		servicio.borrarInventario(id);
		
		return new ResponseEntity<> (
				new Mensaje(
						HttpStatus.OK,
						"Inventario actualizado con exito",
						new Gson().toJson(tempInv)
						)
				,
				HttpStatus.OK
				);		
	}

	@GetMapping("")
	public ResponseEntity<?> obtenerInventario() {
		
		return new ResponseEntity<> (
				servicio.obtenerInventario(),
				HttpStatus.OK
				);	
	}

	@GetMapping("/inventario/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable long id) {

		return new ResponseEntity<> (
				servicio.obtenerInventario(),
				HttpStatus.OK
				);	
	}

	@GetMapping("/inventario/no/{no}")
	public ResponseEntity<?> obtenerPorNoInventario(@PathVariable String no) {
		
		return new ResponseEntity<> (
				servicio.obtenerPorNoInventario(no),
				HttpStatus.OK
				);	
	}

	@GetMapping("/inventario/noasig/{noasig}")
	public ResponseEntity<?> obtenerPorNoAsignacion(String noAsig) {
		
		return new ResponseEntity<> (
				servicio.obtenerPorNoAsignacion(noAsig),
				HttpStatus.OK
				);
	}

	@GetMapping("/inventario/tipo/{tipo}")
	public ResponseEntity<?> obtenerPorAsignacionTipo(String tipo) {
		
		return new ResponseEntity<> (
				servicio.obtenerPorAsignacionTipo(tipo),
				HttpStatus.OK
				);
	}

}
