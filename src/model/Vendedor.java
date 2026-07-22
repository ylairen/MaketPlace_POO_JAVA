package model;

public class Vendedor extends Usuario {

	public Vendedor(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		return TipoUsuario.VENDEDOR.name();
	}
	

}
