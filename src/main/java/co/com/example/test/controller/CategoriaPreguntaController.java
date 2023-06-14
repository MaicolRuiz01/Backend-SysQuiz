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

import co.com.example.test.entity.CategoriaPregunta;
import co.com.example.test.service.impl.CategoriaPreguntaServiceImpl;

@RestController
@RequestMapping("/categoria/pregunta")
public class CategoriaPreguntaController {

	@Autowired
	CategoriaPreguntaServiceImpl categoriaPreguntaServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(categoriaPreguntaServiceImpl.findAllCategoriaPreguntas());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(categoriaPreguntaServiceImpl.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateCategoria(@RequestBody CategoriaPregunta categoriaPregunta ,@PathVariable Integer id){
		try {
			return ResponseEntity.ok(categoriaPreguntaServiceImpl.updateCategoriaPregunta(id, categoriaPregunta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveCategoria(@RequestBody CategoriaPregunta categoriaPregunta) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaPreguntaServiceImpl.saveCategoriaPregunta(categoriaPregunta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id){
			try {
				categoriaPreguntaServiceImpl.deleteCategoriaPregunta(id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
	@GetMapping("/{id}/evaluacion")
	public ResponseEntity<?> listaCategoriasIdEvaluacion(@PathVariable Integer id){
		try {
			
			return ResponseEntity.ok(categoriaPreguntaServiceImpl.findByIdEvaluacionId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
}
