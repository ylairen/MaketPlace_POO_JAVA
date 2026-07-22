package repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Usuario;
//CONCERTAR
public class UsuarioRepository {
	
	private Map<String,Usuario> usuarios;
	
	public UsuarioRepository() {
		usuarios = new HashMap<>();
	}
	
	public void salvar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}

	public Usuario buscarPorId(String id) {
		return usuarios.get(id);
	}
	
	//PODE CAUSAR PROBLEMAS DE AUTENTIAÇÃO
	//PODE ENCONTRAR UM EMAIL E SENHA DE PESSOAS DIFERENTES E TRATAR COMO A MESMA
	/*
	 *
	public Usuario buscarPorSenha(String senha) {
		for(Usuario usuario:usuarios.values()) {
			if(usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}
	*/
	
	public Usuario buscarPorEmail(String email) {
		for(Usuario usuario:usuarios.values()) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}
	
	//Verifica se esse email já existe
	public boolean existePorEmail(String email) {
		for(Usuario usuario:usuarios.values()) {
			if(usuario.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public Map<String,Usuario> listarTodos() {
		return usuarios;
	}
	
	public boolean remover(String id) {
		if(usuarios.containsKey(id)) {
			usuarios.remove(id);
			return true;
		}
		return false;
	}

}
