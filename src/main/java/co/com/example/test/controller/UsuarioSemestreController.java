package co.com.example.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.dto.UserDto;
import co.com.example.test.dto.UsuarioSemestreDTO;
import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;
import co.com.example.test.service.impl.UsuarioSemestreServiceImpl;



@RestController
@RequestMapping("/usuario/semestre")

public class UsuarioSemestreController {
	@Autowired
	UsuarioSemestreServiceImpl usuarioSemestreServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAllUsuarios(){
		try {
			List<UsuarioSemestre>lista=usuarioSemestreServiceImpl.findAllUsuariosSemestres();
			List<UsuarioSemestreDTO>listaReturn=new ArrayList<>();
			ModelMapper model=new ModelMapper();
			for (int i = 0; i < lista.size(); i++) {
				UsuarioSemestre usuario=lista.get(i);
				
				UserDto usuarioNew =model.map(usuario.getUsuarioId(), UserDto.class);
				UsuarioSemestreDTO usuarioReturn=new UsuarioSemestreDTO();
				usuarioReturn.setId(usuario.getId());
				usuarioReturn.setUsuarioId(usuarioNew);
				usuarioReturn.setSemestreId(usuario.getSemestreId());
				usuarioReturn.setFechaRegistro(usuario.getFechaRegistro());
				listaReturn.add(usuarioReturn);
			}
			
			return ResponseEntity.ok(listaReturn);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
}
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdUser(@PathVariable Integer id){
		try {
			
			//Busco la respuesta
			Optional<UsuarioSemestre> usuario=usuarioSemestreServiceImpl.findByIdUsuarioSemestre(id);
			/*
			 ModelMapper model=new ModelMapper();
			UserDto usuarioNew =model.map(usuario.get().getUsuarioId(), UserDto.class);
			UsuarioSemestreDTO usuarioReturn=new UsuarioSemestreDTO();
			usuarioReturn.setId(usuario.get().getId());
			usuarioReturn.setUsuarioId(usuarioNew);
			usuarioReturn.setSemestreId(usuario.get().getSemestreId());
			usuarioReturn.setFechaRegistro(usuario.get().getFechaRegistro());
			 */
			return ResponseEntity.ok(usuario);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveUserSemestre(@RequestBody UsuarioSemestre user){
		
		try {
			Optional<UsuarioSemestre> usuario=usuarioSemestreServiceImpl.saveSemestre(user);
			if(usuario.isPresent()) {
				ModelMapper model=new ModelMapper();
				UserDto usuarioNew =model.map(usuario.get().getUsuarioId(), UserDto.class);
				UsuarioSemestreDTO usuarioReturn=new UsuarioSemestreDTO();
				usuarioReturn.setId(usuario.get().getId());
				usuarioReturn.setUsuarioId(usuarioNew);
				usuarioReturn.setSemestreId(usuario.get().getSemestreId());
				usuarioReturn.setFechaRegistro(usuario.get().getFechaRegistro());
				return ResponseEntity.status(HttpStatus.CREATED).body(usuarioReturn);	
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			
	}
	@PutMapping("/{id}/update")
	public ResponseEntity<?>updateRespuesta(@PathVariable Integer id,@RequestBody  UsuarioSemestre user){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSemestreServiceImpl.updateSemestre(id, user));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteUser(@PathVariable Integer id){
		try {
			return ResponseEntity.ok(usuarioSemestreServiceImpl.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@GetMapping("/{id}/docente")
	public ResponseEntity<?>listaSemestreDocente(@PathVariable Integer id){
		try {
			Usuario user=new Usuario();
			user.setId(id);
			List<UsuarioSemestre>lista=usuarioSemestreServiceImpl.findByIdUsuario(user);
			List<UsuarioSemestreDTO>listaReturn=new ArrayList<>();
			ModelMapper model=new ModelMapper();
			for (int i = 0; i < lista.size(); i++) {
				UsuarioSemestre usuario=lista.get(i);
				
				UserDto usuarioNew =model.map(usuario.getUsuarioId(), UserDto.class);
				UsuarioSemestreDTO usuarioReturn=new UsuarioSemestreDTO();
				usuarioReturn.setId(usuario.getId());
				usuarioReturn.setUsuarioId(usuarioNew);
				usuarioReturn.setSemestreId(usuario.getSemestreId());
				usuarioReturn.setFechaRegistro(usuario.getFechaRegistro());
				usuarioReturn.setListaEvaluacionesRegistradas(usuario.getListaEvaluacionesRegistradas());
				listaReturn.add(usuarioReturn);
			}
			return ResponseEntity.ok(listaReturn);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
