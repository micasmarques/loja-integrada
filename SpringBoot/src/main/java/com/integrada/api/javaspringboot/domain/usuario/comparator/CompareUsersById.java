package com.integrada.api.javaspringboot.domain.usuario.comparator;

import com.integrada.api.javaspringboot.domain.usuario.domain.Usuario;

public class CompareUsersById {
    public int compare(Usuario user1, Usuario user2) {
        return user1.getId().compareTo(user2.getId());
    }
}
