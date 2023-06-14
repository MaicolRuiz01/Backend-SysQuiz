package co.com.example.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Evaluacion;
import co.com.example.test.entity.Pregunta;
import co.com.example.test.repository.IPreguntaRepository;
import co.com.example.test.service.IPreguntaService;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	IPreguntaRepository preguntaReository;

	@Override
	public List<Pregunta> findAllPregunta() {
		// TODO Auto-generated method stub
		return preguntaReository.findAll();
	}

	@Override
	public Optional<Pregunta> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Pregunta> pregunta = preguntaReository.findById(id);
		if (pregunta.isPresent()) {
			return pregunta;
		}
		return Optional.empty();
	}

	@Override
	public Pregunta savePregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		Date fecha = new Date();
		pregunta.setFechaRegistro(fecha);
		Pregunta preguntaCurrent = preguntaReository.save(pregunta);
		Optional<Pregunta> preguntaReturn = preguntaReository.findById(preguntaCurrent.getId());
		if (preguntaReturn.isPresent()) {
			return preguntaReturn.get();
		}

		return null;
	}

	@Override
	public Pregunta updatePregunta(Integer id, Pregunta pregunta) {
		// TODO Auto-generated method stub
		Optional<Pregunta> preguntaCurrent = preguntaReository.findById(id);
		if (preguntaCurrent.isPresent()) {
			Pregunta preguntaReturn = preguntaCurrent.get();
			preguntaReturn.setDescripcion(pregunta.getDescripcion());
			preguntaReository.save(preguntaReturn);
			return preguntaReturn;
		}

		return null;
	}

	@Override
	public void deletePregunta(Integer id) {
		// TODO Auto-generated method stub
		Optional<Pregunta> preguntaCurrent = preguntaReository.findById(id);
		if (preguntaCurrent.isPresent()) {
			preguntaReository.deleteById(id);
		}
	}

}
