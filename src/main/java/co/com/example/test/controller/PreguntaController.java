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

import co.com.example.test.entity.Pregunta;
import co.com.example.test.service.impl.PreguntaServiceImpl;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {
	
	@Autowired
	PreguntaServiceImpl preguntaServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(preguntaServiceImpl.findAllPregunta());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(preguntaServiceImpl.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updatePregunta(@RequestBody Pregunta pregunta ,@PathVariable Integer id){
		try {
			return ResponseEntity.ok(preguntaServiceImpl.updatePregunta(id, pregunta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> savePregunta(@RequestBody Pregunta pregunta) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(preguntaServiceImpl.savePregunta(pregunta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id){
			try {
				preguntaServiceImpl.deletePregunta(id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}

}
