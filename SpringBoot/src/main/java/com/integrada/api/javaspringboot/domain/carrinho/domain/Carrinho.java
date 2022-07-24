package com.integrada.api.javaspringboot.domain.carrinho.domain;

import com.integrada.api.javaspringboot.domain.produto.domain.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "PRODUTOS")
    @Getter
    @Setter
    @ManyToMany
    @ElementCollection
    private List<Produto> produtos;

    @Column(name = "PRECO_TOTAL")
    @Getter
    @Setter
    private Double precoTotal;

    @Column(name = "ID_USER")
    @Getter
    @Setter
    private Integer idUsuario;

    public Carrinho(Integer id, Integer idUsuario, List<Produto> produtos, Double precoTotal) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.produtos = produtos;
        this.precoTotal = precoTotal;
    }
}
