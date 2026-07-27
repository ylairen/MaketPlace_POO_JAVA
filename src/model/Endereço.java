package model;

import java.util.Objects;

public class Endereço {
	private String rua;
	private String numero;
	private String complemento;
	private Cidade cidade;

	public Endereço(String rua, String numero, String complemento,Cidade cidade) {

		this.rua = Objects.requireNonNull(rua);
		this.numero = Objects.requireNonNull(numero);
		this.complemento = Objects.requireNonNull(complemento);
		this.cidade = Objects.requireNonNull(cidade);
	}

	/*
	 * Não possui setters o endereço é imutavel apos a criação
	 */

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

}
