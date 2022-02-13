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
public class TxuletaControlador {

	@Autowired
	private TxuletaRepositorio txuletaRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	
	@GetMapping ("/txuletasAll")
	public String getTxuletas(Model modelo) {
		modelo.addAttribute("allTxuletas", txuletaRepositorio.findAll());
		modelo.addAttribute("opcionMenu","T");
		return "txuleta/txuleta";
	}
	

	@GetMapping ("/txuletaDelete/{id}")
	public String deleteTxuleta(@PathVariable("id") int id, Model modelo) {
		txuletaRepositorio.deleteById(id);
		return "redirect:/txuletasAll";
	}

	
	@GetMapping ("/txuletaEditURL/{id}")
	public String initEditarTxuletaURL(@PathVariable("id") int id, Model modelo) {
		Optional<Txuleta> txuleta = txuletaRepositorio.findById(id);
		modelo.addAttribute("txuleta", txuleta);
		modelo.addAttribute("opcionMenu","");
		return "txuleta/txuletaFormURL";
	}
	
	@GetMapping ("/txuletaNewURL")
	public String initNuevaTxuletaURL(Model modelo) {
		Txuleta txuleta = new Txuleta();
		modelo.addAttribute("txuleta", txuleta);		
		modelo.addAttribute("opcionMenu","");
		return "txuleta/txuletaFormURL";
	}

	@GetMapping ("/txuletaNewCarpeta")
	public String initNuevaTxuletaCarpeta(Model modelo) {
		Txuleta txuleta = new Txuleta();
		List<Categoria> listCategorias = categoriaRepositorio.findAll();
		modelo.addAttribute("txuleta", txuleta);
		modelo.addAttribute("allCategorias", listCategorias);
		modelo.addAttribute("opcionMenu","");
		return "txuleta/txuletaFormCarpeta";
	}
	

	@PostMapping ("txuleta/new/submit")
	public String addNuevaTxueletaURL(@ModelAttribute Txuleta txuleta, @ModelAttribute Categoria categoria) {
		txuleta.setFechaMod(new Date());
		//categoriaRepositorio.findByCategoria(EnumCategorias.RUTAS_CARPETAS);
		String cate = categoria.getCategoriaDesc();
		txuleta.setCategoria(categoriaRepositorio.findByCategoriaDesc("SERVICIOS_SOA"));
		//txuleta.setCategoria(categoria);
		txuletaRepositorio.save(txuleta);
		return "redirect:/txuletasAll";
	}
}
