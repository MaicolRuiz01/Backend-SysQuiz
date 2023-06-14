package co.com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.Evaluacion;

public interface IEvaluacionRepository extends JpaRepository<Evaluacion, Integer>{
	List<Evaluacion> findBySemestreId(Integer semestreId);
	

}