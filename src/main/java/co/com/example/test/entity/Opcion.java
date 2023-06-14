package co.com.example.test.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="opcion")
public class Opcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer valor;
	private String descripcion;
	private String comentario;
	@Column(name="criterio_id")
	private Integer criterioId;
	
}

	

