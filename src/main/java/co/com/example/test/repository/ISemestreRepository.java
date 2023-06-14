package co.com.example.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.Semestre;

public interface ISemestreRepository extends JpaRepository<Semestre, Integer> {
	Optional<Semestre> findByNombre(String nombre);
	List<Semestre> findByVisibilidad(String visibilidad);
	List<Semestre> findByEstado(String estado);
	

}
