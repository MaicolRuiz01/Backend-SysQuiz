package co.com.example.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.Rol;
import co.com.example.test.entity.RolUsuario;
import co.com.example.test.repository.IRolUsuarioRepository;
import co.com.example.test.service.IRolUsuarioService;
@Service
public class RolUsuarioServiceImpl implements IRolUsuarioService{
	@Autowired
	IRolUsuarioRepository rolUsuarioRepository;
	
	@Override
	public List<RolUsuario> findAllrolUsuarios() {
		return rolUsuarioRepository.findAll();
	}

	@Override
	public Optional<RolUsuario> findByIdRolUsuario(Integer id) {
		Optional<RolUsuario>rolCurrent=rolUsuarioRepository.findById(id);
		if(rolCurrent.isPresent()) {
			return rolCurrent;
		}
		return Optional.empty();
	}

	@Override
	public RolUsuario saveRolUusario(RolUsuario rolUsuario) {
		RolUsuario rolCurrent=rolUsuarioRepository.save(rolUsuario);
		Optional<RolUsuario>rolReturn=rolUsuarioRepository.findById(rolCurrent.getId());
		if(rolReturn.isPresent()) {
			return rolReturn.get();
		}
		return null;
	}

	@Override
	public RolUsuario updateRolUsuario(Integer id, RolUsuario rolUsuario) {
		Optional<RolUsuario>rolCurrent=rolUsuarioRepository.findById(id);
		if(rolCurrent.isPresent()) {
			RolUsuario rolreturn=rolCurrent.get();
			rolreturn.setRolId(rolUsuario.getRolId());
			rolUsuarioRepository.save(rolreturn);
		}
		return null;
	}

	@Override
	public void deleteRolUsuario(Integer id) {
		Optional<RolUsuario>rol=rolUsuarioRepository.findById(id);
		if(rol.isPresent()) {
			rolUsuarioRepository.deleteById(id);
		}
		
	}

}
