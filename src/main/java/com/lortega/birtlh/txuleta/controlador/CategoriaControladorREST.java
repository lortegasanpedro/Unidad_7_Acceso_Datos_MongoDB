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

import com.lortega.birtlh.txuleta.modelo.Categoria;
import com.lortega.birtlh.txuleta.repositorios.CategoriaRepositorio;

@RestController
@RequestMapping("api/categorias")
public class CategoriaControladorREST {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
		
	@GetMapping ({"/",""})
	public List<Categoria> getCategoriasAll() {
		return categoriaRepositorio.findAll();	
	}
	
	@GetMapping ("/{id}")
	public Categoria getById(@PathVariable("id") String id) {
		return  categoriaRepositorio.findById(id).orElse(null);
	}
	
	@PutMapping ("/")
	@ResponseStatus (HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria categoria) {
		categoria.setFechaMod(new Date());
		return categoriaRepositorio.save(categoria);
	}
	
	@PutMapping ("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Categoria update(@RequestBody Categoria categoria, @PathVariable("id") String id) {
		Categoria categoriaTmp = categoriaRepositorio.findById(id).orElse(null);
		categoriaTmp.setCategoriaDesc(categoria.getCategoriaDesc());
		categoriaTmp.setDescripcion(categoria.getDescripcion());
		Date dateTime = new Date();
		categoriaTmp.setFechaMod(dateTime);
		return categoriaRepositorio.save(categoriaTmp);
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		categoriaRepositorio.deleteById(id);
	}
	
}


