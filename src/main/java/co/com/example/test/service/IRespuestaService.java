package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Respuesta;


public interface IRespuestaService {
	public List<Respuesta> findAllRespuestas();
	public Optional<Respuesta> findByIdRespuesta(Integer id);
	public Respuesta saveRespuesta(Respuesta respuesta);
	public Respuesta updateRespuesta(Integer id,Respuesta respuesta);
	public Respuesta delete(Integer id);
}
