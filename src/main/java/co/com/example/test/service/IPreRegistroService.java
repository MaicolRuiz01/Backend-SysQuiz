package co.com.example.test.service;

import java.util.List;
import java.util.Optional;

import co.com.example.test.entity.PreRegistro;

public interface IPreRegistroService {
	public List<PreRegistro>lista();
	public Optional<PreRegistro>getById(Integer id);
	public PreRegistro savePreRregistro(PreRegistro preRegistro);
	public List<PreRegistro>saveLista(List<PreRegistro> lista);
	public PreRegistro updatePreRegistro(PreRegistro preRegistro,Integer id);
	public PreRegistro deletePreRegistro(Integer id);
	public Boolean existePreregistro(PreRegistro preRegistro);
	public Boolean verificoCodigo(PreRegistro preRegistro);

}
