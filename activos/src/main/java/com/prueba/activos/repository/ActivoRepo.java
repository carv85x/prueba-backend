package com.prueba.activos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.prueba.activos.model.ActivoModel;

@CrossOrigin(origins = "http://localhost:4200")
public interface ActivoRepo extends JpaRepository<ActivoModel, Long> {
	
	public List<ActivoModel> findBySerial(String serial);
	public List<ActivoModel> findByFechaCompra(Date fechaCompra);
	public List<ActivoModel> findByTipo(String tipo);


}
