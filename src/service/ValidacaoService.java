package service;

import java.util.List;

import model.Pedido;
import model.Produto;
import model.Usuario;
import repository.PedidoRepository;
import repository.ProdutoRepository;
import repository.UsuarioRepository;

public class ValidacaoService {

	private UsuarioRepository usuarioRepository;
	private ProdutoRepository produtoRepository;
	private PedidoRepository pedidoRepository;

	public ValidacaoService(UsuarioRepository usuarioRepository, ProdutoRepository produtoRepository,
			PedidoRepository pedidoRepository) {

		this.usuarioRepository = usuarioRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoRepository = pedidoRepository;
	}

	// verifica se a senha possui pelo menos 6 caracteres
	public boolean validarSenha(String senha) {
		if (senha == null || senha.length() < 6) {
			return false;
		}
		return true;
	}

	// verifica se o email possui @
	public boolean validarEmail(String email) {
		if (email == null) {
			return false;
		}

		if (!email.contains("@")) {
			return false;
		}

		if (!email.contains(".")) {
			return false;
		}
		return true;
	}

	//verifica se já existe usuario com email informado
	public boolean validarExistenciaEmail(String email) {
		return !usuarioRepository.existePorEmail(email);
	}

	//realiza login
	public Usuario validarLogin(String email,String senha) {
		Usuario usuario = usuarioRepository.buscarPorEmail(email);
		
		if(usuario != null && usuario.getSenha().equals(senha)) {
			return usuario;
		}
		return null;
	}
	
	//metodos arbitrarios

	//Verifica se o usuario existe
	public Usuario validarExistenciaUsuario(String usuarioId) {
		return usuarioRepository.buscarPorId(usuarioId);
	}

	public Produto validarExistenciaProduto(String produtoId) {
		return produtoRepository.buscarPorId(produtoId);
	}

	//verificar se pedido existe
	public Pedido validarExistenciaPedido(String pedidoId) {
		return pedidoRepository.buscarPorId(pedidoId);
	}
	
	//retorna o historico de compras do cliente
	public List<Pedido> validarExistenciaHistorico(String clienteId) {
		Usuario usuario = usuarioRepository.buscarPorEmail(clienteId);
		
		if(usuario == null) {
			return null;
		}
		return (List<Pedido>) pedidoRepository.listarPorCliente(clienteId);
	}
	
}
