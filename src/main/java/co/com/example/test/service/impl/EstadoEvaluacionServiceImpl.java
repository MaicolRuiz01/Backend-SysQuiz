package co.com.example.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Estado;
import co.com.example.test.entity.EstadoEvaluacion;
import co.com.example.test.repository.IEstadoEvaluacionRepository;
import co.com.example.test.repository.IEstadoRepository;
import co.com.example.test.service.IEstadoEvaluacionService;

@Service
public class EstadoEvaluacionServiceImpl implements IEstadoEvaluacionService {

	@Autowired
	IEstadoEvaluacionRepository estadoEvaluacionRepository;
	@Autowired
	IEstadoRepository estadoRepository;
	@Override
	public List<EstadoEvaluacion> findAllEstadoEvaluacions() {
		// TODO Auto-generated method stub
		return estadoEvaluacionRepository.findAll();
	}

	@Override
	public Optional<EstadoEvaluacion> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<EstadoEvaluacion> estadoEvaluacion = estadoEvaluacionRepository.findById(id);
		if(estadoEvaluacion.isPresent()) {
			return estadoEvaluacion;
		}
		return Optional.empty();
	}

	@Override
	public EstadoEvaluacion saveEstadoEvaluacion(EstadoEvaluacion estadoEvaluacion) {
		// TODO Auto-generated method stub
		String newEstado=estadoEvaluacion.getEstadoId().getNombre();
		Optional<Estado>estado=estadoRepository.findOneByNombre(newEstado);
		if(estado.isPresent()) {
			estadoEvaluacion.setEstadoId(estado.get());
			estadoEvaluacion.setFechaRegistro(new Date());
			EstadoEvaluacion estadoEvaluacionCurrent = estadoEvaluacionRepository.save(estadoEvaluacion);
			Optional<EstadoEvaluacion> estadoEvaluacionReturn = estadoEvaluacionRepository.findById(estadoEvaluacionCurrent.getId());
			if(estadoEvaluacionReturn.isPresent()) {
				return estadoEvaluacionReturn.get();
			}
			
		}

			return null;
		
		
		
	}

	@Override
	public EstadoEvaluacion updateEstadoEvaluacion(Integer id, EstadoEvaluacion estadoEvaluacion) {
		// TODO Auto-generated method stub
		Optional<EstadoEvaluacion> estadoEvaluacionCurrent =estadoEvaluacionRepository.findById(id);
		if(estadoEvaluacionCurrent.isPresent()) {
			EstadoEvaluacion estadoEvaluacionReturn = estadoEvaluacionCurrent.get();
			estadoEvaluacionReturn.setFechaRegistro(estadoEvaluacion.getFechaRegistro());
			estadoEvaluacionRepository.save(estadoEvaluacionReturn);
			return estadoEvaluacionReturn;
		}
		return null;
	}

	@Override
	public void deleteEstadoEvaluacion(Integer id) {
		// TODO Auto-generated method stub
		Optional<EstadoEvaluacion> estadoEvaluacionCurrent = estadoEvaluacionRepository.findById(id);
		if(estadoEvaluacionCurrent.isPresent()) {
			estadoEvaluacionRepository.deleteById(id);
		}
		
	}

}
