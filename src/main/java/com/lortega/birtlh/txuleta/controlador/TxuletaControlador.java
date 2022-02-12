package com.lortega.birtlh.txuleta.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lortega.birtlh.txuleta.repositorios.TxuletaRepositorio;

@Controller
public class TxuletaControlador {

	@Autowired
	private TxuletaRepositorio txuletaRepositorio;
	
	@GetMapping ("/txuletasAll")
	public String getTxuletas(Model modelo) {
		modelo.addAttribute("allTxuletas", txuletaRepositorio.findAll());
		return "txuleta/index";
	}
}
