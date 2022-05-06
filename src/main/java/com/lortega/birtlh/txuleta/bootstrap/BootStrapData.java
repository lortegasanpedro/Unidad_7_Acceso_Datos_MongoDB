package com.lortega.birtlh.txuleta.bootstrap;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lortega.birtlh.txuleta.modelo.Categoria;
import com.lortega.birtlh.txuleta.modelo.Txuleta;
import com.lortega.birtlh.txuleta.repositorios.TxuletaRepositorio;

@Component 
public class BootStrapData implements CommandLineRunner {

	private static Logger log = LoggerFactory
		      .getLogger(BootStrapData.class);
		
	@Autowired
	private TxuletaRepositorio txuletaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("START Txuleta");
		this.createTxuletas();
		log.info("END Txuleta");
	}
	
	private void createTxuletas() throws Exception {
		Txuleta txuleta = new Txuleta();
		txuleta.setUrl("http://www.radarkapildui.com");
		txuleta.setDescripcion("URL Radar Meteorológico de Euskalmet Kapildui.com");
		
		Categoria categoria = new Categoria();
		categoria.setCategoriaDesc("URL");
		categoria.setDescripcion("urls");
		txuleta.setCategoria(categoria);
		txuleta.setFechaMod(new Date());
		txuletaRepositorio.save(txuleta);


		Txuleta txuleta2 = new Txuleta();
		txuleta2.setMail("comunicaciones@comunicaciones.com");
		txuleta2.setDescripcion("Comunicaciones");
		
		Categoria categoria2 = new Categoria();
		categoria2.setCategoriaDesc("MAIL");
		categoria2.setDescripcion("mails");
		txuleta2.setCategoria(categoria2);
		txuleta2.setFechaMod(new Date());
		txuletaRepositorio.save(txuleta2);

		Txuleta txuleta3 = new Txuleta();
		txuleta3.setMail("servidores@servidores.com");
		txuleta3.setDescripcion("Servidores");
		
		txuleta3.setCategoria(categoria2);
		txuleta3.setFechaMod(new Date());
		txuletaRepositorio.save(txuleta3);

		Txuleta txuleta4 = new Txuleta();
		txuleta4.setRutaCarpeta("\\\\maquina1\\datos\\gestion\\personal");
		txuleta4.setDescripcion("Ruta a carpeta gestión personal");
		
		Categoria categoria3 = new Categoria();
		categoria3.setCategoriaDesc("RUTAS_CARPETA");
		categoria3.setDescripcion("rutas a carpetas");
		txuleta4.setCategoria(categoria3);
		txuleta4.setFechaMod(new Date());
		txuletaRepositorio.save(txuleta4);

		
	}
}
