package co.com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.PreRegistro;

public interface IPreRegistroRepository extends JpaRepository<PreRegistro, Integer> {
	
	public List<PreRegistro> findByCodigo(Integer codigo);

}
