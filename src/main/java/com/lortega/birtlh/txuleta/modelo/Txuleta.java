package com.lortega.birtlh.txuleta.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document ("txuletas")
public class Txuleta  {


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	private Categoria categoria;
		
	private String descripcion;
	
	private String url;
	
	private String rutaCarpeta;
	
	private String aplicacion;
	
	private String maquina;
	
	private String usuario;
	
	private String nombre;
	
	private String apellidos;
	
	private String mail;
	
	private String clave;
	
	private Date fechaMod;

	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
