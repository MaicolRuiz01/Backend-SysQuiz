package co.com.example.test.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="semestre")


public class Semestre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="fecha_inicio")
    private Date fechaInicio;
	@Column(name="fecha_fin")
    private Date fechaFin;
	@Column(name="fecha_registro")
    private Date fechaRegistro;
	private String nombre;
	private String visibilidad;
	private String estado;
	//foraneas
	
	@Column(name="usuario_id")
	//@ManyToOne
	//@JoinColumn(name="usuario_id")
	private Integer usuarioId;
	@JsonIgnore
	@OneToMany(mappedBy = "semestreId" ,fetch = FetchType.EAGER)
	public List<UsuarioSemestre>usuarioSemestres;
}
