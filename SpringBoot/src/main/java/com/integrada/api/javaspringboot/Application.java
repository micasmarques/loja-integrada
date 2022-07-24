package com.integrada.api.javaspringboot;

import com.integrada.api.javaspringboot.domain.carrinho.domain.Carrinho;
import com.integrada.api.javaspringboot.domain.produto.domain.Produto;
import com.integrada.api.javaspringboot.domain.usuario.domain.Usuario;
import com.integrada.api.javaspringboot.repository.CarrinhoRepository;
import com.integrada.api.javaspringboot.repository.ProdutoRepository;
import com.integrada.api.javaspringboot.repository.RunApplication;
import com.integrada.api.javaspringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements RunApplication {
	@Autowired
	private final ProdutoRepository produtoRepository;
	@Autowired
	private final UsuarioRepository usuarioRepository;
	@Autowired
	private final CarrinhoRepository carrinhoRepository;

	public Application(ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository, CarrinhoRepository carrinhoRepository) {
		this.produtoRepository = produtoRepository;
		this.usuarioRepository = usuarioRepository;
		this.carrinhoRepository = carrinhoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		Usuario user1 = new Usuario(null, "Maria Silva", "maria@gmail.com", "maria");
		Usuario user2 = new Usuario(null, "Gustavo Silva", "gustavo@gmail.com", "gustavo");

		List<Produto> listaDeProdutos = new ArrayList<>();

		Produto p1 = new Produto(null, "Computador", 2000.00, 10, true);
		Produto p2 = new Produto(null, "Impressora", 800.00, 10, true);
		Produto p3 = new Produto(null, "Mouse", 80.00, 10, true);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		listaDeProdutos.add(p1);
		listaDeProdutos.add(p2);
		listaDeProdutos.add(p3);

		usuarioRepository.saveAll(Arrays.asList(user1, user2));

		Carrinho carrinho1 = new Carrinho(null, user1.getId(), listaDeProdutos, p1.getPreco()+p2.getPreco()+p3.getPreco());
		Carrinho carrinho2 = new Carrinho(null, user2.getId(), listaDeProdutos, p1.getPreco()+p2.getPreco()+p3.getPreco());


		carrinhoRepository.saveAll(Arrays.asList(carrinho1, carrinho2));
	}
}
