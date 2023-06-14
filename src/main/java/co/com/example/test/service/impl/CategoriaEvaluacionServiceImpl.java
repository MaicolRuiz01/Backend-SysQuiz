package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.CategoriaEvaluacion;
import co.com.example.test.entity.Evaluacion;
import co.com.example.test.repository.ICategoriaEvaluacionRepository;
import co.com.example.test.service.ICategoriaEvaluacionService;

@Service
public class CategoriaEvaluacionServiceImpl implements ICategoriaEvaluacionService {

	@Autowired
	ICategoriaEvaluacionRepository categoriaEvaluacionRepository;
	
	@Override
	public List<CategoriaEvaluacion> findAllCategoriaEvaluacion() {
		// TODO Auto-generated method stub
		return categoriaEvaluacionRepository.findAll();
	}

	@Override
	public Optional<CategoriaEvaluacion> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<CategoriaEvaluacion> categoriaEvaluacion = categoriaEvaluacionRepository.findById(id);
		if(categoriaEvaluacion.isPresent()) {
			return categoriaEvaluacion;
		}
		return Optional.empty();
	}

	@Override
	public CategoriaEvaluacion saveCategoriaEvaluacion(CategoriaEvaluacion categoriaEvaluacion) {
		// TODO Auto-generated method stub
		CategoriaEvaluacion categoriaEvaluacionCurrent = categoriaEvaluacionRepository.save(categoriaEvaluacion);
		Optional<CategoriaEvaluacion> categoriaEvaluacionReturn = categoriaEvaluacionRepository.findById(categoriaEvaluacionCurrent.getId());
		if(categoriaEvaluacionReturn.isPresent()) {
			return categoriaEvaluacionReturn.get();
		}
		return null;
	}

	@Override
	public CategoriaEvaluacion updateCategoriaEvaluacion(Integer id, CategoriaEvaluacion categoriaEvaluacion) {
		// TODO Auto-generated method stub
		Optional<CategoriaEvaluacion> categoriaEvaluacionCurrent =categoriaEvaluacionRepository.findById(id);
		if(categoriaEvaluacionCurrent.isPresent()) {
			CategoriaEvaluacion categoriaEvaluacionReturn = categoriaEvaluacionCurrent.get();
			categoriaEvaluacionReturn.setNombre(categoriaEvaluacion.getNombre());
			categoriaEvaluacionReturn.setFechaRegistro(categoriaEvaluacion.getFechaRegistro());
			categoriaEvaluacionRepository.save(categoriaEvaluacionReturn);
		}
		return null;
	}

	@Override
	public void deleteCategoriaEvaluacion(Integer id) {
		// TODO Auto-generated method stub
		Optional<CategoriaEvaluacion> categoriaEvaluacionCurrent = categoriaEvaluacionRepository.findById(id);
		if(categoriaEvaluacionCurrent.isPresent()) {
			categoriaEvaluacionRepository.deleteById(id);
		}
	}

}
