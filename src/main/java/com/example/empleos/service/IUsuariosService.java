package com.example.empleos.service;

import java.util.List;

import com.example.empleos.model.Usuario;

public interface IUsuariosService {
	
	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	List<Usuario> buscarTodos();

}