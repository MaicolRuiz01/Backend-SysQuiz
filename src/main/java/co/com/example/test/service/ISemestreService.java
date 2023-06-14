package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.Semestre;
import co.com.example.test.entity.Usuario;
import co.com.example.test.entity.UsuarioSemestre;


public interface ISemestreService {
	public List<Semestre> findAllSemestres();
	public Optional<Semestre> findByIdSemestre(Integer id);
	public Semestre saveSemestre(Semestre semestre);
	public Semestre updateSemestre(Integer id,Semestre semestre);
	public Semestre delete(Integer id);
	public List<Semestre>semestreActual(String estado);
	public List<UsuarioSemestre>usuarioSemestre(Integer id);
	
}
