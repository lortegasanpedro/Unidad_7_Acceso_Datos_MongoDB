package com.lortega.birtlh.txuleta.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lortega.birtlh.txuleta.modelo.Categoria;
import com.lortega.birtlh.txuleta.modelo.EnumCategorias;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
	Categoria findByCategoria(EnumCategorias enumCategorias);
}
