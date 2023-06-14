package co.com.example.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="respuesta")
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="fecha_registro")
    private Date fechaRegistro;
	//foraneas
	@Column(name="pregunta_id")
	private Integer preguntaId;
	
	@Column(name="opcion_id")
	private Integer opcionId;
	@Column(name="usuario_evaluacion_id")
	private Integer usuarioEvaluacionId;
}
