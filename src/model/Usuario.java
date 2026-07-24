package model;

import java.time.LocalDateTime;
import java.util.Objects;

import service.IdService;

public abstract class Usuario {

	private String id;
	private String nome;
	private String email;
	private String senha;
    private final LocalDateTime dataCadastro;


	public Usuario(String nome, String email, String senha) {
		// chama o metodo que cria o id automatico
		this.id = IdService.gerarId();
		this.dataCadastro = LocalDateTime.now();
		/*
		 * Objects.requireNonNull() é um método da classe java.util.Objects utilizado
		 * para garantir que um objeto não seja nulo. Caso algum parâmetro seja null,
		 * uma NullPointerException é lançada imediatamente.
		 * 
		 */
		this.nome = Objects.requireNonNull(nome, "Nome é obrigatório");
		this.email = Objects.requireNonNull(email, "Email é obrigatório");
		this.senha = Objects.requireNonNull(senha, "Senha é obrigatória");

	}

	public String getId() {
		return id;
	}

	// Não possui pois o ID é imutavel
	/*
	 * public void setId(String id) { this.id = id; }
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	
	
	
	@Override
	public String toString() {
		return "Usuario id=" + id + ",\n nome=" + nome + ",\n email=" + email + ",\n senha=" + senha + ",\n dataCadastro="
				+ dataCadastro + "";
	}

	// Implementado pelas classes filhas
	/*
	 * permite identificar cada tipo de usuario sem precisar 
	 * ultilizar o instanceof
	 */
	public abstract String getTipo();

}
