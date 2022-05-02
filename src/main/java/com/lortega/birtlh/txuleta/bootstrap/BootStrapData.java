package com.lortega.birtlh.txuleta.bootstrap;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lortega.birtlh.txuleta.modelo.Categoria;
import com.lortega.birtlh.txuleta.modelo.Txuleta;
import com.lortega.birtlh.txuleta.repositorios.CategoriaRepositorio;
import com.lortega.birtlh.txuleta.repositorios.TxuletaRepositorio;

@Component 
public class BootStrapData implements CommandLineRunner {

	private static Logger log = LoggerFactory
		      .getLogger(BootStrapData.class);
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private TxuletaRepositorio txuletaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("START Txuleta");
		this.createCategorias();
		this.createTxuletas();
/*		Categoria categoria = new Categoria();
		categoria.setCategoria(EnumCategorias.URLS);
		categoria.setDescripcion("URLs");
		categoria.setFechaMod(new Date());
		
		Txuleta txuleta = new Txuleta();
		txuleta.setUrl("http://www.radarkapildui.com");
		txuleta.setDescripcion("URL Radar Kapildui.com");
		txuleta.setFechaMod(new Date());
		
		txuleta.setCategoria(categoria);
		categoria.getTxuletas().add(txuleta);
		
		categoriaRepositorio.save(categoria);
		txuletaRepositorio.save(txuleta);
	*/	
		//this.createCategorias();
		log.info("END Txuleta");
	}
	
	@Transactional
	private void createCategorias() throws Exception {
		Categoria categoriaURLs = new Categoria();
		categoriaURLs.setCategoriaDesc("URLS");
		categoriaURLs.setDescripcion("URLs");
		categoriaURLs.setFechaMod(new Date());

		Categoria categoriaServiciosSOA = new Categoria();
		categoriaServiciosSOA.setCategoriaDesc("SERVICIOS_SOA");
		categoriaServiciosSOA.setDescripcion("Servicios SOA");
		categoriaServiciosSOA.setFechaMod(new Date());

		Categoria categoriaRutasCarpetas = new Categoria();
		categoriaRutasCarpetas.setCategoriaDesc("RUTAS_CARPETAS");
		categoriaRutasCarpetas.setDescripcion("Rutas carpetas");
		categoriaRutasCarpetas.setFechaMod(new Date());
		
		Categoria categoriaUsuarios = new Categoria();
		categoriaUsuarios.setCategoriaDesc("USUARIOS");
		categoriaUsuarios.setDescripcion("Usuarios");
		categoriaUsuarios.setFechaMod(new Date());

		Categoria categoriaBasesDatos = new Categoria();
		categoriaBasesDatos.setCategoriaDesc("BASES_DATOS");
		categoriaBasesDatos.setDescripcion("Bases datos");
		categoriaBasesDatos.setFechaMod(new Date());

		categoriaRepositorio.save(categoriaURLs);
		categoriaRepositorio.save(categoriaServiciosSOA);
		categoriaRepositorio.save(categoriaRutasCarpetas);
	}
	
	@Transactional
	private void createTxuletas() throws Exception {
		Txuleta txuleta = new Txuleta();
		txuleta.setUrl("http://www.radarkapildui.com");
		txuleta.setDescripcion("URL Radar Meteorológico de Euskalmet Kapildui.com");
		txuleta.setFechaMod(new Date());
	
		//EnumCategorias enumCategorias = EnumCategorias.URLS.ordinal()
		Categoria categoria = categoriaRepositorio.findByCategoriaDesc("URLS");
		txuleta.setCategoria(categoria);
		txuletaRepositorio.save(txuleta);

	
	}
}
