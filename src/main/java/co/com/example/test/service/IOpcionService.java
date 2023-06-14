package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Opcion;

public interface IOpcionService {

	public List<Opcion> findAllOpcion();
	
	public Optional<Opcion> findById(Integer id);
	
	public Opcion saveOpcion(Opcion opcion);
	
	
	public Opcion updateOpcion(Integer id, Opcion opcion);
	
	public void deleteOpcion(Integer id);

}
