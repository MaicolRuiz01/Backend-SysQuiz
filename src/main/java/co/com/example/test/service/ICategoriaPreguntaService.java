package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.CategoriaPregunta;

public interface ICategoriaPreguntaService {
	
	public List<CategoriaPregunta> findAllCategoriaPreguntas();
	
	public Optional<CategoriaPregunta> findById(Integer id);
	
	public CategoriaPregunta saveCategoriaPregunta(CategoriaPregunta categoriaPregunta);
	
	public CategoriaPregunta updateCategoriaPregunta(Integer id, CategoriaPregunta categoriaPregunta);
	
	public void deleteCategoriaPregunta(Integer id);
	public List<CategoriaPregunta> findByIdEvaluacionId(Integer id);
	
}
