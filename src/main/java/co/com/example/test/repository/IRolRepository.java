package co.com.example.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByNombre(String nombre);

}
