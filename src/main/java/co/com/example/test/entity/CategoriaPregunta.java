package co.com.example.test.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="categoria_pregunta")

public class CategoriaPregunta {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	@Column(name="evaluacion_id")
	private Integer evaluacionId;
	@OneToMany(mappedBy = "categoriaId", fetch = FetchType.EAGER)
	private List<Pregunta>preguntas;
	

}
