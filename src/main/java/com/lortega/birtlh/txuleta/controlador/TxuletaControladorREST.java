package com.lortega.birtlh.txuleta.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lortega.birtlh.txuleta.modelo.Txuleta;
import com.lortega.birtlh.txuleta.repositorios.CategoriaRepositorio;
import com.lortega.birtlh.txuleta.repositorios.TxuletaRepositorio;

@RestController
@RequestMapping("api/txuletas")
public class TxuletaControladorREST {

	@Autowired
	private TxuletaRepositorio txuletaRepositorio;
	
	@GetMapping ({"/",""})
	public List<Txuleta> getTxuletasAll() {
		return txuletaRepositorio.findAll();	
	}
		
	@GetMapping ("/{id}")
	public Txuleta getById(@PathVariable("id") Integer id) {
		return  txuletaRepositorio.findById(id).orElse(null);
	}

	@PutMapping ("/")
	@ResponseStatus (HttpStatus.CREATED)
	public Txuleta create(@RequestBody Txuleta txuleta) {
		txuleta.setFechaMod(new Date());
		return txuletaRepositorio.save(txuleta);
	}
	
	@PutMapping ("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Txuleta update(@RequestBody Txuleta txuleta, @PathVariable("id") Integer id) {
		Txuleta txuletaTmp = txuletaRepositorio.findById(id).orElse(null);
		//if (categoria!=null) {
			txuletaTmp.setApellidos(txuleta.getApellidos());
			txuletaTmp.setAplicacion(txuleta.getAplicacion());
			txuletaTmp.setCategoria(txuleta.getCategoria());
			txuletaTmp.setClave(txuleta.getClave());
			txuletaTmp.setDescripcion(txuleta.getDescripcion());
			txuletaTmp.setFechaMod(new Date());
			txuletaTmp.setMail(txuleta.getMail());
			txuletaTmp.setMaquina(txuleta.getMaquina());
			txuletaTmp.setNombre(txuleta.getNombre());
			txuletaTmp.setRutaCarpeta(txuleta.getRutaCarpeta());
			txuletaTmp.setUrl(txuleta.getUrl());
			txuletaTmp.setUsuario(txuleta.getUsuario());
			return txuletaRepositorio.save(txuletaTmp);
		//} else {
			//return "{
		//}
	}
	
	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		txuletaRepositorio.deleteById(id);
	}

}
