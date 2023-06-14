package co.com.example.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.example.test.entity.Usuario;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Optional<Usuario>findByEmail(String email);
	public Optional<Usuario> findByDocumento(Integer documento);
	public Optional<Usuario> findByCodigo(String codigo);

}
