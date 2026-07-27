package view;

import model.Produto;

public class ProdutoView {

		public void produtoInformacoes(Produto produto) {
			
			System.out.println("ID:"+produto.getId());
			System.out.println("NOME:"+produto.getNome());
			System.out.println("QUANTIDADE NO ESTOQUE:"+produto.getQuantidadedeEstoque());
			System.out.println("PREÇO:R$"+produto.getPreco());
			System.out.println("CIDADE:"+produto.getCidade());
			
		}

	}

