package co.com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.CategoriaPregunta;

public interface ICategoriaPreguntaRepository extends JpaRepository<CategoriaPregunta, Integer> {
List<CategoriaPregunta> findByEvaluacionId(Integer evaluacionId);
}
