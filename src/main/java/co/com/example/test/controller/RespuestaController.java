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



import co.com.example.test.entity.Respuesta;

import co.com.example.test.service.impl.RespuestaServiceImpl;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {
	@Autowired
	RespuestaServiceImpl respuestaServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAllRespuestas(){
		try {
			return ResponseEntity.ok(respuestaServiceImpl.findAllRespuestas());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
}
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdRespuesta(@PathVariable Integer id){
		try {
			
			//Busco la respuesta
			Optional<Respuesta> respuesta=respuestaServiceImpl.findByIdRespuesta(id);
			//Creo el un objecto ModelMapper
			ModelMapper modelMapper= new ModelMapper();
			//Creo el objecto Dto
			//utilizo el obj modelMapper.map(recibe el objecto que quiero mapear , la clase del objecto destino)
			Respuesta respuestaReturn=modelMapper.map(respuesta.get(), Respuesta.class);
			//Retornamos el objecto mapeado
			return ResponseEntity.ok(respuestaReturn);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveRespuesta(@RequestBody Respuesta respuesta){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(respuestaServiceImpl.saveRespuesta(respuesta));
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			
	}
	@PutMapping("/{id}/update")
	public ResponseEntity<?>updateRespuesta(@PathVariable Integer id,@RequestBody Respuesta respuesta){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(respuestaServiceImpl.updateRespuesta(id, respuesta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteRespuesta(@PathVariable Integer id){
		try {
			return ResponseEntity.ok(respuestaServiceImpl.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

}
