package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.RolUsuario;
import co.com.example.test.entity.Semestre;
import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;

public interface IUsuarioService {
	
	public List<Usuario> findAllUser();
	public Optional<Usuario> findByIdUser(Integer id);
	public Usuario saveUser(Usuario usuario);
	public Usuario updateUser(Integer id,Usuario usuario);
	public Usuario delete(Integer id);
	public List<Semestre>semestres(Integer id);
	public List<UsuarioSemestre>Usuariosemestres(Integer id);
	public Optional<Usuario>findOneByCorreo(String correo);
	public boolean existeUsuario(Usuario usuario);
	

}
