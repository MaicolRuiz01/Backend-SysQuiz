package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Respuesta;

import co.com.example.test.repository.IRespuestaRepository;

import co.com.example.test.service.IRespuestaService;

@Service
public class RespuestaServiceImpl implements IRespuestaService {

	@Autowired
	IRespuestaRepository iRespuestaRepository;
	@Override
	public List<Respuesta> findAllRespuestas() {
		return iRespuestaRepository.findAll();
	}

	@Override
	public Optional<Respuesta> findByIdRespuesta(Integer id) {
		Optional<Respuesta>respuesta=iRespuestaRepository.findById(id);
		if(respuesta.isPresent()) {
			return respuesta;
		}
		return Optional.empty();
	}

	@Override
	public Respuesta saveRespuesta(Respuesta respuesta) {
		iRespuestaRepository.save(respuesta);
		return respuesta;
	}

	@Override
	public Respuesta updateRespuesta(Integer id, Respuesta respuesta) {
		Optional<Respuesta>currentRespuesta=iRespuestaRepository.findById(id);
		if(currentRespuesta.isPresent()) {
			Respuesta respuestaReturn=currentRespuesta.get();
			
			respuestaReturn.setFechaRegistro(respuesta.getFechaRegistro());
			iRespuestaRepository.save(respuestaReturn);
			
			return respuestaReturn;
		}
		return null;
	}

	@Override
	public Respuesta delete(Integer id) {
		Optional<Respuesta>respuesta=iRespuestaRepository.findById(id);
		if(respuesta.isPresent()) {
			iRespuestaRepository.deleteById(id);
			return respuesta.get();
		}
		return null;
	}

}
