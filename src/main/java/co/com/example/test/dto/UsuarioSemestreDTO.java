package co.com.example.test.dto;

import java.util.Date;
import java.util.List;

import co.com.example.test.entity.Semestre;
import co.com.example.test.entity.UsuarioEvaluacion;
import lombok.Data;
@Data
public class UsuarioSemestreDTO {
	private Integer id;
    private Date fechaRegistro;
	private Semestre  semestreId;
	
	private UserDto usuarioId;
	private List<UsuarioEvaluacion>listaEvaluacionesRegistradas;


}
