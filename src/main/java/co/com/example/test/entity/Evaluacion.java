package co.com.example.test.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="evaluacion")
public class Evaluacion {
		
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String titulo;
		private String descripcion;
		@Column(name="semestre_id")
		private Integer semestreId;
		@Column(name="usuario_id")
		private Integer usuarioId;
		@Column(name="fecha_registro")
		private Date fechaRegistro;
		@ManyToOne
		@JoinColumn(name="categoria_id")
		private CategoriaEvaluacion categoriaId;
		@OneToMany(mappedBy = "evaluacionId" ,fetch = FetchType.EAGER)
		private List<Criterio> criterio;
		
		@OneToMany(mappedBy =  "evaluacionId",fetch = FetchType.EAGER)
		
		private Set<EstadoEvaluacion>estadosEvaluacion=new HashSet<>();
		
		
		
		
		
}
