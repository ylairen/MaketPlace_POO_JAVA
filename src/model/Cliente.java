package model;
//herda da classe pai usuario
public class Cliente extends Usuario {

	public Cliente(String nome, String email, String senha) {
		super(nome, email, senha);
		//System.out.println("Cliente criado");
	}

	@Override
	public String getTipo() {
		//Retorna o enum do tipo cliente
		//sempre com o nome definido no enum
		return TipoUsuario.CLIENTE.name();
	}
	
	
	

}
