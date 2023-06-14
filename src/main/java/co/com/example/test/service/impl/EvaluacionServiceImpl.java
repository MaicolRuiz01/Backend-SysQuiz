	package co.com.example.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Estado;
import co.com.example.test.entity.EstadoEvaluacion;
import co.com.example.test.entity.Evaluacion;
import co.com.example.test.repository.IEstadoEvaluacionRepository;
import co.com.example.test.repository.IEstadoRepository;
import co.com.example.test.repository.IEvaluacionRepository;
import co.com.example.test.service.IEvaluacionService;

@Service
public class EvaluacionServiceImpl implements IEvaluacionService {
	
	@Autowired
	IEvaluacionRepository evaluacionRepository;
	@Autowired
	IEstadoEvaluacionRepository estadoEvaluacionRepository;
	@Autowired
	IEstadoRepository estadoRepository;

	@Override
	public List<Evaluacion> findAllEvaluacions() {
		// TODO Auto-generated method stub
		return evaluacionRepository.findAll();
	}

	@Override
	public Optional<Evaluacion> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Evaluacion> evaluacion = evaluacionRepository.findById(id);
		if(evaluacion.isPresent()) {
			return evaluacion;
		}
		return Optional.empty();
	}

	@Override
	public Evaluacion saveEvaluacion(Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		Date fecha=new Date();
		evaluacion.setFechaRegistro(fecha);
		Evaluacion evaluacionCurrent = evaluacionRepository.save(evaluacion);
		
		Optional<Evaluacion> evaluacionReturn = evaluacionRepository.findById(evaluacionCurrent.getId());
		if(evaluacionReturn.isPresent()) {
			EstadoEvaluacion estadoEvaluacion=new EstadoEvaluacion();
			Optional<Estado> estado=estadoRepository.findOneByNombre("REGISTRADA");
			if(estado.isPresent()) {
				estadoEvaluacion.setEstadoId(estado.get());
				estadoEvaluacion.setEvaluacionId(evaluacionReturn.get().getId());
				estadoEvaluacion.setFechaRegistro(fecha);
				estadoEvaluacionRepository.save(estadoEvaluacion);
				
			}
			
			
			return evaluacionReturn.get();
		}
		
		return null;
	}

	@Override
	public Evaluacion updateEvaluacion(Integer id, Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		Optional<Evaluacion> evaluacionCurrent =evaluacionRepository.findById(id);
		if(evaluacionCurrent.isPresent()) {
			Evaluacion evaluacionReturn = evaluacionCurrent.get();
			evaluacionReturn.setTitulo(evaluacion.getTitulo());
			evaluacionReturn.setDescripcion(evaluacion.getDescripcion());
			evaluacionReturn.setCategoriaId(evaluacion.getCategoriaId());
			
			return evaluacionRepository.save(evaluacionReturn); 
		}
		
		return null;
	}

	@Override
	public void deleteEvaluacion(Integer id) {
		// TODO Auto-generated method stub
		Optional<Evaluacion> evaluacionCurrent = evaluacionRepository.findById(id);
		if(evaluacionCurrent.isPresent()) {
			evaluacionRepository.deleteById(id);
		}
	}

	@Override
	public List<Evaluacion> listaEvaluacionByIdSemestre(Integer id) {
		
		return evaluacionRepository.findBySemestreId(id);
	}

		
}
