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

import co.com.example.test.entity.IntentoCambio;
import co.com.example.test.service.impl.IntentoCambioServiceImpl;

@RestController
@RequestMapping("/intento/cambio")
public class IntentoCambioController {
	@Autowired
	IntentoCambioServiceImpl intentoCambioServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(intentoCambioServiceImpl.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(intentoCambioServiceImpl.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateCodigo(@RequestBody IntentoCambio intento ,@PathVariable Integer id){
		try {
			return ResponseEntity.ok(intentoCambioServiceImpl.update(id,intento));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveCodigo(@RequestBody IntentoCambio intentoCambio) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(intentoCambioServiceImpl.save(intentoCambio));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
			
			return ResponseEntity.ok(intentoCambioServiceImpl.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
