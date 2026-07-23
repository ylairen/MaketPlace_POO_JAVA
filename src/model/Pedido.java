package model;

import java.time.LocalDateTime;

import service.IdService;

public class Pedido {

	private final String id;
	private final String produtoId;
	private final String clienteId;
	private final String vendedorId;

	private final int quantidade;
	private final Endereço enderecoEntrega;
	private final MetodoPagamento metodoPagamento;
	private final boolean retirada;

	private final double valorProdutos;
	private final double valorFrete;
	private double desconto;
	private double valorTotal;

	private StatusPedido status;

	private final LocalDateTime dataCompra;
	private final LocalDateTime dataPrevisaoEntrega;
	private LocalDateTime dataEntrega;

	public Pedido(String produtoId, String clienteId, String vendedorId, int quantidade, Endereço enderecoEntrega,
			MetodoPagamento metodoPagamento, boolean retirada, double valorProdutos, double valorFrete, double desconto,
			double valorTotal, StatusPedido status, LocalDateTime dataCompra, LocalDateTime dataPrevisaoEntrega,
			LocalDateTime dataEntrega) {

		this.id = IdService.gerarId();
		this.produtoId = produtoId;
		this.clienteId = clienteId;
		this.vendedorId = vendedorId;

		if (quantidade < 0) {
			System.out.println("Quantidade não pode ser negativa");
		}

		this.quantidade = quantidade;
		this.enderecoEntrega = enderecoEntrega;
		this.metodoPagamento = metodoPagamento;
		this.retirada = retirada;
		this.valorProdutos = valorProdutos;
		this.valorFrete = valorFrete;
		this.desconto = 0;
		this.valorTotal = valorProdutos + valorFrete;
		// No momento que faz o pedido muda o status
		this.status = StatusPedido.EM_TRANSPORTE;
		this.dataCompra = LocalDateTime.now();
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
		this.dataEntrega = null;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getId() {
		return id;
	}

	public String getProdutoId() {
		return produtoId;
	}

	public String getClienteId() {
		return clienteId;
	}

	public String getVendedorId() {
		return vendedorId;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Endereço getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public boolean isRetirada() {
		return retirada;
	}

	public double getValorProdutos() {
		return valorProdutos;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public double getDesconto() {
		return desconto;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public LocalDateTime getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void aplicaDesconto(double valorDesconto) {
		if (valorDesconto < 0) {
			throw new IllegalArgumentException("Desconto não pode ser negativo");
		}
		this.desconto = valorDesconto;
		this.valorTotal = valorProdutos + valorFrete - desconto;
	}

	public void atualizarStatus(StatusPedido status) {
		this.status = status;

		if (status == StatusPedido.ENTREGUE) {
			this.dataEntrega = LocalDateTime.now();
		}
	}

}
