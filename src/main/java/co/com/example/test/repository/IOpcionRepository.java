package co.com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.Opcion;

public interface IOpcionRepository extends JpaRepository<Opcion, Integer> {

}
