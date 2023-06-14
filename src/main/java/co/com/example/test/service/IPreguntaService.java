package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Pregunta;

public interface IPreguntaService {
	
	public List<Pregunta>findAllPregunta();
	
	public Optional<Pregunta>findById(Integer id);
	
	public Pregunta savePregunta(Pregunta pregunta);
	
	public Pregunta updatePregunta(Integer id, Pregunta pregunta);
	
	public void deletePregunta(Integer id);

}
