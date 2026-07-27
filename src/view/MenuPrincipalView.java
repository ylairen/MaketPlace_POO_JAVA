package view;

import java.util.Scanner;

import controller.UsuarioController;
import model.Usuario;
import model.Vendedor;
import repository.PedidoRepository;
import repository.ProdutoRepository;
import repository.UsuarioRepository;
import service.UsuarioService;
import service.ValidacaoService;
import model.Cliente;
import model.Produto;
import model.TipoUsuario;

public class MenuPrincipalView {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UsuarioRepository usuarioRepository = new UsuarioRepository();
		UsuarioService usuarioService = new UsuarioService(usuarioRepository);
		UsuarioController usuarioController = new UsuarioController(usuarioService);
		ProdutoRepository produtoRepoditory = new ProdutoRepository();
		PedidoRepository pedidoRepository = new PedidoRepository();
		ValidacaoService validacaoService = new ValidacaoService(usuarioRepository, produtoRepoditory, pedidoRepository);
		MenuView menuView = new MenuView();

		int opcao;
		int opcaoUsuario;

		do {

			System.out.println("+========== MENU ==========+");
			System.out.println("        1-CADASTRAR");
			System.out.println("        2-LOGIN");
			System.out.println("        3-SAIR");
			System.out.println("+===========================+");

			System.out.print("->");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:

				System.out.println("+========== CADASTRO ==========+");
				System.out.println("        1-VENDEDOR");
				System.out.println("        2-CLIENTE");
				System.out.println("+===========================+");

				System.out.print("->");
				opcaoUsuario = sc.nextInt();

				if (opcaoUsuario == 1) {
					
					sc.nextLine();
					
					System.out.println("Digite o nome:");
					String nome = sc.nextLine();


					System.out.println("Digite o email:");
					String email = sc.nextLine();
					
					if(!validacaoService.validarEmail(email)) {
						System.out.println("Email invalido");
						break;
					}

					System.out.println("Digite a senha:");
					String senha = sc.nextLine();
					
					if(!validacaoService.validarSenha(senha)) {
						System.out.println("A senha deve possuir no minimo 6 caracteres");
						break;
					}

					usuarioController.cadastrarVendedor(nome, email, senha);
					System.out.println("Vendedor cadastrado com sucesso");
					
				} else if (opcaoUsuario == 2) {
					
					sc.nextLine();

					System.out.println("Digite o nome:");
					String nome = sc.nextLine();


					System.out.println("Digite o email:");
					String email = sc.nextLine();
					
					if(!validacaoService.validarEmail(email)) {
						System.out.println("Email invalido");
						break;
					}

					System.out.println("Digite a senha:");
					String senha = sc.nextLine();
					
					if(!validacaoService.validarSenha(senha)) {
						System.out.println("A senha deve possuir no minimo 6 caracteres");
						break;
					}

					usuarioController.cadastrarVendedor(nome, email, senha);
					System.out.println("Cliente cadastrado com sucesso");
					

				} else {
					System.out.println("Esconlha uma opção valida");
				}

				break;

			case 2:
				
				System.out.println("+========== LOGIN ==========+");
				
				    sc.nextLine();
				
					System.out.println("Digite o email:");
					String email = sc.nextLine();

					System.out.println("Digite a senha:");
					String senha = sc.nextLine();	
					
					if(!validacaoService.validarEmail(email) || !validacaoService.validarSenha(senha)) {
						System.out.println("Cadastro não encontrado");
						break;
					}

					Usuario usuario = usuarioController.login(email, senha);
					
					if(usuario != null) {
						System.out.println("Login feito com sucesso");
						
						//chama o menu 
						
						//CLIENTE
						if(usuario.getTipo().equals("CLIENTE")) {
							
							//conversão de tipo
							Cliente cliente = (Cliente) usuario;
							
							menuView.menuCliente(cliente);
							
							
						}else if(usuario.getTipo().equals("VENDEDOR")) {
							
							Vendedor vendedor = (Vendedor) usuario;
							
							menuView.menuVendedor(vendedor);
							
						}else {
							System.out.println("Usuario invalido");
						}
						
						
					}else {
						System.out.println("Email ou senha invalidos");
					}
				
				break;
			case 3:
				System.out.println("Saindo....");
				break;
			}
		} while (opcao != 3);
	}

}
