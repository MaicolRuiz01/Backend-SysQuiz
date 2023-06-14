package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Calificacion;


public interface ICalificacionService {
	public List<Calificacion> findAllCalificaciones();
	public Optional<Calificacion> findByIdCalificacion(Integer id);
	public Calificacion saveCalificacion(Calificacion calificacion);
	public Calificacion updateCalificacion(Integer id,Calificacion calificacion);
	public Calificacion delete(Integer id);

}
 