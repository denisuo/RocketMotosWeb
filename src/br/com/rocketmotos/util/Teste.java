package br.com.rocketmotos.util;

import java.util.ArrayList;

import br.com.rocketmotos.dominio.DominioSimNao;
import br.com.rocketmotos.dominio.DominioTipoPagamento;
import br.com.rocketmotos.regra.RegraNegocioOrdemServico;
import br.com.rocketmotos.relatorio.RelatorioPDF;



public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		System.out.println("INICIO " + System.currentTimeMillis());
		
		Double valorServico = new Double("0.00");
		Double valorProduto = new Double("25.00");
		
		System.out.println("VALOR SERVIÇO - " + valorServico);
		System.out.println("VALOR PRODUTO - " + valorProduto);
		System.out.println("VALOR TOTAL - " + (valorServico + valorProduto));
		
		
		try {
			RelatorioPDF relatorio = new RelatorioPDF();
			relatorio.gerar("1");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("FIM " + System.currentTimeMillis());
		
		
		
		//for (String string : DominioTipoPagamento.getInstance().getChaves()) {
			//System.out.println(DominioTipoPagamento.getInstance().getValor(string));
		//}
		
	}
}
