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
@Table(name = "areas")
@EntityListeners(AuditingEntityListener.class)
public class AreaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String noArea;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String descripcion;
	
	@NotBlank
	private String ciudad;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNoArea() {
		return noArea;
	}

	public void setNoArea(String noArea) {
		this.noArea = noArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "AreaModel [id=" + id + ", noArea=" + noArea + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", ciudad=" + ciudad + "]";
	}	

}
