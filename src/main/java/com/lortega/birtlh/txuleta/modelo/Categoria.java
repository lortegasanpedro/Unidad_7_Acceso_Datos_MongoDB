package com.lortega.birtlh.txuleta.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 145345345345L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategoria;
	
	@JsonBackReference
	@OneToMany
	@JoinColumn (name="txuleta_id")
	List<Txuleta> txuletas = new ArrayList<>();
	
	//@Enumerated(EnumType.STRING)
	//private EnumCategorias categoria;
	
	@Column
	private String categoriaDesc;
	
	@Column
	private String descripcion;
	
	@Column
	private Date fechaMod;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public List<Txuleta> getTxuletas() {
		return txuletas;
	}

	public void setTxuletas(List<Txuleta> txuletas) {
		this.txuletas = txuletas;
	}
/*
	public EnumCategorias getCategoria() {
		return categoria;
	}

	public void setCategoria(EnumCategorias categoria) {
		this.categoria = categoria;
	}
*/
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public String getCategoriaDesc() {
		return categoriaDesc;
	}

	public void setCategoriaDesc(String categoriaDesc) {
		this.categoriaDesc = categoriaDesc;
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
