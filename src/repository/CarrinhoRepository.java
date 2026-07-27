package repository;

import java.util.HashMap;

import model.Produto;

public class CarrinhoRepository {
	
	private HashMap<String,Produto>produtos;
	
	public CarrinhoRepository() {
		this.produtos = new HashMap<>();
	}

	public void adiciona(String id,Produto produto) {
		
		produtos.put(id, produto);
		
	}
	
	public void imprimirCarrinho() {
		
	}

}
