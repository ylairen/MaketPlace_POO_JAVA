package controller;

import java.util.Map;

import model.Cidade;
import model.Produto;
import service.ProdutoService;

public class ProdutoController {
	
	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	public Produto cadastrarProduto(String nome, String descricao, double preco, int quantidadedeEstoque, Cidade cidade,
			String vendedorId) {
		return produtoService.cadastrarProduto(nome, descricao, preco, quantidadedeEstoque, cidade, vendedorId);
	}
	
	public Produto buscarProdutoPorNome(String nomeProduto) {
		return produtoService.buscarPorNome(nomeProduto);
	}
	
	public Produto buscarProdutoPorId(String id) {
		return produtoService.buscarPorId(id);
	}
	
	public Map<String, Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}
	
	public Produto atualizarProduto(String id,String nome, String descricao, double preco, int quantidadedeEstoque, Cidade cidade,
			String vendedorId) {
		return produtoService.atualizarProduto(id, nome, descricao, preco, quantidadedeEstoque, cidade, vendedorId);
		
	}
	
	public void removerProduto(String id) {
		produtoService.removerProduto(id);
		
	}
	
	public void listarVendasVendedor(String vendedorId) {
		
	}
	
	public void buscarPedido(String id) {
		produtoService.buscarPorId(id);
	}
	
	public void atualizarStatusPedido() {
	}
	
	public void perfilVendedor() {
		
	}
	
}
