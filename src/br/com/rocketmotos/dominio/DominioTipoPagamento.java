package br.com.rocketmotos.dominio;

import br.com.rocketmotos.util.Constantes;

public class DominioTipoPagamento extends Dominio {

	public static DominioTipoPagamento aDominioTipoPagamento = new DominioTipoPagamento();

	public static DominioTipoPagamento getInstance() {
		if (aDominioTipoPagamento == null) {
			aDominioTipoPagamento = new DominioTipoPagamento();
		}

		return aDominioTipoPagamento;
	}

	public DominioTipoPagamento() {
		this.setValor(Constantes.Tipo_Pagamento_Dinheiro, "DINHEIRO");
		this.setValor(Constantes.Tipo_Pagamento_Cartao, "CARTÃO");
	}
}
