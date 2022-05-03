package com.lortega.birtlh.txuleta.modelo;

import java.util.Date;


public class Categoria  {
	
	private String categoriaDesc;
	
	private String descripcion;
	
	private Date fechaMod;

		
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
