package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Estado;

public interface IEstadoService {
	
	public List<Estado>findAllEstado();
	
	public Optional<Estado>findById(Integer id);
	
	public Estado saveEstado(Estado estado);
	
	public Estado updateEstado(Integer id, Estado estado);
	
	public  void deleteEstado(Integer id);

}
