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
@Table(name="pre_registro")
public class PreRegistro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Integer documento;
	private Integer codigo;
	private String email;
	private String password;
	private String estado;
	@Column(name="fecha_registro")
	private Date fechaRegistro;

}
