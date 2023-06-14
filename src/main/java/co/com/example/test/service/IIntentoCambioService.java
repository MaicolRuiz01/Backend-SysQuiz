package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.IntentoCambio;

public interface IIntentoCambioService {
	public List<IntentoCambio>findAll();
	public Optional<IntentoCambio>findById(Integer id);
	public IntentoCambio save(IntentoCambio intentoCambio);
	public IntentoCambio update(Integer id,IntentoCambio intentoCambio);
	public IntentoCambio delete(Integer id);

}
