package com.prueba.activos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.activos.model.AreaModel;

public interface AreaRepo extends JpaRepository<AreaModel, Long> {
	
	public List<AreaModel> findByNoArea(String noArea);

}
