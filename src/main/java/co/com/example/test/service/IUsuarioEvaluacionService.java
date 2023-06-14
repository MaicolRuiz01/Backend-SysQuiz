package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Semestre;
import co.com.example.test.entity.UsuarioEvaluacion;

public interface IUsuarioEvaluacionService {
	public List<UsuarioEvaluacion> findAllUsersEvaluados();
	public Optional<UsuarioEvaluacion> findByIdUserEvaluado(Integer id);
	public UsuarioEvaluacion saveUserEvaluado(UsuarioEvaluacion usuarioEvaluacion);
	public UsuarioEvaluacion updateUser(Integer id,UsuarioEvaluacion usuarioEvaluacion);
	public UsuarioEvaluacion delete(Integer id);
}
