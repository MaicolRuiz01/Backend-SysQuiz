package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Estado;
import co.com.example.test.repository.IEstadoRepository;
import co.com.example.test.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService {
	
	@Autowired
	IEstadoRepository estadoRepository;

	@Override
	public List<Estado> findAllEstado() {
		// TODO Auto-generated method stub
		return estadoRepository.findAll();
	}

	@Override
	public Optional<Estado> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Estado> estado = estadoRepository.findById(id);
		if(estado.isPresent()) {
			return estado;
		}
		return Optional.empty();
	}

	@Override
	public Estado saveEstado(Estado estado) {
		// TODO Auto-generated method stub
		Estado estadoCurrent = estadoRepository.save(estado);
		Optional<Estado> estadoReturn = estadoRepository.findById(estadoCurrent.getId());
		if(estadoReturn.isPresent()) {
			return estadoReturn.get();
		}
		return null;
	}

	@Override
	public Estado updateEstado(Integer id, Estado estado) {
		// TODO Auto-generated method stub
		Optional<Estado> estadoCurrent = estadoRepository.findById(id);
		if(estadoCurrent.isPresent()) {
			Estado estadoReturn = estadoCurrent.get();
			estadoReturn.setNombre(estado.getNombre());
			estadoRepository.save(estadoReturn);
		}
		return null;
	}

	@Override
	public void deleteEstado(Integer id) {
		// TODO Auto-generated method stub
		Optional<Estado> estadoCurrent = estadoRepository.findById(id);
		if(estadoCurrent.isPresent()) {
			estadoRepository.deleteById(id);
		}
	}

}
