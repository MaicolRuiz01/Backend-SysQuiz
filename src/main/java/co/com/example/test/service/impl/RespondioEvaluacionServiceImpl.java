package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.RespondioEvaluacion;

import co.com.example.test.repository.IRespondioEvaluacionRepository;
import co.com.example.test.service.IRespondioEvaluacionService;
@Service
public class RespondioEvaluacionServiceImpl implements IRespondioEvaluacionService {

	@Autowired
	IRespondioEvaluacionRepository iRespondioEvaluacionRepository;
	@Override
	public List<RespondioEvaluacion> findAllRespuestasEvaluaciones() {
		
		return iRespondioEvaluacionRepository.findAll();
	}

	@Override
	public Optional<RespondioEvaluacion> findByIdRespuestaEvaluacion(Integer id) {
		Optional<RespondioEvaluacion>respondioEvaluacion=iRespondioEvaluacionRepository.findById(id);
		if(respondioEvaluacion.isPresent()) {
			return respondioEvaluacion;
		}
		return Optional.empty();
	}

	@Override
	public RespondioEvaluacion saveRespuestaEvaluacion(RespondioEvaluacion respondioEvaluacion) {
		iRespondioEvaluacionRepository.save(respondioEvaluacion);
		return respondioEvaluacion;
	}

	@Override
	public RespondioEvaluacion updateRespuesta(Integer id, RespondioEvaluacion respondioEvaluacion) {
		Optional<RespondioEvaluacion>currentRespuesta=iRespondioEvaluacionRepository.findById(id);
		if(currentRespuesta.isPresent()) {
			RespondioEvaluacion respuestaReturn=currentRespuesta.get();
			
			respuestaReturn.setFechaRegistro(respondioEvaluacion.getFechaRegistro());
			iRespondioEvaluacionRepository.save(respuestaReturn);
			
			return respuestaReturn;
		}
		return null;
	}

	@Override
	public RespondioEvaluacion delete(Integer id) {
		Optional<RespondioEvaluacion>respondioEvaluacion=iRespondioEvaluacionRepository.findById(id);
		if(respondioEvaluacion.isPresent()) {
			iRespondioEvaluacionRepository.deleteById(id);
			return respondioEvaluacion.get();
		}
		return null;
	}

}
