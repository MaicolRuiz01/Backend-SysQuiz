package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.SubCategoriaPregunta;
import co.com.example.test.repository.ISubCategoriaPreguntaRepository;
import co.com.example.test.service.ISubCategoriaPreguntaService;

@Service
public class SubCategoriaPreguntaServiceImpl implements ISubCategoriaPreguntaService {

	@Autowired
	ISubCategoriaPreguntaRepository subCategoriaPreguntaRepository;

	@Override
	public List<SubCategoriaPregunta> findByAllSubCategoriaPreguntas() {
		// TODO Auto-generated method stub
		return subCategoriaPreguntaRepository.findAll();
	}

	@Override
	public Optional<SubCategoriaPregunta> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<SubCategoriaPregunta> subCategoriaPregunta = subCategoriaPreguntaRepository.findById(id);
		if(subCategoriaPregunta.isPresent()) {
			return subCategoriaPregunta;
		}
		return Optional.empty();
	}

	@Override
	public SubCategoriaPregunta saveSubCategoriaPregunta(SubCategoriaPregunta subCategoriaPregunta) {
		// TODO Auto-generated method stub
		SubCategoriaPregunta subCategoriaPreguntaCurrent = subCategoriaPreguntaRepository.save(subCategoriaPregunta);
		Optional<SubCategoriaPregunta> subCategoriaPreguntaReturn = subCategoriaPreguntaRepository.findById(subCategoriaPreguntaCurrent.getId());
		if(subCategoriaPreguntaReturn.isPresent()) {
			return subCategoriaPreguntaReturn.get();
		}
		return null;
		
	}

	@Override
	public SubCategoriaPregunta updateSubCategoriaPregunta(Integer id, SubCategoriaPregunta subCategoriaPregunta) {
		// TODO Auto-generated method stub
		Optional<SubCategoriaPregunta> subCategoriaPreguntaCurrent =subCategoriaPreguntaRepository.findById(id);
		if(subCategoriaPreguntaCurrent.isPresent()) {
			SubCategoriaPregunta subCategoriaPreguntaReturn = subCategoriaPreguntaCurrent.get();
			subCategoriaPreguntaReturn.setNombre(subCategoriaPregunta.getNombre());
			subCategoriaPreguntaReturn.setDescripcion(subCategoriaPregunta.getDescripcion());
			subCategoriaPreguntaReturn.setCategoriaPreguntaId(subCategoriaPregunta.getCategoriaPreguntaId());
			subCategoriaPreguntaRepository.save(subCategoriaPreguntaReturn);
		}
		return null;
	}

	@Override
	public void deleteSubCategoriaPregunta(Integer id) {
		// TODO Auto-generated method stub
		Optional<SubCategoriaPregunta> subCategoriaPreguntaCurrent = subCategoriaPreguntaRepository.findById(id);
		if(subCategoriaPreguntaCurrent.isPresent()) {
			subCategoriaPreguntaRepository.deleteById(id);
		}
	}
	
	
	
}
