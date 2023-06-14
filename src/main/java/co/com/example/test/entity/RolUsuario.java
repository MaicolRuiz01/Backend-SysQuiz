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
@Data
@Entity
@Table(name="rol_usuario")
public class RolUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="usuario_id")
	private Integer usuarioId;
	@ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rolId;
	@Column(name="fecha_registro")
	private Date fechaRegistro;

}
