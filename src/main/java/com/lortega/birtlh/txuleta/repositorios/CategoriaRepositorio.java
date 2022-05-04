package com.lortega.birtlh.txuleta.repositorios;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lortega.birtlh.txuleta.modelo.Categoria;

public interface CategoriaRepositorio extends MongoRepository<Categoria, String> {
	//Categoria findByCategoria(EnumCategorias enumCategorias);
	List<Categoria> findByCategoriaDesc(String categoriaDesc);
}
