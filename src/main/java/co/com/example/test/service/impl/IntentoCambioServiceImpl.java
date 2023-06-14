package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.IntentoCambio;
import co.com.example.test.repository.IIntentoCambioRepository;
import co.com.example.test.service.IIntentoCambioService;
import co.com.example.test.service.MailService;
@Service
public class IntentoCambioServiceImpl implements IIntentoCambioService{

	@Autowired
	IIntentoCambioRepository intentoCambioRepository;
	@Autowired
	MailService mailService;
	
	@Override
	public List<IntentoCambio> findAll() {
		return intentoCambioRepository.findAll();
	}

	@Override
	public Optional<IntentoCambio> findById(Integer id) {
		Optional<IntentoCambio>intentoCambio=intentoCambioRepository.findById(id);
		if(intentoCambio.isPresent()) {
			return intentoCambio;
		}
			return null;
		
	}

	@Override
	public IntentoCambio save(IntentoCambio intentoCambio) {
		IntentoCambio intentoCurrent=intentoCambioRepository.save(intentoCambio);
		Optional<IntentoCambio>intentoReturn=intentoCambioRepository.findById(intentoCurrent.getId());
		if(intentoReturn.isPresent()) {
			return intentoReturn.get();
		}
		return null;
	}

	@Override
	public IntentoCambio update(Integer id, IntentoCambio intentoCambio) {
		Optional<IntentoCambio>intentoCurrent=intentoCambioRepository.findById(id);
		if(intentoCurrent.isPresent()) {
			IntentoCambio intentoReturn=intentoCurrent.get();
			intentoReturn.setCodigoUsuario(intentoCambio.getCodigoUsuario());
			intentoCambioRepository.save(intentoReturn);
			return intentoReturn;
		}
		return null;
	}

	@Override
	public IntentoCambio delete(Integer id) {
		Optional<IntentoCambio>intentoCambio=intentoCambioRepository.findById(id);
		if(intentoCambio.isPresent()) {
			intentoCambioRepository.deleteById(id);
			return intentoCambio.get();
		}
		return null;
	}

}
