package com.integrada.api.javaspringboot.repository;

import com.integrada.api.javaspringboot.domain.carrinho.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
}
