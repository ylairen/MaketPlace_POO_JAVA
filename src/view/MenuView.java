package view;

import java.util.Scanner;

import controller.ProdutoController;
import model.Cidade;
import model.Cliente;
import model.Produto;
import model.Vendedor;
import repository.ProdutoRepository;
import service.ProdutoService;

public class MenuView {
//aqui tem o menu com as opções de comprar atualizar etc..
//dois menus para cada usuario

	ProdutoRepository produtoRepository = new ProdutoRepository();
	ProdutoService produtoService = new ProdutoService(produtoRepository);
	ProdutoController produtoController = new ProdutoController(produtoService);
	ProdutoView produtoView = new ProdutoView();
	Produto produto;

	Scanner sc = new Scanner(System.in);
	int opcao;

	public void menuVendedor(Vendedor vendedor) {

		do {

			System.out.println("+================ MENU ================+");
			System.out.println("");
			System.out.println("        1-CADASTRAR PRODUTO");
			System.out.println("        2-PROCURAR PRODUTO");
			System.out.println("        3-LISTAR MEUS PRODUTOS");
			System.out.println("        4-ATUALIZAR PRODUTO");
			System.out.println("        5-REMOVER PRODUTO");
			System.out.println("        6-LISTAR MINHAS VENDAS");
			System.out.println("        7-BUSCAR PEDIDO");
			System.out.println("        8-ATUALIZAR STATUS DO PEDIDO");
			System.out.println("        9-MEU PERFIL");
			System.out.println("        0-LOGOUT");
			System.out.println("");
			System.out.println("+=======================================+");

			System.out.print("->");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				sc.nextLine();

				System.out.print("Nome do produto:");
				String nome = sc.nextLine();

				System.out.print("Descrição do produto:");
				String descricao = sc.nextLine();

				System.out.print("Preço do produto:");
				double preço = sc.nextDouble();

				System.out.print("Quantidade em estoque:");
				int quantidadeEstoque = sc.nextInt();

				System.out.println("+========== CIDADE ==========+");
				System.out.println("");
				System.out.println("1-BARBALHA");
				System.out.println("2-JUAZEIRO DO NORTE");
				System.out.println("3-CRATO");
				System.out.println("0-LOGOUT");
				System.out.println("+===========================+");

				int opcaoCidade = sc.nextInt();

				switch (opcaoCidade) {
				case 1:

					produto = produtoController.cadastrarProduto(nome, descricao, preço, quantidadeEstoque,
							Cidade.BARBALHA, vendedor.getId());

					break;
				case 2:

					produto = produtoController.cadastrarProduto(nome, descricao, preço, quantidadeEstoque,
							Cidade.JUAZEIRO_DO_NORTE, vendedor.getId());

					break;
				case 3:

					produto = produtoController.cadastrarProduto(nome, descricao, preço, quantidadeEstoque,
							Cidade.CRATO, vendedor.getId());

					break;
				}

				break;

			case 2:

				sc.nextLine();

				System.out.print("ID do produto:");
				String id = sc.nextLine();

				if (produtoController.buscarProdutoPorId(id) == null) {
					System.out.println("Produto não encontrado");
					break;
				}

				System.out.println("ID:"+produto.getId());
				System.out.println("NOME:"+produto.getNome());
				System.out.println("QUANTIDADE NO ESTOQUE:"+produto.getQuantidadedeEstoque());
				System.out.println("PREÇO:"+produto.getPreco());
				System.out.println("CIDADE:"+produto.getCidade());

				break;

			case 3:

				for(Produto produto:produtoController.listarProdutos().values()) {
					System.out.println(produto);
				}

				break;
			case 4:

				sc.nextLine();

				System.out.println("Qual produto deseja atualizar,informe o ID:");
				String produtoId = sc.nextLine();

				produto = produtoController.buscarProdutoPorId(produtoId);

				if (produto == null) {
					break;
				}

				System.out.println("Nome do produto:");
				String nomeProduto = sc.nextLine();

				System.out.println("Descrição do produto:");
				String descricaoProduto = sc.nextLine();

				System.out.println("Preço do produto:");
				double precoProduto = sc.nextDouble();

				System.out.println("Quantidade do produto em estoque:");
				int quantidadeDeEstoqueProduto = sc.nextInt();

				System.out.println("+========== CIDADE ==========+");
				System.out.println("");
				System.out.println("1-BARBALHA");
				System.out.println("2-JUAZEIRO DO NORTE");
				System.out.println("3-CRATO");
				System.out.println("0-LOGOUT");
				System.out.println("+===========================+");

				int opCidadeProduto = sc.nextInt();

				switch (opCidadeProduto) {
				case 1:

					produto = produtoController.atualizarProduto(produto.getId(), nomeProduto, descricaoProduto,
							precoProduto, quantidadeDeEstoqueProduto, Cidade.BARBALHA, vendedor.getId());
					break;
				case 2:

					produto = produtoController.atualizarProduto(produto.getId(), nomeProduto, descricaoProduto,
							precoProduto, quantidadeDeEstoqueProduto, Cidade.JUAZEIRO_DO_NORTE, vendedor.getId());

					break;
				case 3:

					produto = produtoController.atualizarProduto(produto.getId(), nomeProduto, descricaoProduto,
							precoProduto, quantidadeDeEstoqueProduto, Cidade.CRATO, vendedor.getId());

					break;
				}

				break;

			case 5:
				sc.nextLine();
				System.out.println("Digite o ID do produto que deseja remover:");
				String produtoIdRemover = sc.nextLine();

				if (produto == null) {
					break;
				}

				produtoController.removerProduto(produtoIdRemover);
				System.out.println("Produto removido");

				break;
			case 6:
				// precisa do cliente
				break;
			case 7:
				// precisa do cliente
				break;
			case 8:
				// precisa do cliente
				break;
			case 9:

				System.out.println("========== PERFIL ==========");
				System.out.println("NOME:" + vendedor.getNome());
				System.out.println("EMAIL:" + vendedor.getEmail());
				System.out.println("ID:" + vendedor.getId());
				System.out.println("DATA DE CADASTRO:" + vendedor.getDataCadastro());
				System.out.println("============================");

				break;
			}
		} while (opcao != 0);
	}

	public void menuCliente(Cliente cliente) {
		do {
			
			//opção de pesquisar por cidade
			System.out.println("+================ MENU ================+");
			System.out.println("        1-PESQUISAR PRODUTO");
			System.out.println("        2-CARRINHO DE COMPRAS");
			System.out.println("        3-LISTAR PEDIDOS");
			System.out.println("        4-HISTORICO DE COMPRAS");
			System.out.println("        5-COMPRAR PRODUTO");
			System.out.println("        6-PERFIL");
			System.out.println("        0-LOGOUT");
			System.out.println("+=======================================+");

			System.out.print("->");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o nome do produto:");
				String nomeProduto = sc.nextLine();
				
				if(produto==null) {
					break;
				}
				
				produtoController.buscarProdutoPorNome(nomeProduto);
				produtoView.produtoInformacoes(produto);
				
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			}

		} while (opcao != 0);
	}
}
