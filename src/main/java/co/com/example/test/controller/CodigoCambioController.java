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

import co.com.example.test.entity.CodigoCambio;
import co.com.example.test.service.impl.CodigoCambioServiceImpl;

@RestController
@RequestMapping("/codigo/cambio")
public class CodigoCambioController {
	@Autowired
	CodigoCambioServiceImpl codigoCambioServiceImpl;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(codigoCambioServiceImpl.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(codigoCambioServiceImpl.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateCodigo(@RequestBody CodigoCambio codigoCambio ,@PathVariable Integer id){
		try {
			return ResponseEntity.ok(codigoCambioServiceImpl.updateCodigoCambio(codigoCambio, id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveCodigo(@RequestBody CodigoCambio codigoCambio) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(codigoCambioServiceImpl.saveCodigoCambio(codigoCambio));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
			codigoCambioServiceImpl.deleteCodigoCambio(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
