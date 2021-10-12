package com.prueba.activos.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "inventario")
@EntityListeners(AuditingEntityListener.class)
public class InventarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String noInventario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activo_id")
	private ActivoModel activo;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "area_id", nullable = true)
	private AreaModel area;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empleado_id", nullable = true)
	private EmpleadoModel empleado;
	
	
	@Enumerated(EnumType.STRING)
	private AsignacionTipo asignacionTipo;


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

	@JsonBackReference
	public ActivoModel getActivo() {
		return activo;
	}


	public void setActivo(ActivoModel activo) {
		this.activo = activo;
	}


	public AreaModel getArea() {
		return area;
	}


	public void setArea(AreaModel area) {
		this.area = area;
	}


	public EmpleadoModel getEmpleado() {
		return empleado;
	}


	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}


	public AsignacionTipo getAsignacionTipo() {
		return asignacionTipo;
	}


	public void setAsignacionTipo(AsignacionTipo asignacionTipo) {
		this.asignacionTipo = asignacionTipo;
	}


	@Override
	public String toString() {
		return "InventarioModel [id=" + id + ", noInventario=" + noInventario + ", activo=" + activo + ", area=" + area
				+ ", empleado=" + empleado + ", asignacionTipo=" + asignacionTipo + "]";
	}
	
}
