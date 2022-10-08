package com.example.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empleos.model.Categoria;
import com.example.empleos.repository.CategoriasRepository;
import com.example.empleos.service.ICategoriasService;

@Service
public class CategoriasServiceJpa implements ICategoriasService {

	@Autowired
	public CategoriasRepository categoriasRepo;
		public void guardar(Categoria categoria) {
			categoriasRepo.save(categoria);

	}

	public List<Categoria> buscarTodas() {
		return categoriasRepo.findAll();
	}

	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
