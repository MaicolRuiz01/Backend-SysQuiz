package co.com.example.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.test.dto.EvaluacionDTO;
import co.com.example.test.entity.Evaluacion;
import co.com.example.test.service.impl.EvaluacionServiceImpl;

@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {

	@Autowired
	EvaluacionServiceImpl evaluacionServiceImpl;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			List<Evaluacion> evaluaciones = evaluacionServiceImpl.findAllEvaluacions();
			ModelMapper modelMapper = new ModelMapper();
			List<EvaluacionDTO> evaluacionesReturn = new ArrayList<>();
			for (int i = 0; i < evaluaciones.size(); i++) {
				Evaluacion evaluacionOld = evaluaciones.get(i);
				EvaluacionDTO newEvaluacion = modelMapper.map(evaluacionOld, EvaluacionDTO.class);

				evaluacionesReturn.add(newEvaluacion);

			}
			return ResponseEntity.ok(evaluacionesReturn);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(evaluacionServiceImpl.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/{id}/semestre")
	public ResponseEntity<?> listaEvaluacionesFindById(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok(evaluacionServiceImpl.listaEvaluacionByIdSemestre(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateEvaluacion(@RequestBody Evaluacion evaluacion, @PathVariable Integer id) {
		try {
			return ResponseEntity.ok(evaluacionServiceImpl.updateEvaluacion(id, evaluacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<?> saveEvaluacion(@RequestBody Evaluacion evaluacion) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionServiceImpl.saveEvaluacion(evaluacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			evaluacionServiceImpl.deleteEvaluacion(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
