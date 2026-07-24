package service;

import java.util.Map;

import model.Pedido;
import model.StatusPedido;
import repository.PedidoRepository;

public class PedidoService {

	PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public void realizarPedido(Pedido pedido) {
		pedidoRepository.salvar(pedido);
	}

	public Pedido buscarPedido(String id) {
		return pedidoRepository.buscarPorId(id);
	}

	public Map<String, Pedido> listarTodos() {
		return pedidoRepository.listarTodos();
	}

	public Map<String, Pedido> listarPorCliente(String ClienteId) {
		return pedidoRepository.listarPorCliente(ClienteId);

	}

	public Map<String, Pedido> listarPorVendedor(String vendedorId) {
		return pedidoRepository.listarPorVendedor(vendedorId);
	}

	public boolean atualizarStatus(String id, StatusPedido status) {
		Pedido pedido = pedidoRepository.buscarPorId(id);

		if (pedido == null) {
			return false;
		}
		pedido.atualizarStatus(status);
		return true;
	}

	/*
	public boolean aplicarDesconto(String id, double desconto) {

	}

	public boolean cancelarPedido(String id) {

	}
*/
}
