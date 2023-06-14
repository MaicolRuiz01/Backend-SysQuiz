package co.com.example.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.dto.UserDto;
import co.com.example.test.entity.Usuario;
import co.com.example.test.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<?> findAllUser(@RequestHeader(name = "Authorization") String authorizationHeader) {
		try {

			
					List<Usuario> usuarios = usuarioServiceImpl.findAllUser();
					List<UserDto> usuariosDto = new ArrayList<>();
					ModelMapper modelMapper = new ModelMapper();
					for (int i = 0; i < usuarios.size(); i++) {
						Usuario usuario = usuarios.get(i);
						UserDto userReturn = modelMapper.map(usuario, UserDto.class);
						usuariosDto.add(userReturn);

					}
					return ResponseEntity.ok(usuariosDto);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}


	@PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
	@GetMapping("/{id}/semestres")
	public ResponseEntity<?> listaSemestre(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(usuarioServiceImpl.semestres(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			// TODO: handle exception
		}
	}
	@PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
	@GetMapping("/{id}/semestre/docente")
	public ResponseEntity<?> listaUsuarioSemestre(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(usuarioServiceImpl.Usuariosemestres(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			// TODO: handle exception
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdUser(@PathVariable Integer id) {
		try {

			// Busco el usuario
			Optional<Usuario> usuario = usuarioServiceImpl.findByIdUser(id);
			// Creo el un objecto ModelMapper
			ModelMapper modelMapper = new ModelMapper();
			// Creo el objecto UserDto
			// utilizo el obj modelMapper.map(recibe el objecto que quiero mapear , la clase
			// del objecto destino)
			UserDto userReturn = modelMapper.map(usuario.get(), UserDto.class);
			// Retornamos el objecto mapeado
			return ResponseEntity.ok(userReturn);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody Usuario usuario) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceImpl.saveUser(usuario));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody Usuario usuario) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceImpl.updateUser(id, usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(usuarioServiceImpl.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	@PostMapping("/security/user")
	public ResponseEntity<?> exiteUsuario(@RequestBody Usuario usuario){
		try {
			return ResponseEntity.ok(usuarioServiceImpl.existeUsuario(usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
