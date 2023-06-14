package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.CategoriaPregunta;
import co.com.example.test.repository.ICategoriaPreguntaRepository;
import co.com.example.test.service.ICategoriaPreguntaService;

@Service
public class CategoriaPreguntaServiceImpl implements ICategoriaPreguntaService {

	@Autowired
	ICategoriaPreguntaRepository categoriaPreguntaRepository;
	
	@Override
	public List<CategoriaPregunta> findAllCategoriaPreguntas() {
		// TODO Auto-generated method stub
		return categoriaPreguntaRepository.findAll();
	}

	@Override
	public Optional<CategoriaPregunta> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<CategoriaPregunta> categoriaPregunta = categoriaPreguntaRepository.findById(id);
		if(categoriaPregunta.isPresent()) {
			return categoriaPregunta;
		}
		return Optional.empty();
	}

	@Override
	public CategoriaPregunta saveCategoriaPregunta(CategoriaPregunta categoriaPregunta) {
		// TODO Auto-generated method stub
		CategoriaPregunta categoriaPreguntaCurrent = categoriaPreguntaRepository.save(categoriaPregunta);
		Optional<CategoriaPregunta> categoriaPreguntaReturn = categoriaPreguntaRepository.findById(categoriaPreguntaCurrent.getId());
		if(categoriaPreguntaReturn.isPresent()) {
			return categoriaPreguntaReturn.get();
		}
		return null;
	}

	@Override
	public CategoriaPregunta updateCategoriaPregunta(Integer id, CategoriaPregunta categoriaPregunta) {
		// TODO Auto-generated method stub
		Optional<CategoriaPregunta> categoriaPreguntaCurrent =categoriaPreguntaRepository.findById(id);
		if(categoriaPreguntaCurrent.isPresent()) {
			CategoriaPregunta categoriaPreguntaReturn = categoriaPreguntaCurrent.get();
			categoriaPreguntaReturn.setNombre(categoriaPregunta.getNombre());
			categoriaPreguntaReturn.setDescripcion(categoriaPregunta.getDescripcion());
			categoriaPreguntaReturn.setEvaluacionId(categoriaPregunta.getEvaluacionId());
			return  categoriaPreguntaRepository.save(categoriaPreguntaReturn);
		}
		return null;
	}

	@Override
	public void deleteCategoriaPregunta(Integer id) {
		// TODO Auto-generated method stub
		Optional<CategoriaPregunta> categoriaPreguntaCurrent = categoriaPreguntaRepository.findById(id);
		if(categoriaPreguntaCurrent.isPresent()) {
			categoriaPreguntaRepository.deleteById(id);
		}
	}

	@Override
	public List<CategoriaPregunta> findByIdEvaluacionId(Integer id) {
		
		return categoriaPreguntaRepository.findByEvaluacionId(id);
	}

}
