package com.integrada.api.javaspringboot.domain.carrinho.controller;


import com.integrada.api.javaspringboot.domain.carrinho.domain.Carrinho;
import com.integrada.api.javaspringboot.domain.carrinho.service.CarrinhoService;
import com.integrada.api.javaspringboot.domain.response_delete.ResponseDell;
import com.integrada.api.javaspringboot.repository.CarrinhoRepository;
import com.integrada.api.javaspringboot.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;
    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoRepository acoes, ProdutoRepository produtoRepository, CarrinhoService carrinhoService) {
        this.carrinhoRepository = acoes;
        this.produtoRepository = produtoRepository;
        this.carrinhoService = carrinhoService;
    }

    // Listar Carrinho
    @GetMapping(value = "/carrinho")
    public @ResponseBody
    List<Carrinho> listar(){
        return carrinhoRepository.findAll();
    }

    //cadastrar Carrinho
    @PostMapping(value = "/carrinho")
    public @ResponseBody Carrinho cadastrar(@RequestBody Carrinho carrinho){
        return carrinhoRepository.save(carrinho);
    }

    //filtrar carrinho
    @GetMapping(value = "/carrinho/{codigo}")
    public @ResponseBody Carrinho filtrar(@PathVariable Integer codigo){
        return carrinhoRepository.findById(codigo).
                orElseThrow(()->new RuntimeException("Carrinho de compras não encontrado"));
    }

    //alterar carrinho
    @PutMapping(value = "/carrinho")
    public @ResponseBody Carrinho alterar(@RequestBody Carrinho carrinho){
        return carrinhoRepository.save(carrinho);
    }

    @GetMapping("/carrinho/adicionar/{codigo}")
	public void adicionar(@PathVariable("codigo") Integer codigo) {
		produtoRepository.findById(codigo).ifPresent(carrinhoService::adicionar);
	}

	@GetMapping("/carrinho/remover/{codigo}")
	public void remover(@PathVariable("codigo") Integer codigo) {
        produtoRepository.findById(codigo).ifPresent(carrinhoService::remover);
	}

    //deletar carrinho
    @DeleteMapping(value = "/carrinho/{codigo}")
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo){
        ResponseDell response = new ResponseDell();
        try{
            Carrinho carrinho = filtrar(codigo);
            carrinhoRepository.delete(carrinho);
            response.setMensage("Carrinho removido com sucesso");
        } catch (Exception erro){
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }

}
