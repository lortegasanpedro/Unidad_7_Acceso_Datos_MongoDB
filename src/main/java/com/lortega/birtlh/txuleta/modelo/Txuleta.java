package com.lortega.birtlh.txuleta.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="txuleta")
public class Txuleta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1453454323426L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn (name="categoria_id")
	private Categoria categoria;
		
	@Column
	private String descripcion;
	
	@Column
	private String url;
	
	@Column
	private String rutaCarpeta;
	
	@Column
	private String aplicacion;
	
	@Column
	private String maquina;
	
	@Column
	private String usuario;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String mail;
	
	@Column
	private String clave;
	
	@Column
	private Date fechaMod;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRutaCarpeta() {
		return rutaCarpeta;
	}

	public void setRutaCarpeta(String rutaCarpeta) {
		this.rutaCarpeta = rutaCarpeta;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaMod() {
		return fechaMod;
	}

	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
