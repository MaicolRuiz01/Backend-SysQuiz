package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.com.example.test.entity.UsuarioEvaluacion;

import co.com.example.test.repository.IUsuarioEvaluacionRepository;
import co.com.example.test.service.IUsuarioEvaluacionService;
@Service
public class UsuarioEvaluacionServiceImpl implements IUsuarioEvaluacionService{
	@Autowired
	IUsuarioEvaluacionRepository iUsuarioEvaluacionRepository;
	@Override
	public List<UsuarioEvaluacion> findAllUsersEvaluados() {
		return iUsuarioEvaluacionRepository.findAll();
		
	}

	@Override
	public Optional<UsuarioEvaluacion> findByIdUserEvaluado(Integer id) {
		Optional<UsuarioEvaluacion>usuarioEvaluado=iUsuarioEvaluacionRepository.findById(id);
		if(usuarioEvaluado.isPresent()) {
			return usuarioEvaluado;
		}
		return Optional.empty();
	}

	@Override
	public UsuarioEvaluacion saveUserEvaluado(UsuarioEvaluacion usuarioEvaluacion) {
		iUsuarioEvaluacionRepository.save(usuarioEvaluacion);
		return usuarioEvaluacion;
		
	}

	@Override
	public UsuarioEvaluacion updateUser(Integer id, UsuarioEvaluacion usuarioEvaluacion) {
		Optional<UsuarioEvaluacion>currentUsuario=iUsuarioEvaluacionRepository.findById(id);
		if(currentUsuario.isPresent()) {
			UsuarioEvaluacion usuarioReturn=currentUsuario.get();
			usuarioReturn.setEstado(usuarioEvaluacion.getEstado());
			usuarioReturn.setFechaRegistro(usuarioEvaluacion.getFechaRegistro());
			iUsuarioEvaluacionRepository.save(usuarioReturn);
			
			return usuarioReturn;
			}
		return null;
	}

	@Override
	public UsuarioEvaluacion delete(Integer id) {
		Optional<UsuarioEvaluacion>usuario=iUsuarioEvaluacionRepository.findById(id);
		if(usuario.isPresent()) {
			iUsuarioEvaluacionRepository.deleteById(id);
			return usuario.get();
		}
		return null;
	}

}
