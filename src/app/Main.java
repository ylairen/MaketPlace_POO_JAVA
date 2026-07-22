package app;

import model.Cidade;
import model.Cliente;
import model.Produto;
import model.Vendedor;

public class Main {

	public static void main(String[] args) {
		
		//OBJETOS
		Cliente c1 = new Cliente("Maria", "Maria123@gmail.com", "1234567890");
		Vendedor v1 = new Vendedor("Guilherme","Guilherme12@gmail.com","90909090");
		Produto p1 = new Produto("Gibi","Historia em quadrinhos do homem aranha",50,5,Cidade.CRATO,v1.getId());

		
		//PRINTAR
		//retorna caminho da memoria
		//System.out.println(c1);
		//Retorna o tipo
		//System.out.println(c1.getTipo());
		//System.out.println(c1.getDataCadastro());
		
		System.out.println(v1.getId());
		System.out.println(p1.getVendedorId());
	}

}
