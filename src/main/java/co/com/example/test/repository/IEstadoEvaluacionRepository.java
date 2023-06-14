package co.com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.EstadoEvaluacion;

public interface IEstadoEvaluacionRepository extends JpaRepository<EstadoEvaluacion, Integer> {
	List<EstadoEvaluacion> findByEvaluacionId(Integer evaluacionId);

}
