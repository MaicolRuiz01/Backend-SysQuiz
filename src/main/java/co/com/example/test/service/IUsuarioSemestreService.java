package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;

public interface IUsuarioSemestreService {
	public List<UsuarioSemestre> findAllUsuariosSemestres();
	public Optional<UsuarioSemestre> findByIdUsuarioSemestre(Integer id);
	public Optional<UsuarioSemestre> saveSemestre(UsuarioSemestre usuariosemestre);
	public UsuarioSemestre updateSemestre(Integer id,UsuarioSemestre usuariosemestre);
	public UsuarioSemestre  delete(Integer id);
	public List<UsuarioSemestre>findByIdUsuario(Usuario usuario);
}
