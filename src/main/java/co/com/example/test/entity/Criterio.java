package co.com.example.test.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="criterio")

public class Criterio {
	
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String descripcion;
		@Column(name="evaluacion_id")
		private Integer evaluacionId;
		
		@OneToMany(mappedBy = "criterioId" ,fetch =FetchType.EAGER)
		private List<Opcion>opciones;

}
