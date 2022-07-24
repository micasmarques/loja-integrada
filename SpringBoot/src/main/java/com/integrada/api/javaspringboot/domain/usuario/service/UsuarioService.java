package com.integrada.api.javaspringboot.domain.usuario.service;

import com.integrada.api.javaspringboot.domain.usuario.domain.Usuario;
import com.integrada.api.javaspringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String verificaLoginAndSenha(String usuario, String senha){
        Usuario obj = usuarioRepository.findByLoginAndSenha(usuario, senha);
        if (obj == null){
            return "Usuario e/ou senha invalida!";
        }
        return "Usuario "+ obj.getNome() + " logado com sucesso!";
    }

}
