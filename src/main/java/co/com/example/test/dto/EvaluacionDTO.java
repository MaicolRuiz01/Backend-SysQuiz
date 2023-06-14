package co.com.example.test.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import co.com.example.test.entity.CategoriaEvaluacion;
import co.com.example.test.entity.EstadoEvaluacion;
import lombok.Data;
@Data
public class EvaluacionDTO {
	private Integer id;
	private String titulo;
	private String descripcion;
	private Integer semestreId;
	private Date fechaRegistro;
	private CategoriaEvaluacion categoriaId;
	private Set<EstadoEvaluacion>estadosEvaluacion=new HashSet<>();

}
