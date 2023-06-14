package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;
import co.com.example.test.repository.IUsuarioRepository;
import co.com.example.test.repository.IUsuarioSemestreRepository;
import co.com.example.test.service.IUsuarioSemestreService;
@Service

public class UsuarioSemestreServiceImpl implements IUsuarioSemestreService {
@Autowired
IUsuarioSemestreRepository iUsuarioSemestreRepository;
@Autowired
IUsuarioRepository usuarioRepository;
	@Override
	public List<UsuarioSemestre> findAllUsuariosSemestres() {
		
		return iUsuarioSemestreRepository.findAll();
	}

	@Override
	public Optional<UsuarioSemestre> findByIdUsuarioSemestre(Integer id) {
		Optional<UsuarioSemestre>usuarioSemestre=iUsuarioSemestreRepository.findById(id);
		if(usuarioSemestre.isPresent()) {
			return usuarioSemestre;
		}
		return Optional.empty();
	}

	@Override
	public Optional<UsuarioSemestre> saveSemestre(UsuarioSemestre usuariosemestre) {
		List<UsuarioSemestre>lista=iUsuarioSemestreRepository.findByUsuarioId(usuariosemestre.getUsuarioId());
		
		if(lista.size()>0) {
		boolean existe=true;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getSemestreId().getId()==usuariosemestre.getSemestreId().getId()) {
				existe=false;
			}
		}
		
		
		if(existe) {
			
			UsuarioSemestre usuariocurrent= iUsuarioSemestreRepository.save(usuariosemestre);
			Optional<UsuarioSemestre> usuarioReturn=iUsuarioSemestreRepository.findById(usuariocurrent.getId());
			if(usuarioReturn.isPresent()) {
				return usuarioReturn;
			}
			}
		
		}else {
			UsuarioSemestre usuariocurrent= iUsuarioSemestreRepository.save(usuariosemestre);
			Optional<UsuarioSemestre> usuarioReturn=iUsuarioSemestreRepository.findById(usuariocurrent.getId());
			if(usuarioReturn.isPresent()) {
				return usuarioReturn;
			}
				
			
		}
		
		
		
		return null;
		
		
		
		
		
		
	}

	@Override
	public UsuarioSemestre updateSemestre(Integer id, UsuarioSemestre usuariosemestre) {
		Optional<UsuarioSemestre>currentUSemestre=iUsuarioSemestreRepository.findById(id);
		if(currentUSemestre.isPresent()) {
			UsuarioSemestre usuarioSemestreReturn=currentUSemestre.get();
			usuarioSemestreReturn.setFechaRegistro(usuariosemestre.getFechaRegistro());
			iUsuarioSemestreRepository.save(usuarioSemestreReturn);
			
			return usuarioSemestreReturn;
		}
		return null;
	}

	@Override
	public UsuarioSemestre delete(Integer id) {
		Optional<UsuarioSemestre>semestre=iUsuarioSemestreRepository.findById(id);
		if(semestre.isPresent()) {
			iUsuarioSemestreRepository.deleteById(id);
			return semestre.get();
		}
		return null;
	}

	@Override
	public List<UsuarioSemestre> findByIdUsuario(Usuario usuario) {
		Optional<Usuario>usuarioCurrent=usuarioRepository.findById(usuario.getId());
		if(usuarioCurrent.isPresent()) {
			return iUsuarioSemestreRepository.findByUsuarioId(usuario);
			
		}
		return null;
	}

}
