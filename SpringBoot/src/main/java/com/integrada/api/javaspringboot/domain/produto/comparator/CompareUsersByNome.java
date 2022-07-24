package com.integrada.api.javaspringboot.domain.produto.comparator;

import com.integrada.api.javaspringboot.domain.produto.domain.Produto;

import java.util.Comparator;

public class CompareUsersByNome implements Comparator<Produto> {
    public int compare(Produto user1, Produto user2) {
        return user1.getNome().compareTo(user2.getNome());
    }
}
