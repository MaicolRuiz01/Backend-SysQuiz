package co.com.example.test.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="pregunta")
public class Pregunta {
	
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		@Column(name="evaluacion_id")
		private Integer evaluacionId;
		@Column(name="criterio_id")
		private Integer criterioId;
		@Column(name="categoria_id")
		private Integer categoriaId;
		private String descripcion;
		@Column(name="fecha_registro")
		private Date fechaRegistro;
}
