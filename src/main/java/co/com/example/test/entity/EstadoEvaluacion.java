package co.com.example.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="evaluacion_estado")

public class EstadoEvaluacion {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estadoId;
	@Column(name="evaluacion_id")
	private Integer evaluacionId;
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
}