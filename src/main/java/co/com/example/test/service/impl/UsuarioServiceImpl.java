package co.com.example.test.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.example.test.entity.CodigoRegistro;
import co.com.example.test.entity.PreRegistro;
import co.com.example.test.entity.Rol;
import co.com.example.test.entity.RolUsuario;
import co.com.example.test.entity.Semestre;
import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioCodigoRegistro;
import co.com.example.test.entity.UsuarioSemestre;
import co.com.example.test.repository.ICodigoRegistroRepository;
import co.com.example.test.repository.IPreRegistroRepository;
import co.com.example.test.repository.IRolRepository;
import co.com.example.test.repository.IRolUsuarioRepository;
import co.com.example.test.repository.IUsuarioCodigoRegistroRepository;
import co.com.example.test.repository.IUsuarioRepository;
import co.com.example.test.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioRepository usuarioRepository;
	@Autowired
	IPreRegistroRepository preRegistroRepository;
	@Autowired
	ICodigoRegistroRepository codigoRegistroRepository;
	@Autowired
	IUsuarioCodigoRegistroRepository usuarioCodigoRegistroRepository;
	@Autowired
	IRolRepository rolRepository;
	@Autowired
	IRolUsuarioRepository rolUsuarioRepository;
	

	@Override
	public List<Usuario> findAllUser() {

		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findByIdUser(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario;
		}
		return Optional.empty();
	}

	@Override
	public Usuario saveUser(Usuario usuario) {
		//Obtengo el codigo del docente
		Integer codigo=Integer.parseInt(usuario.getCodigo());
		//Busco el Pre registro
		List<PreRegistro> lista = preRegistroRepository.findByCodigo(codigo);
		
		if(lista.size()>=1) {
		//Obtengo la fecha
		Date fecha=new Date();
		//Obtengo el ultimo pre registro
		PreRegistro pre = lista.get(lista.size() - 1);
		//Creo el usuario
		usuario.setCodigo(codigo+"");
		usuario.setDocumento(pre.getDocumento());
		usuario.setEmail(pre.getEmail());
		usuario.setNombre(pre.getNombre());
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		usuario.setFechaRegistro(fecha);
		usuario.setEstado("ACTIVO");
		
		//Guardo el usuario
		Usuario usuarioReturn= usuarioRepository.save(usuario);
		//Busco  el rol docente
		Rol roles = rolRepository.findByNombre("ROLE_TEACHER").get();
		//Creo un rolUsuario
		RolUsuario rolUsuario=new RolUsuario();
		rolUsuario.setRolId(roles);
		rolUsuario.setUsuarioId(usuarioReturn.getId());
		rolUsuario.setFechaRegistro(fecha);
		//Le asigno el rol docenten al usuario 
		rolUsuarioRepository.save(rolUsuario);
		//Actualizo el estado en la tabla pre registro
		pre.setEstado("registrado");
		preRegistroRepository.save(pre);
		//Busco codigo registro
		Optional<CodigoRegistro> codigoRegistro=codigoRegistroRepository.findByPreRegistroId(pre.getId());
		//Guardo usuarioCodigoRegistro
		UsuarioCodigoRegistro userCodigo=new UsuarioCodigoRegistro();
		userCodigo.setCodigoRegistroId(codigoRegistro.get().getId());
		userCodigo.setUsuarioId(usuarioReturn.getId());
		userCodigo.setFechaRegistro(fecha);
		
		return usuarioReturn;
		}
		
		return null;
	}

	@Override
	public Usuario updateUser(Integer id, Usuario usuario) {
		Optional<Usuario> currentUsuario = usuarioRepository.findById(id);
		if (currentUsuario.isPresent()) {
			Usuario usuarioReturn = currentUsuario.get();
			usuarioReturn.setNombre(usuario.getNombre());
			usuarioReturn.setDocumento(usuario.getDocumento());
			usuarioReturn.setCodigo(usuario.getCodigo());
			usuarioRepository.save(usuarioReturn);

			return usuarioReturn;
		}
		return null;
	}

	@Override
	public Usuario delete(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			usuario.get().setEstado("OFF");
			usuarioRepository.save(usuario.get());
			return usuario.get();
		}

		return null;
	}

	@Override
	public List<Semestre> semestres(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get().getSemestre();
		}
		return null;
	}

	@Override
	public Optional<Usuario> findOneByCorreo(String correo) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(correo);
		if (usuario.isPresent()) {
			return usuario;
		}
		return Optional.empty();
	}

	@Override
	public boolean existeUsuario(Usuario usuario) {

		
		Optional<Usuario> usuarioCurrent = usuarioRepository.findByCodigo(usuario.getCodigo());
		if (usuarioCurrent.isPresent() && usuario.getCodigo().charAt(0)!='0') {
			
			Integer documento = usuarioCurrent.get().getDocumento();
			if (usuario.getDocumento().equals(documento)) {

				return true;
			}
		}

		return false;

	}

	@Override
	public List<UsuarioSemestre> Usuariosemestres(Integer id) {
		Optional<Usuario>usuario=usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return usuario.get().getUsuarioSemestres();
		}
		return null;
	}

}
