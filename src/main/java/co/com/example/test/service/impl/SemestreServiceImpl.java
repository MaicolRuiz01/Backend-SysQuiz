package co.com.example.test.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.example.test.dto.UserDto;
import co.com.example.test.entity.Semestre;
import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;
import co.com.example.test.repository.ISemestreRepository;
import co.com.example.test.service.ISemestreService;

@Service
public class SemestreServiceImpl implements ISemestreService {

	@Autowired
	ISemestreRepository semestreRepository;

	@Override
	public List<Semestre> findAllSemestres() {

		return semestreRepository.findAll();
	}

	@Override
	public Optional<Semestre> findByIdSemestre(Integer id) {
		Optional<Semestre> semestre = semestreRepository.findById(id);
		if (semestre.isPresent()) {
			return semestre;
		}
		return Optional.empty();

	}

	@Override
	public Semestre saveSemestre(Semestre semestre) {

		Calendar calendario2 = Calendar.getInstance();
		calendario2.setTime(semestre.getFechaInicio());
		int anio2 = calendario2.get(Calendar.YEAR);
		int mes2 = calendario2.get(Calendar.MONTH) + 1; // Los meses en Calendar van de 0 a 11, por lo que se suma 1
		int dia2 = calendario2.get(Calendar.DAY_OF_MONTH);

		List<Semestre> semestreAño = semestreEnUnAño(anio2);
		int nSemestres = semestreAño.size();
		if (nSemestres >= 0 && nSemestres < 2) {
			String nombre = "";
			if (nSemestres == 0) {
				nombre = anio2 + "-I";
			} else {
				nombre = anio2 + "-II";
			}
			semestre.setNombre(nombre);
			semestre.setEstado("REGISTRADO");
			semestre.setVisibilidad("PRIVADO");
			semestre.setFechaRegistro(new Date());
			semestreRepository.save(semestre);
			return semestre;

		}
		return null;

	}

	public List<Semestre> semestreEnUnAño(Integer anio) {

		List<Semestre> semestres = semestreRepository.findAll();
		List<Semestre> listaReturn = new ArrayList<>();
		Integer contador = 0;
		for (int i = 0; i < semestres.size(); i++) {
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(semestres.get(i).getFechaFin());
			int anio2 = calendario.get(Calendar.YEAR);
			if (anio2 == anio) {
				listaReturn.add(semestres.get(i));
			}

		}
		return listaReturn;

	}

	@Override
	public Semestre updateSemestre(Integer id, Semestre semestre) {
		Optional<Semestre> currentSemestre = semestreRepository.findById(id);
		if (currentSemestre.isPresent()) {
			Semestre semestreReturn = currentSemestre.get();
			semestreReturn.setFechaInicio(semestre.getFechaInicio());
			semestreReturn.setFechaFin(semestre.getFechaFin());
			semestreReturn.setVisibilidad(semestre.getVisibilidad());
			semestreReturn.setEstado(semestre.getEstado());
			semestreRepository.save(semestreReturn);

			return semestreReturn;
		}
		return null;
	}

	@Override
	public Semestre delete(Integer id) {

		Optional<Semestre> semestre = semestreRepository.findById(id);
		if (semestre.isPresent()) {
			semestreRepository.deleteById(id);
			return semestre.get();
		}
		return null;
	}

	@Override
	public List<Semestre> semestreActual(String estado) {
		// TODO Auto-generated method stub

		return semestreRepository.findByEstado(estado);
	}

	@Override
	public List<UsuarioSemestre> usuarioSemestre(Integer id) {
		Optional<Semestre> semOptional = semestreRepository.findById(id);
		if (semOptional.isPresent()) {
			
			return semOptional.get().getUsuarioSemestres();
			}
			

		

		return null;
	}

}
