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
	
	@Enumerated(EnumType.STRING)
	private EnumCategorias categoria;
	
	@Column
	private String descripcion;
	
	@Column
	private Date fechaMod;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Txuleta> getTxuletas() {
		return txuletas;
	}

	public void setTxuletas(List<Txuleta> txuletas) {
		this.txuletas = txuletas;
	}

	public EnumCategorias getCategoria() {
		return categoria;
	}

	public void setCategoria(EnumCategorias categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaMod() {
		return fechaMod;
	}

	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}
		
}
