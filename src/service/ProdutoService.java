package service;

import java.util.Map;

import model.Cidade;
import model.Produto;
import repository.ProdutoRepository;

public class ProdutoService {

	ProdutoRepository produtoRepository;
	//Produto produto;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public Produto cadastrarProduto(String nome, String descricao, double preco, int quantidadedeEstoque, Cidade cidade,
			String vendedorId) {

		Produto produto = new Produto(vendedorId, descricao, preco, quantidadedeEstoque, cidade, vendedorId);
		produtoRepository.salvar(produto);
		return produto;
	}

	public Map<String, Produto> listarProdutos() {

		return produtoRepository.listarTodos();

	}

	public Produto buscarPorId(String id) {
		return produtoRepository.buscarPorId(id);
	}

	public Produto atualizarProduto(String id,String nome, String descricao, double preco, int quantidadedeEstoque, Cidade cidade,
			String vendedorId) {
		//aramazena o objeto do id
		Produto produto = produtoRepository.buscarPorId(id);
		
		if(produto != null) {
			return null;
		}
		
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(preco);
		produto.setQuantidadedeEstoque(quantidadedeEstoque);
		produto.setCidade(cidade);
		
		produtoRepository.salvar(produto);
		
		System.out.println("Produto atualizado");
		return produto;
		
	}
	
	public boolean removerProduto(String id) {
		if(produtoRepository.buscarPorId(id)!=null) {
			produtoRepository.removerProduto(id);
			return true;
		}
		return false;
		
	}

}
