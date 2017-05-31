package br.com.rocketmotos.dominio;

import br.com.rocketmotos.util.Constantes;

public class DominioTipoPessoa extends Dominio {

	public static DominioTipoPessoa aDominioTipoPessoa = new DominioTipoPessoa();

	public static DominioTipoPessoa getInstance() {
		if (aDominioTipoPessoa == null) {
			aDominioTipoPessoa = new DominioTipoPessoa();
		}

		return aDominioTipoPessoa;
	}

	public DominioTipoPessoa() {
		this.setValor(Constantes.Tipo_Pessoa_PF, "PESSOA FÍSICA");
		this.setValor(Constantes.Tipo_Pessoa_PJ, "PESSOA JURÍDICA");
	}
}
