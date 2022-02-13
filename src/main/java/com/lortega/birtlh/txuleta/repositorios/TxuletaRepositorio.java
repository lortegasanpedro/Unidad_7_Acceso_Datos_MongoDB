package com.lortega.birtlh.txuleta.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lortega.birtlh.txuleta.modelo.Categoria;
import com.lortega.birtlh.txuleta.modelo.Txuleta;

public interface TxuletaRepositorio extends JpaRepository<Txuleta, Integer> {
	List<Txuleta> findByCategoria(Optional<Categoria> categoria);
}
