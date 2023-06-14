package co.com.example.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.CodigoRegistro;

public interface ICodigoRegistroRepository extends JpaRepository<CodigoRegistro, Integer> {
 public Optional<CodigoRegistro> findByPreRegistroId(Integer id);
 
}
