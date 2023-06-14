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
@Table(name="usuario_codigo_registro")
public class UsuarioCodigoRegistro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="usuario_id")
	private Integer usuarioId;
	@Column(name="codigo_registro_id")
	private Integer codigoRegistroId;
	@Column(name="fecha_registro")
	private Date fechaRegistro;

}
