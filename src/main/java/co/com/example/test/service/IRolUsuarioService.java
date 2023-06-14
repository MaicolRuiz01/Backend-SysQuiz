package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.RolUsuario;

public interface IRolUsuarioService {
	
	public List<RolUsuario>findAllrolUsuarios();
	public Optional<RolUsuario>findByIdRolUsuario(Integer id);
	public RolUsuario saveRolUusario(RolUsuario rolUsuario);
	public RolUsuario updateRolUsuario(Integer id,RolUsuario rolUsuario);
	public void deleteRolUsuario(Integer id);

}
