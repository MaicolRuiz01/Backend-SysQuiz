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
@Table(name="codigo_registro")
public class CodigoRegistro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="pre_registro_id")
	private Integer preRegistroId;
	private String email;
	private Integer codigo;
	@Column(name="fecha_registro")
	private Date fechaRegistro;

}
