package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.SubCategoriaPregunta;

public interface ISubCategoriaPreguntaService {
	
	public List<SubCategoriaPregunta> findByAllSubCategoriaPreguntas();
	
	public Optional<SubCategoriaPregunta> findById(Integer id);
	
	public SubCategoriaPregunta saveSubCategoriaPregunta(SubCategoriaPregunta subCategoriaPregunta);
	
	public SubCategoriaPregunta updateSubCategoriaPregunta(Integer id,SubCategoriaPregunta subCategoriaPregunta);
	
	public void deleteSubCategoriaPregunta(Integer id);

}
