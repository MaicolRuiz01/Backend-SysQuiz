package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.RespondioEvaluacion;


public interface IRespondioEvaluacionService {
	public List<RespondioEvaluacion> findAllRespuestasEvaluaciones();
	public Optional<RespondioEvaluacion> findByIdRespuestaEvaluacion(Integer id);
	public RespondioEvaluacion saveRespuestaEvaluacion(RespondioEvaluacion respondioEvaluacion);
	public RespondioEvaluacion updateRespuesta(Integer id,RespondioEvaluacion respondioEvaluacion);
	public RespondioEvaluacion delete(Integer id);
}
