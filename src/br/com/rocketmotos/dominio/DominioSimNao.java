package br.com.rocketmotos.dominio;

import br.com.rocketmotos.util.Constantes;

public class DominioSimNao extends Dominio {

	public static DominioSimNao aDominioSimNao = new DominioSimNao();

	public static DominioSimNao getInstance() {
		if (aDominioSimNao == null) {
			aDominioSimNao = new DominioSimNao();
		}

		return aDominioSimNao;
	}

	public DominioSimNao() {
		this.setValor(Constantes.CD_SIM, "SIM");
		this.setValor(Constantes.CD_NAO, "NÃO");
	}
}
