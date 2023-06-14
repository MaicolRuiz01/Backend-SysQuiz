package co.com.example.test.controller;

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

import co.com.example.test.entity.Estado;
import co.com.example.test.service.impl.EstadoServiceImpl;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	
	@Autowired
	EstadoServiceImpl estadoServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(estadoServiceImpl.findAllEstado());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(estadoServiceImpl.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateEstado(@RequestBody Estado estado ,@PathVariable Integer id){
		try {
			return ResponseEntity.ok(estadoServiceImpl.updateEstado(id, estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEstado(@RequestBody Estado estado) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(estadoServiceImpl.saveEstado(estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id){
			try {
				estadoServiceImpl.deleteEstado(id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
}
