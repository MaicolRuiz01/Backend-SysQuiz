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
@Table(name="calificacion")
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer calificacion;
	private String mensaje;
	@Column(name="fecha_registro")
    private Date fechaRegistro;
	
	
	@Column(name="respondio_evaluacion_id")
	private Integer respondioEvaluacion;
	
}
