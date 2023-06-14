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
@Table(name="intento_cambio")
public class IntentoCambio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="codigo_cambio_id")
	private Integer codigoCambioId;
	@Column(name="codigo_usuario")
	private Integer codigoUsuario;
	@Column(name="fecha_registro")
	private Date fechaRegistro;

}
