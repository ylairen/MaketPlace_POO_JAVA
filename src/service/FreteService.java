package service;

import model.Cidade;

public class FreteService {

	public double calcularFrete(Cidade origem,Cidade destino,boolean retirada) {
		if(retirada || (origem==destino))
			return 0.0;
			final boolean envolveBarbalhaJuazeiro = (origem == Cidade.BARBALHA && destino == Cidade.JUAZEIRO_DO_NORTE)
					|| (origem == Cidade.JUAZEIRO_DO_NORTE && destino == Cidade.BARBALHA);
			if(envolveBarbalhaJuazeiro) 
				return 15.0;
			return 20.0;
			}
}
