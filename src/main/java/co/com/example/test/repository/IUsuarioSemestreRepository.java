package co.com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;

public interface IUsuarioSemestreRepository extends JpaRepository<UsuarioSemestre, Integer> {
	List<UsuarioSemestre> findByUsuarioId(Usuario usuarioId);;

}
