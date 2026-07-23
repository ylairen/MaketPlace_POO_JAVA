package repository;

import java.util.HashMap;
import java.util.Map;

import model.Pedido;

public class PedidoRepository {

	Map<String, Pedido> pedidos;

	public PedidoRepository() {
		this.pedidos = new HashMap<>();
	}

	public Pedido salvar(Pedido pedido) {
		pedidos.put(pedido.getId(),pedido);
		return pedido;
	}

	public Map<String,Pedido> listarTodos(){
			return pedidos;
	}
	
	public Pedido buscarPorId(String id) {
		//o hashmap já procura diretamente pelo ID
		return pedidos.get(id);
	}

	public Map<String, Pedido> listarPorCliente(String clienteId) {
		
		//Armazena somente os pedidos desse cliente
		Map<String,Pedido> pedidosCliente = new HashMap<>();
		
		for(Pedido pedido : pedidos.values()) {
			if(pedido.getClienteId().equals(clienteId)) {
				pedidosCliente.put(pedido.getId(), pedido);
			}
		}
		return pedidosCliente;
		
	}

	public Map<String, Pedido> listarPorVendedor(String VendedorId) {
		
		Map<String,Pedido> pedidosVendedor = new HashMap<>();
		
		for(Pedido pedido:pedidos.values()) {
			if(pedido.getVendedorId().equals(VendedorId)) {
				pedidosVendedor.put(pedido.getId(), pedido);
			}
		}
		return pedidosVendedor;
	}

}
