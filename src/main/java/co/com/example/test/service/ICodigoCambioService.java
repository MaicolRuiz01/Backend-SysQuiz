package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.CodigoCambio;

public interface ICodigoCambioService {
	
	public List<CodigoCambio> findAll();
	public Optional<CodigoCambio>findById(Integer id);
	public CodigoCambio saveCodigoCambio(CodigoCambio codigoCambio);
	public CodigoCambio updateCodigoCambio(CodigoCambio codigoCambio ,Integer id);
	public void deleteCodigoCambio(Integer id);

}
