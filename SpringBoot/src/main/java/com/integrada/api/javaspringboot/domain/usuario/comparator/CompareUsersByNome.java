package com.integrada.api.javaspringboot.domain.usuario.comparator;

import com.integrada.api.javaspringboot.domain.usuario.domain.Usuario;

public class CompareUsersByNome {
    public int compare(Usuario user1, Usuario user2) {
        return user1.getNome().compareTo(user2.getNome());
    }
}
