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

import co.com.example.test.entity.SubCategoriaPregunta;
import co.com.example.test.service.impl.SubCategoriaPreguntaServiceImpl;

@RestController
@RequestMapping("/sub/categoria/pregunta")
public class SubCategoriaPreguntaController {

	
	@Autowired
	SubCategoriaPreguntaServiceImpl subCategoriaPreguntaServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(subCategoriaPreguntaServiceImpl.findByAllSubCategoriaPreguntas());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(subCategoriaPreguntaServiceImpl.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateSubCategoria(@RequestBody SubCategoriaPregunta subCategoriaPregunta ,@PathVariable Integer id){
		try {
			return ResponseEntity.ok(subCategoriaPreguntaServiceImpl.updateSubCategoriaPregunta(id, subCategoriaPregunta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveSubCategoria(@RequestBody SubCategoriaPregunta subCategoriaPregunta) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(subCategoriaPreguntaServiceImpl.saveSubCategoriaPregunta(subCategoriaPregunta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id){
			try {
				subCategoriaPreguntaServiceImpl.deleteSubCategoriaPregunta(id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
}
