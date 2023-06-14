package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.EstadoEvaluacion;

public interface IEstadoEvaluacionService {
	
	public List<EstadoEvaluacion> findAllEstadoEvaluacions();
	
	public Optional<EstadoEvaluacion> findById(Integer id);
	
	public EstadoEvaluacion saveEstadoEvaluacion(EstadoEvaluacion estadoEvaluacion);
	
	public EstadoEvaluacion updateEstadoEvaluacion(Integer id, EstadoEvaluacion estadoEvaluacion);
	
	public void deleteEstadoEvaluacion(Integer id);

}
