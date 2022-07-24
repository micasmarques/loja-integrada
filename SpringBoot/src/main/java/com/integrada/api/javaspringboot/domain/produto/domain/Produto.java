package com.integrada.api.javaspringboot.domain.produto.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "NOME", nullable = false)
    @Getter
    @Setter
    private String nome;

    @Column(name = "PREÇO", nullable = false)
    @Getter
    @Setter
    private Double preco;

    @Column(name = "ESTOQUE", nullable = false)
    @Getter
    @Setter
    private Integer estoque;

    @Column(name = "IS_ACTIVE", nullable = false)
    @Getter
    @Setter
    private Boolean isActive;

}
