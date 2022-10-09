package com.example.empleos.service.db;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.empleos.model.Vacante;
import com.example.empleos.repository.VacantesRepository;
import com.example.empleos.service.IVacantesService;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {

	@Autowired
	private VacantesRepository vacantesRepo;
	public List<Vacante> buscarTodas() {
		
		return vacantesRepo.findAll();
	}

	public Vacante buscarPorId(Integer idVacante) {
		Optional <Vacante> optional = vacantesRepo.findById(idVacante);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void guardar(Vacante vacante) {
		vacantesRepo.save(vacante);

	}

	
	public List<Vacante> buscarDestacadas() {
		
		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

}
