package com.example.empleos.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.example.empleos.model.Vacante;

public interface IVacantesService {
	
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);
	List<Vacante> buscarDestacadas();
	void eliminar (Integer idVacante);
	List<Vacante> buscarByExample(Example<Vacante> example);

}
