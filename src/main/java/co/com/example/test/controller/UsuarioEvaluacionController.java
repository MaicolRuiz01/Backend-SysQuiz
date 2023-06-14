package co.com.example.test.controller;

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


import co.com.example.test.entity.UsuarioEvaluacion;
import co.com.example.test.service.impl.UsuarioEvaluacionServiceImpl;





@RestController
@RequestMapping("/usuario/evaluacion")
public class UsuarioEvaluacionController {
	@Autowired
	UsuarioEvaluacionServiceImpl usuarioEvaluacionServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAllUsuarios(){
		try {
			return ResponseEntity.ok(usuarioEvaluacionServiceImpl.findAllUsersEvaluados());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
}
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdUser(@PathVariable Integer id){
		try {
			
			//Busco la respuesta
			Optional<UsuarioEvaluacion> usuario=usuarioEvaluacionServiceImpl.findByIdUserEvaluado(id);
			//Creo el un objecto ModelMapper
			ModelMapper modelMapper= new ModelMapper();
			//Creo el objecto Dto
			//utilizo el obj modelMapper.map(recibe el objecto que quiero mapear , la clase del objecto destino)
			UsuarioEvaluacion userReturn=modelMapper.map(usuario.get(), UsuarioEvaluacion.class);
			//Retornamos el objecto mapeado
			return ResponseEntity.ok(userReturn);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody UsuarioEvaluacion user){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioEvaluacionServiceImpl.saveUserEvaluado(user));
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			
	}
	@PutMapping("/{id}/update")
	public ResponseEntity<?>updateRespuesta(@PathVariable Integer id,@RequestBody  UsuarioEvaluacion user){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioEvaluacionServiceImpl.updateUser(id, user));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteUser(@PathVariable Integer id){
		try {
			return ResponseEntity.ok(usuarioEvaluacionServiceImpl.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

}
