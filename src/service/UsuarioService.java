package service;

import java.util.Map;

//Responsavel pelas regras de negocio
import model.Cidade;
import model.Cliente;
import model.Usuario;
import model.Vendedor;
import repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository repository) {
		this.usuarioRepository = repository;
	}

	// CADASTRAR CLIENTE
	public Cliente cadastrarCliente(String nome, String email, String senha) {

		// Verifica se já existe um cliente com esse email
		if (usuarioRepository.existePorEmail(email)) {
			return null;
		}

		Cliente cliente = new Cliente(nome, email, senha);
		System.out.println("Cliente cadastrado");
		usuarioRepository.salvar(cliente);
		return cliente;
	}

	public Vendedor cadastrarVendedor(String nome, String email, String senha) {

		// Verifica se já existe um cliente com esse email
		if (usuarioRepository.existePorEmail(email)) {
			return null;
		}

		Vendedor vendedor = new Vendedor(nome, email, senha);
		System.out.println("Vendedor cadastrado");
		usuarioRepository.salvar(vendedor);
		return vendedor;

	}

	// Boa pratica = retornar Usuario evitar perda de informações
	public Usuario login(String email, String senha) {

		// Deve acontecer em duas etapas
		// 1-Procura o usuario pelo email
		// 2-Compara a senha digitada com a senha do usuario

		// guarda o objeto usuario completo pelo email
		Usuario usuario = usuarioRepository.buscarPorEmail(email);

		// Usa os dados dele o getSenha pra validar
		if (usuario != null && usuario.getSenha().equals(senha)) {
			return usuario;
		}

		return null;
	}

	// lista todos os usuarios
	public Map<String, Usuario> listarUsuarios() {
		return usuarioRepository.listarTodos();
	}

	//Atualiza o objeto usuario que contem as informações
	public Usuario atualização(String id,String nome,String email) {
		
		// 1-Procura o usuario pelo email
		Usuario usuario = usuarioRepository.buscarPorEmail(email);
		
		if(usuario == null) {
			return null;
		}
	
		usuario.setNome(nome);
		usuario.setEmail(email);
		
		return usuario;
	}

	public boolean remoçãoDeUsuarios(String id) {
		Usuario usuario = usuarioRepository.buscarPorId(id);

		if (usuario != null) {
			return usuarioRepository.remover(id);
		}
		return false;
	}
}
