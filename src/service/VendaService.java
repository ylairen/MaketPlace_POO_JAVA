package service;

import java.time.LocalDateTime;
import java.util.List;

import model.Cidade;
import model.Endereço;
import model.MetodoPagamento;
import model.Pedido;
import model.Produto;
import model.StatusPedido;
import repository.PedidoRepository;
import repository.ProdutoRepository;

public class VendaService {
	private ProdutoRepository produtoRepository;
	private PedidoRepository pedidoRepository;
	private ValidacaoService validacaoService;
	private FreteService freteService;

	public VendaService(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository,
			ValidacaoService validacaoService, FreteService freteService) {
		this.produtoRepository = produtoRepository;
		this.pedidoRepository = pedidoRepository;
		this.validacaoService = validacaoService;
		this.freteService = freteService;
	}

	public Pedido realizarCompra(String clienteId, String produtoId, int quantidade, Endereço enderecoEntrega,
			MetodoPagamento metodoPagamento, boolean retirada) {

		// verificar se o usuario existe
		validacaoService.validarExistenciaUsuario(clienteId);

		// procura o produto
		Produto produto = produtoRepository.buscarPorId(produtoId);

		if (produto == null) {
			System.out.println("Produto não encontrado");
			return null;
		}

		if (!produto.possuiEstoqueSuficiente(quantidade)) {
			System.out.println("Quantidade escolhida invalida");
			return null;
		}
		
		Cidade origem = produto.getCidade();
		Cidade destino;
		
		if(retirada) {
			destino = origem;
		}else {
			destino = enderecoEntrega.getCidade();
		}
		
		double frete = freteService.calcularFrete(origem, destino, retirada);
		double valorProduto = produto.getPreco()*quantidade;
		LocalDateTime previsaoEntrega;
		
		if(origem == destino) {
			previsaoEntrega = LocalDateTime.now().plusDays(1);
		}else{
			previsaoEntrega = LocalDateTime.now().plusDays(3);
		}
		
		Pedido pedido = new Pedido(produtoId, clienteId,produto.getVendedorId(), quantidade, enderecoEntrega, metodoPagamento, retirada, valorProduto, frete, previsaoEntrega);
	
		//diminui estoque
		produto.baixarEstoque(quantidade);
		
		//salva o pedido
		pedidoRepository.salvar(pedido);
		return pedido;
	}
		//aplica desconto
	
	public Pedido aplicaDesconto(String pedidoId,double desconto) {
		Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
		
		if(pedido == null) {
			return null;
		}
		
		pedido.aplicaDesconto(desconto);
		return pedido;
	}
		
		//atualiza status
	
		public Pedido atualizarStatusPedido(String pedidoId,StatusPedido status) {
			Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
			if(pedido == null) {
				return null;
			}
			pedido.atualizarStatus(status);
			return pedido;
		}
		//solicita reembolso
			
			public Pedido solicitarReembolso(String pedidoId) {
				Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
				
				if(pedido == null) {
					return null;
				}
				pedido.atualizarStatus(StatusPedido.REEMBOLSADO);
				return pedido;
			}
		
		//historico de compras
			
			public List<Pedido> vendasDoCliente(String clienteId){
				return (List<Pedido>) pedidoRepository.listarPorCliente(clienteId);
			}
		
		//vendas do vendedor
			public List<Pedido> vendasDoVendedor(String vendedorId){
				return (List<Pedido>) pedidoRepository.listarPorVendedor(vendedorId);
			}
		
		//busca um pedido
			public Pedido buscarPedido(String pedidoId) {
				return pedidoRepository.buscarPorId(pedidoId);
			}
	}

