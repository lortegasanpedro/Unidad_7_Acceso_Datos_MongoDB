package com.lortega.birtlh.txuleta.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lortega.birtlh.txuleta.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
	//Categoria findByCategoria(EnumCategorias enumCategorias);
	Categoria findByCategoriaDesc(String categoriaDesc);
}
