package com.integrada.api.javaspringboot.domain.usuario.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Usuarios")
public class Usuario {
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

    @Column(name = "LOGIN", nullable = false)
    @Getter
    @Setter
    private String login;

    @Column(name = "SENHA", nullable = false)
    @Getter
    @Setter
    private String senha;

}
