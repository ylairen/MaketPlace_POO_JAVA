package teste;

import model.Cidade;
import model.Cliente;
import model.Produto;
import model.Vendedor;
import repository.PedidoRepository;
import repository.ProdutoRepository;
import repository.UsuarioRepository;
import service.UsuarioService;
import service.ValidacaoService;

public class TesteCadastro {

	public static void main(String[] args) {
		
		UsuarioRepository usuarioRepository = new UsuarioRepository();
		UsuarioService usuarioService = new UsuarioService(usuarioRepository);
		ProdutoRepository produtoRepoditory = new ProdutoRepository();
		PedidoRepository pedidoRepository = new PedidoRepository();
		ValidacaoService validacaoService = new ValidacaoService(usuarioRepository, produtoRepoditory, pedidoRepository);
		
		// TODO Auto-generated method stub//OBJETOS
		Cliente c1 = new Cliente("Maria", "Maria123@gmail.com", "1234567890");
		Vendedor v1 = new Vendedor("Guilherme","Guilherme12@gmail.com","90909090");
		Produto p1 = new Produto("Gibi","Historia em quadrinhos do homem aranha",50,5,Cidade.CRATO,v1.getId());

		
		//PRINTAR
		//retorna caminho da memoria
		//System.out.println(c1);
		//Retorna o tipo
		//System.out.println(c1.getTipo());
		//System.out.println(c1.getDataCadastro());
		
		//System.out.println(v1.getId());
		//System.out.println(p1.getVendedorId());
		
		c1 = usuarioService.cadastrarCliente("Maria", "Maria123@gmail.com", "1234567890");
		
		System.out.println(validacaoService.validarEmail("Maria123@gmail.com"));
		System.out.println(validacaoService.validarSenha("1234567890"));


	}

}
