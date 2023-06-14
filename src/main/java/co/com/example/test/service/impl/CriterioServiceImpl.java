package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Criterio;
import co.com.example.test.repository.ICriterioRepository;
import co.com.example.test.service.ICriterioServide;

@Service
public class CriterioServiceImpl implements ICriterioServide {
	
	@Autowired
	ICriterioRepository criterioRepository;

	@Override
	public List<Criterio> findAllCriterios() {
		// TODO Auto-generated method stub
		return criterioRepository.findAll();
	}

	@Override
	public Optional<Criterio> findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Criterio> criterio = criterioRepository.findById(id);
		if(criterio.isPresent()) {
			return criterio;
		}
		return Optional.empty();
	}

	@Override
	public Criterio saveCriterios(Criterio criterio) {
		// TODO Auto-generated method stub
		Criterio criterioCurrent = criterioRepository.save(criterio);
		Optional<Criterio> criterioReturn = criterioRepository.findById(criterioCurrent.getId());
		if(criterioReturn.isPresent()) {
			return criterioReturn.get();
		}
		return null;
	}

	@Override
	public Criterio updateCriterios(Integer id, Criterio criterio) {
		// TODO Auto-generated method stub
		Optional<Criterio> criterioCurrent = criterioRepository.findById(id);
		if(criterioCurrent.isPresent()) {
			Criterio criterioReturn = criterioCurrent.get();
			criterioReturn.setDescripcion(criterio.getDescripcion());
			
			return criterioRepository.save(criterioReturn);
		}
		return null;
	}

	@Override
	public void deleteCriterios(Integer id) {
		// TODO Auto-generated method stub
		Optional<Criterio> criterioCurrent = criterioRepository.findById(id);
		if(criterioCurrent.isPresent()) {
			criterioRepository.deleteById(id);
		}
		
	}

}
