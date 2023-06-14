package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Evaluacion;

public interface IEvaluacionService {

	public List<Evaluacion> findAllEvaluacions();
	
	public Optional<Evaluacion> findById(Integer id);
	
	public Evaluacion saveEvaluacion(Evaluacion evaluacion);
	
	public Evaluacion updateEvaluacion(Integer id, Evaluacion evaluacion);
	
	public List<Evaluacion>listaEvaluacionByIdSemestre(Integer id);
	
	public  void deleteEvaluacion(Integer id);
	
	

}
