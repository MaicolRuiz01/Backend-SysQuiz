package co.com.example.test.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="usuario_semestre")
public class UsuarioSemestre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="fecha_registro")
    private Date fechaRegistro;
	@ManyToOne
	@JoinColumn(name="semestre_id")
	private Semestre  semestreId;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	
	private Usuario usuarioId;
	@OneToMany(mappedBy = "usuarioSemestreId",fetch = FetchType.EAGER)
	private List<UsuarioEvaluacion>listaEvaluacionesRegistradas;

	
	
}
