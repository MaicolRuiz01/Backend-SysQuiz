package co.com.example.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.entity.PreRegistro;
import co.com.example.test.entity.Usuario;
import co.com.example.test.service.impl.PreRegistroServiceImpl;

@RestController
@RequestMapping("/pre")
@CrossOrigin
public class PreRegistroController {
	
	@Autowired
	PreRegistroServiceImpl preRegistroServiceImpl;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<?>saveDocente(@RequestBody PreRegistro preRegistro){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(preRegistroServiceImpl.savePreRregistro(preRegistro));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	@PostMapping("/save/lista")
	public ResponseEntity<?> saveListaDocente(@RequestBody List<PreRegistro> lista){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(preRegistroServiceImpl.saveLista(lista));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>update(@RequestBody PreRegistro preRegistro,@PathVariable Integer id){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(preRegistroServiceImpl.updatePreRegistro(preRegistro, id));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PostMapping("/security/codigo")
	public ResponseEntity<?> existePreRegistro(@RequestBody PreRegistro preRegistro){
		try {
			return ResponseEntity.ok(preRegistroServiceImpl.existePreregistro(preRegistro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@GetMapping
	public ResponseEntity<?>listraPre(){
		try {
			return ResponseEntity.ok(preRegistroServiceImpl.lista());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable Integer id){
		try {
			Optional<PreRegistro> pre=preRegistroServiceImpl.getById(id);
			if(pre.isPresent()) {
				return ResponseEntity.ok(pre);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable Integer id){
		try {
	
			return ResponseEntity.ok(preRegistroServiceImpl.deletePreRegistro(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	
	

}
