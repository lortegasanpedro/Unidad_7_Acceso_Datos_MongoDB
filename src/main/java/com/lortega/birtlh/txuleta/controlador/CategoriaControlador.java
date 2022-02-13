package com.lortega.birtlh.txuleta.controlador;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lortega.birtlh.txuleta.modelo.Categoria;
import com.lortega.birtlh.txuleta.modelo.Txuleta;
import com.lortega.birtlh.txuleta.repositorios.CategoriaRepositorio;
import com.lortega.birtlh.txuleta.repositorios.TxuletaRepositorio;

@Controller
public class CategoriaControlador {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private TxuletaRepositorio txuletaRepositorio;
	
	@GetMapping ("/categoriasAll")
	public String getCategoriasAll(Model modelo) {
		modelo.addAttribute("allCategorias", categoriaRepositorio.findAll());
		modelo.addAttribute("opcionMenu","C");
		return "txuleta/categoria";
	}
	

	@GetMapping ("/categoriaNew")
	public String initNuevaCategoria(Model modelo) {
		Categoria categoria= new Categoria();
		modelo.addAttribute("categoria", categoria);
		modelo.addAttribute("opcionMenu","");
		return "txuleta/categoriaForm";
	}
	
	@GetMapping ("/categoriaEdit/{id}")
	public String initEditarCategoria(@PathVariable("id") int id, Model modelo) {
		Optional<Categoria> categoria = categoriaRepositorio.findById(id);
		modelo.addAttribute("categoria", categoria);
		modelo.addAttribute("opcionMenu","");
		return "txuleta/categoriaForm";
	}

	
	@GetMapping ("/categoriaDelete/{id}")
	public String initDeleteCategoria(@PathVariable("id") int id, Model modelo) {
		Optional<Categoria> categoria = categoriaRepositorio.findById(id);
		List<Txuleta> listaTxuletas = txuletaRepositorio.findByCategoria(categoria);
		txuletaRepositorio.deleteAll(listaTxuletas);
		categoriaRepositorio.deleteById(id);
		return "redirect:/categoriasAll";
	}
	
	@PostMapping ("categoria/new/submit")
	public String addNuevaCategoria(@ModelAttribute Categoria categoria) {
		categoria.setFechaMod(new Date());
		categoriaRepositorio.save(categoria);
		return "redirect:/categoriasAll";
	}
		
	
}


