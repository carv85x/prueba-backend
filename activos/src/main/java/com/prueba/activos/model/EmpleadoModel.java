package com.prueba.activos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "empleados")
@EntityListeners(AuditingEntityListener.class)
public class EmpleadoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String noPersonal;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellido;
	
	private Date fechaNacimiento;
	
	@NotBlank
	private String cedula;
	
	@NotBlank
	private String cargo;
	
	@NotBlank 
	private String area;	
	
	public String getNoPersonal() {
		return noPersonal;
	}

	public void setNoPersonal(String noPersonal) {
		this.noPersonal = noPersonal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "EmpleadoModel [id=" + id + ", noPersonal=" + noPersonal + ", nombre=" + nombre + ", apellido="
				+ apellido + ", fechaNacimiento=" + fechaNacimiento + ", cedula=" + cedula + ", cargo=" + cargo
				+ ", area=" + area + "]";
	}
}
