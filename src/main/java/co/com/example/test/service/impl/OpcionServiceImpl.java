package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Evaluacion;
import co.com.example.test.entity.Opcion;
import co.com.example.test.repository.IOpcionRepository;
import co.com.example.test.service.IOpcionService;

@Service
public class OpcionServiceImpl implements IOpcionService {

	@Autowired
	IOpcionRepository opcionRepository;
	
	@Override
	public List<Opcion> findAllOpcion() {
		return opcionRepository.findAll();
		
	}

	@Override
	public Optional<Opcion> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Opcion> opcion = opcionRepository.findById(id);
		if(opcion.isPresent()) {
			return opcion;
		}
		return Optional.empty();
	}

	@Override
	public Opcion saveOpcion(Opcion opcion) {
		// TODO Auto-generated method stub
		Opcion opcionCurrent = opcionRepository.save(opcion);
		Optional<Opcion> opcionReturn = opcionRepository.findById(opcionCurrent.getId());
		if(opcionReturn.isPresent()) {
			return opcionReturn.get();
		}
		return null;
	}

	@Override
	public Opcion updateOpcion(Integer id, Opcion opcion) {
		// TODO Auto-generated method stub
		Optional<Opcion> opcionCurrent = opcionRepository.findById(id);
		if(opcionCurrent.isPresent()) {
			Opcion opcionReturn = opcionCurrent.get();
			opcionReturn.setValor(opcion.getValor());
			opcionReturn.setDescripcion(opcion.getDescripcion());
			opcionReturn.setComentario(opcion.getComentario());
			opcionRepository.save(opcionReturn);
			return opcionReturn;
			
		}
		
		return null;
	}

	
	@Override
	public void deleteOpcion(Integer id) {
		// TODO Auto-generated method stub
		Optional<Opcion> opcionCurrent = opcionRepository.findById(id);
		if(opcionCurrent.isPresent()) {
			opcionRepository.deleteById(id);
		}
		
	}
		
	
	
}
