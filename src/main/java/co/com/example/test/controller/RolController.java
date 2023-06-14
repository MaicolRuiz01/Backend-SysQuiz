package co.com.example.test.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.entity.Rol;
import co.com.example.test.repository.IRolRepository;
import co.com.example.test.service.impl.RolServiceImpl;

@RestController
@RequestMapping("/rol")
@CrossOrigin
public class RolController {
	
	@Autowired
	IRolRepository rolRepository;
	@Autowired
	RolServiceImpl rolServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> getAllRol(){
		try {
			return ResponseEntity.ok(rolRepository.findAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable Integer id){
		try {
			Optional<Rol>rol=rolServiceImpl.getById(id);
			if(rol.isPresent()) {
				return ResponseEntity.ok(rol);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
			
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@PostMapping("/save")
	public ResponseEntity<?>saveRol(@RequestBody Rol rol){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(rolServiceImpl.saveRol(rol));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

}
