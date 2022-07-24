package com.integrada.api.javaspringboot.domain.produto.comparator;

import com.integrada.api.javaspringboot.domain.produto.domain.Produto;

import java.util.Comparator;

public class CompareUsersById implements Comparator<Produto> {
    public int compare(Produto p1, Produto p2) {
        return p1.getId().compareTo(p2.getId());
    }
}
