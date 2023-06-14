package co.com.example.test.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="usuario_evaluacion")

public class UsuarioEvaluacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String estado;
	@Column(name="fecha_registro")
    private Date fechaRegistro;
	
	//foraneas
	@Column(name="evaluacion_id")
	private Integer evaluacionId;
	@Column(name="usuario_id")
	private Integer usuarioId;
	@Column(name="usuario_semestre_id")
	private Integer usuarioSemestreId;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuarioEvaluacionId")
	private List<RespondioEvaluacion> respondioEvaluacion;
	
}
