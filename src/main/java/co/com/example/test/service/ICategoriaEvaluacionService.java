package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.CategoriaEvaluacion;

public interface ICategoriaEvaluacionService {

public List<CategoriaEvaluacion>findAllCategoriaEvaluacion();
	
	public Optional<CategoriaEvaluacion>findById(Integer id);
	
	public CategoriaEvaluacion saveCategoriaEvaluacion(CategoriaEvaluacion categoriaEvaluacion);
	
	public CategoriaEvaluacion updateCategoriaEvaluacion(Integer id, CategoriaEvaluacion categoriaEvaluacion);
	
	public  void deleteCategoriaEvaluacion(Integer id);
}
