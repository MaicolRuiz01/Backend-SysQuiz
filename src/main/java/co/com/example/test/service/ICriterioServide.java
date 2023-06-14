package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Criterio;

public interface ICriterioServide {
	
public List<Criterio>findAllCriterios();
	
	public Optional<Criterio>findById(Integer id);
	
	public Criterio saveCriterios(Criterio criterio);
	
	public Criterio updateCriterios(Integer id, Criterio criterio);
	
	public  void deleteCriterios(Integer id);

}
