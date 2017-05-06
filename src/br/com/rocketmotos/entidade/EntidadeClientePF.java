package br.com.rocketmotos.entidade;

public class EntidadeClientePF extends EntidadeCliente{

	@Override
	public Double getDesconto() {
		//desconto 0%
		return new Double(0);
	}

}
