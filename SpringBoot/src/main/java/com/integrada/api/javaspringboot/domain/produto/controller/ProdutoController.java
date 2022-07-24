package com.integrada.api.javaspringboot.domain.produto.controller;

import com.integrada.api.javaspringboot.domain.produto.comparator.CompareUsersById;
import com.integrada.api.javaspringboot.domain.produto.comparator.CompareUsersByNome;
import com.integrada.api.javaspringboot.domain.produto.domain.Produto;
import com.integrada.api.javaspringboot.domain.response_delete.ResponseDell;
import com.integrada.api.javaspringboot.domain.usuario.domain.Usuario;
import com.integrada.api.javaspringboot.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController extends Produto{
    private final ProdutoRepository acoes;

    public ProdutoController(ProdutoRepository acoes) {
        this.acoes = acoes;
    }

    //     Listar Produtos
    @GetMapping(value = "/produto")
    public List<Produto> listar() {
        return acoes.findAll();
    }

//    cadastrar produtos
    @PostMapping(value = "/produto")
    public @ResponseBody Produto cadastrar(@RequestBody Produto produto){
        return acoes.save(produto);
    }

    //filtrar produtos
    @GetMapping(value = "/produto/{codigo}")
    public Produto filtrar(@PathVariable Integer codigo) {
        return acoes.findById(codigo)
                .orElseThrow(()->new RuntimeException("Produto não encontrado"));
    }

    //alterar produtos
    @PutMapping(value = "/produto")
    public Produto alterar(@RequestBody Produto p) {
        return acoes.save(p);
    }

    //deletar produtos
    @DeleteMapping(value = "/produto/{codigo}")
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo) {
        ResponseDell response = new ResponseDell();
        try {
            Produto p = filtrar(codigo);
            acoes.delete(p);
            response.setMensage("Usuario removido com sucesso");
        } catch (Exception erro) {
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/produto/order/{codigo}")
    public @ResponseBody List<Produto> filterBy(@PathVariable String codigo) {
        List<Produto> lista = this.listar();
        switch (codigo) {
            case "id":
                lista.sort(new CompareUsersById());
                return lista;
            case "nome":
                lista.sort(new CompareUsersByNome());
                return lista;
            default:
                return lista;
        }
    }
}
