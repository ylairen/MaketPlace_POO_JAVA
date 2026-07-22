package app;
import model.Cliente;
import repository.UsuarioRepository;
import service.UsuarioService;

public class CadastroDeUsuarios {
	public static void main(String[] args) {
		UsuarioRepository usuarioRepository = new UsuarioRepository();
		UsuarioService usuarioService = new UsuarioService(usuarioRepository);
		
		Cliente c1 = new Cliente("Maria","Maria123@gmail.com","1234567890");
		usuarioService.cadastrarCliente("Maria","Maria123@gmail.com","1234567890");
		usuarioService.login("Maria123@gmail.com","1234567890");
		
		System.out.println(usuarioService.listarUsuarios());
		usuarioService.remoçãoDeUsuarios(c1.getId());
		System.out.println(usuarioService.listarUsuarios());

	}
}
