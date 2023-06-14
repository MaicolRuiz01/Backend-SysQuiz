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


import co.com.example.test.entity.Calificacion;

import co.com.example.test.service.impl.CalificacionServiceImpl;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {
	@Autowired
	CalificacionServiceImpl calificacionServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAllCalificaciones(){
		try {
			return ResponseEntity.ok(calificacionServiceImpl.findAllCalificaciones());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
}
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdCalificacion(@PathVariable Integer id){
		try {
			
			//Busco la calificacion
			Optional<Calificacion> calificacion=calificacionServiceImpl.findByIdCalificacion(id);
			//Creo el un objecto ModelMapper
			ModelMapper modelMapper= new ModelMapper();
			//Creo el objecto CalificacionDto
			//utilizo el obj modelMapper.map(recibe el objecto que quiero mapear , la clase del objecto destino)
			Calificacion calificacionReturn=modelMapper.map(calificacion.get(), Calificacion.class);
			//Retornamos el objecto mapeado
			return ResponseEntity.ok(calificacionReturn);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveCalificacion(@RequestBody Calificacion calificacion){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(calificacionServiceImpl.saveCalificacion(calificacion));
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			
	}
	@PutMapping("/{id}/update")
	public ResponseEntity<?>updateCalificacion(@PathVariable Integer id,@RequestBody Calificacion calificacion){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(calificacionServiceImpl.updateCalificacion(id, calificacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteCalificacion(@PathVariable Integer id){
		try {
			return ResponseEntity.ok(calificacionServiceImpl.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
}
