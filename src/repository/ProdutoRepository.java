package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.Cidade;
import model.Produto;
import model.Usuario;

//CONCERTAR
public class ProdutoRepository {

	Map<String, Produto> produtos;

	public ProdutoRepository() {
		this.produtos = new HashMap<>();
	}

	public Produto salvar(Produto produto) {
		produtos.put(produto.getId(), produto);
		return produto;
	}

	public Produto buscarPorId(String id) {
		return produtos.get(id);
	}

	public boolean removerProduto(String id) {
		return produtos.remove(id) != null;
	}

	public Map<String, Produto> listarTodos() {
		return produtos;
	}

	// retornar produtos cadastrados por um determiando vendedor
	public Map<String, Produto> listarPorVendedor(String vendedorId) {

		Map<String, Produto> produtosVendedor = new HashMap<>();

		for (Produto produto : produtos.values()) {
			if (produto.getVendedorId().equals(vendedorId)) {
				produtosVendedor.put(produto.getId(), produto);
			}
		}
		return produtosVendedor;
	}

	// listar produtos disponivel na cidade
	public Map<String, Produto> listarPorCidade(Cidade cidade) {

		Map<String, Produto> produtosCidade = new HashMap<>();
		for (Produto produto : produtos.values()) {
			if (produto.getCidade().equals(cidade)) {
				produtosCidade.put(produto.getId(), produto);
			}
		}
		return produtosCidade;
	}
}
