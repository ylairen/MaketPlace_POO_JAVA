package teste;

import java.time.LocalDateTime;

import model.Cidade;
import model.Endereço;
import model.MetodoPagamento;
import model.Pedido;
import model.StatusPedido;
import repository.PedidoRepository;
import service.PedidoService;

public class TestePedido {

	public static void main(String[] args) {

		PedidoRepository repository = new PedidoRepository();
		PedidoService service = new PedidoService(repository);

		Endereço endereço = new Endereço("Rua das Flores",
		"123","Centro",Cidade.JUAZEIRO_DO_NORTE);
		
		Pedido pedido = new Pedido("P001","C001","V001",2,endereço,
		MetodoPagamento.PIX, false,200.00,20.30,0,220,StatusPedido.EM_TRANSPORTE,LocalDateTime.now(), 
		LocalDateTime.now().plusDays(5), null);
		
		//REALIZAR PEDIDO
		service.realizarPedido(pedido);

		System.out.println("=== PEDIDO CADASTRO ===");
		System.out.println("ID:"+pedido.getId());
		System.out.println("Cliente:"+pedido.getClienteId());
		System.out.println("Vendedor:"+pedido.getVendedorId());
		System.out.println("Valor total:"+pedido.getValorTotal());
	
		//BUSCAR PEDIDO
		Pedido pedidoBuscado = service.buscarPedido(pedido.getId());
		
		System.out.println("=== PEDIDO ENCONTRADO ===");
		System.out.println("Produto:"+pedidoBuscado.getProdutoId());
		
		System.out.println("Cidade:"+endereço.getCidade());
		
		//ATUALIZAR DESCONTO
		
		//ATUALIZAR STATUS
		
		//LISTAR TODOS OS PEDIDOS
	}

}
