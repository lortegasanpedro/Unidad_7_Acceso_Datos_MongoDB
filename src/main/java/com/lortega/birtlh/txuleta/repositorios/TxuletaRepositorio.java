package com.lortega.birtlh.txuleta.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lortega.birtlh.txuleta.modelo.Categoria;
import com.lortega.birtlh.txuleta.modelo.Txuleta;

public interface TxuletaRepositorio extends MongoRepository<Txuleta, String> {
	List<Txuleta> findByCategoria(Optional<Categoria> categoria);
}
