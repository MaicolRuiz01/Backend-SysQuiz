package co.com.example.test.entity;

import java.util.Date;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="codigo_cambio")
public class CodigoCambio {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="usuario_id")
	private Integer usuarioId;
	private Integer codigo;
	private String mensaje;
	private String email;
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	

}
