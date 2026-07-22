package model;

import java.time.LocalDateTime;
import java.util.Objects;

import service.IdService;

public class Produto {
	/*
	 * Representa um produto anunciado por um vendedor no marketplace.
	 */

	private final String id;
	private String nome;
	private String descricao;
	private double preco;
	private int quantidadedeEstoque;
	private Cidade cidade;// Associação
	//evitar que o objeto fique carregando uma referencia
	//uso de repository
	private final String vendedorId;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;

	public Produto(String nome, String descricao, double preco, int quantidadedeEstoque, Cidade cidade,
			String vendedorId) {
		this.id = IdService.gerarId();
		this.nome = Objects.requireNonNull(nome, "Nome é obrigatorio");
		this.descricao = Objects.requireNonNull(descricao, "Descrição é obrigatoria");

		if (preco < 0)
			throw new IllegalArgumentException("Preço não pode ser negativo");
		this.preco = preco;
		if (quantidadedeEstoque < 0)
			throw new IllegalArgumentException("Estoque não pode ser negativo");
		this.quantidadedeEstoque = quantidadedeEstoque;
		this.cidade = cidade;
		this.vendedorId = Objects.requireNonNull(vendedorId, "VendedorId é obrigatorio");
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = this.dataCadastro;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadedeEstoque() {
		return quantidadedeEstoque;
	}

	public void setQuantidadedeEstoque(int quantidadedeEstoque) {
		this.quantidadedeEstoque = quantidadedeEstoque;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getVendedorId() {
		return vendedorId;
	}
/*
	public void setVendedorId(String vendedorId) {
		this.vendedorId = vendedorId;
	}
*/
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getId() {
		return id;
	}

	public void atualizarData() {
		this.dataAtualizacao = LocalDateTime.now();
	}

	public int baixarEstoque(int quantidade) {
		this.quantidadedeEstoque -= quantidade;
		atualizarData();
		return quantidadedeEstoque;
	}
/*
	public void setVendedorId(String vendedorId) {
		this.vendedorId = vendedorId;
	}
*/
	public boolean possuiEstoqueSuficiente(int quantidadeDesejada) {
		return (quantidadeDesejada > 0 && quantidadeDesejada < this.quantidadedeEstoque);
	}
}