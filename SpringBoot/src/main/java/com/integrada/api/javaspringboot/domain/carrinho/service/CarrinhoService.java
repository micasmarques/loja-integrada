package com.integrada.api.javaspringboot.domain.carrinho.service;

import com.integrada.api.javaspringboot.domain.produto.domain.Produto;
import com.integrada.api.javaspringboot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CarrinhoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    private final Map<Produto, Integer> produtos = new HashMap<>();

    public void adicionar(Produto p) {
        if (produtos.containsKey(p)) {
            produtos.replace(p, produtos.get(p) + 1);
        } else {
            produtos.put(p, 1);
        }
    }

    public void remover(Produto p) {
        if (produtos.containsKey(p)) {
            if (produtos.get(p) > 1)
                produtos.replace(p, produtos.get(p) - 1);
            else if (produtos.get(p) == 1) {
                produtos.remove(p);
            }
        }
    }

}
