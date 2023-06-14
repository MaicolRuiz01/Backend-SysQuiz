package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Calificacion;
import co.com.example.test.repository.ICalificacionRepository;
import co.com.example.test.service.ICalificacionService;
@Service
public class CalificacionServiceImpl implements ICalificacionService {
	@Autowired
	ICalificacionRepository iCalificacionRepository;
	@Override
	public List<Calificacion> findAllCalificaciones() {
		
		return iCalificacionRepository.findAll();
	}

	@Override
	public Optional<Calificacion> findByIdCalificacion(Integer id) {
		Optional<Calificacion>calificacion=iCalificacionRepository.findById(id);
		if(calificacion.isPresent()) {
			return calificacion;
		}
		return Optional.empty();
	}

	@Override
	public Calificacion saveCalificacion(Calificacion calificacion) {
		iCalificacionRepository.save(calificacion);
		return calificacion;
	}

	@Override
	public Calificacion updateCalificacion(Integer id, Calificacion calificacion) {
		Optional<Calificacion>currentCalificacion=iCalificacionRepository.findById(id);
		if(currentCalificacion.isPresent()) {
			Calificacion calificacionReturn=currentCalificacion.get();
			calificacionReturn.setCalificacion(calificacion.getCalificacion());
			calificacionReturn.setMensaje(calificacion.getMensaje());
			calificacionReturn.setFechaRegistro(calificacion.getFechaRegistro());
			iCalificacionRepository.save(calificacionReturn);
			
			return calificacionReturn;
		}
		return null;
	}

	@Override
	public Calificacion delete(Integer id) {
		Optional<Calificacion>calificacion=iCalificacionRepository.findById(id);
		if(calificacion.isPresent()) {
			iCalificacionRepository.deleteById(id);
			return calificacion.get();
		}
		return null;
	}

}
