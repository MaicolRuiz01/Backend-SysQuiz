package co.com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.Pregunta;

public interface IPreguntaRepository extends JpaRepository<Pregunta, Integer>{

}
