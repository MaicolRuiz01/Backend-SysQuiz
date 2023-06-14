package co.com.example.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.dto.UserDto;
import co.com.example.test.entity.Semestre;
import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;
import co.com.example.test.service.impl.SemestreServiceImpl;

@RestController
@RequestMapping("/semestre")
public class SemestreController {

	@Autowired
	SemestreServiceImpl semestreServiceImpl;

	@GetMapping
	public ResponseEntity<?> findAllUser() {
		try {
			return ResponseEntity.ok(semestreServiceImpl.findAllSemestres());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<?> semestreActual(@PathVariable String estado) {
		try {
			return ResponseEntity.ok(semestreServiceImpl.semestreActual(estado));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<?> findByIdSemestre(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(semestreServiceImpl.findByIdSemestre(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}


	@GetMapping("/{id}/docentes")
	public ResponseEntity<?> findByIdSemestreDocentes(@PathVariable Integer id) {
		try {
			List<UsuarioSemestre>lista=semestreServiceImpl.usuarioSemestre(id);
			List<UserDto>listaReturn=new ArrayList<>();
			ModelMapper model=new ModelMapper();
			for (int i = 0; i < lista.size(); i++) {
				UserDto userReturn=model.map(lista.get(i).getUsuarioId(), UserDto.class);
				listaReturn.add(userReturn);
			}
			
			return ResponseEntity.ok(listaReturn);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<?> saveSemestre(@RequestBody Semestre semestre) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(semestreServiceImpl.saveSemestre(semestre));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateSemestre(@PathVariable Integer id, @RequestBody Semestre semestre) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(semestreServiceImpl.updateSemestre(id, semestre));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSemestre(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(semestreServiceImpl.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
