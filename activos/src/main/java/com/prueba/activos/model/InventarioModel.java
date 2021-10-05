package com.prueba.activos.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "inventario")
@EntityListeners(AuditingEntityListener.class)
public class InventarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String noInventario;
	
	@NotBlank
	private String noAsignacion;
	
	@NotBlank
	private String asignacionTipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNoInventario() {
		return noInventario;
	}

	public void setNoInventario(String noInventario) {
		this.noInventario = noInventario;
	}

	public String getNoAsignacion() {
		return noAsignacion;
	}

	public void setNoAsignacion(String noAsignacion) {
		this.noAsignacion = noAsignacion;
	}

	public String getAsignacionTipo() {
		return asignacionTipo;
	}

	public void setAsignacionTipo(String asignacionTipo) {
		this.asignacionTipo = asignacionTipo;
	}

	@Override
	public String toString() {
		return "InventarioModel [id=" + id + ", noInventario=" + noInventario + ", noAsignacion=" + noAsignacion
				+ ", asignacionTipo=" + asignacionTipo + "]";
	}	

}
