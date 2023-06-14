package co.com.example.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.Estado;

public interface IEstadoRepository extends JpaRepository<Estado, Integer> {
	Optional<Estado> findOneByNombre(String nombre);
}
