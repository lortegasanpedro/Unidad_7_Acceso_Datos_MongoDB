package com.lortega.birtlh.txuleta.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany
	@JoinColumn (name="txuleta_id")
	List<Txuleta> txuletas = new ArrayList<>();
	
	@Enumerated(EnumType.ORDINAL)
	private EnumCategorias categoria;
	
	@Column
	private String descripcion;
	
	@Column
	private Date fechaMod;
	
}
