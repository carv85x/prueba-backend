package com.prueba.activos.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Mensaje {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date tiempo;
	private int codigo;
	private String estado;
	private String mensaje;
	private String detalle;

	public Mensaje() {
		tiempo = new Date();
	}
	
	public Mensaje(HttpStatus httpEstado, String mensaje, String detalle) {
		this();
		this.codigo = httpEstado.value();
		this.estado = httpEstado.name();
		this.mensaje = mensaje;
		this.detalle = detalle;
	}

	public Date getTiempo() {
		return tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	

}
