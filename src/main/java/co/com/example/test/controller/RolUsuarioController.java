package co.com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.entity.RolUsuario;
import co.com.example.test.service.impl.RolUsuarioServiceImpl;

@RestController
@RequestMapping("/usuario/roles")
@CrossOrigin
public class RolUsuarioController {
	@Autowired
	RolUsuarioServiceImpl rolUsuarioServiceImpl;
	
	@GetMapping
	public ResponseEntity<?>findAll(){
		try {
			return ResponseEntity.ok(rolUsuarioServiceImpl.findAllrolUsuarios());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable Integer id){
		try {
			return ResponseEntity.ok(rolUsuarioServiceImpl.findByIdRolUsuario(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PostMapping("/save")
	public ResponseEntity<?>saveUserRol(@RequestBody RolUsuario rol){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(rolUsuarioServiceImpl.saveRolUusario(rol));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteRol(@PathVariable Integer id){
		try {
			rolUsuarioServiceImpl.deleteRolUsuario(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
}
}
