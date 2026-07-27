package controller;

import model.Cliente;
import model.Usuario;
import model.Vendedor;
import service.UsuarioService;

//em desenvolvimento

public class UsuarioController {

	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public Cliente cadastrarCliente(String nome,String email,String senha) {
		return usuarioService.cadastrarCliente(nome, email, senha);
	}
	
	public Vendedor cadastrarVendedor(String nome,String email,String senha) {
		return usuarioService.cadastrarVendedor(nome, email, senha);
	}
	
	public Usuario login(String email,String senha) {
		return usuarioService.login(email, senha);
	}
}
