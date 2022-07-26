package com.integrada.api.javaspringboot.repository;

import com.integrada.api.javaspringboot.domain.produto.domain.Produto;
import com.integrada.api.javaspringboot.domain.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}