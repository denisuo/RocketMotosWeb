package br.com.rocketmotos.util;

import java.sql.Date;
import java.util.ArrayList;

import br.com.rocketmotos.dao.DAOCategoriaProduto;
import br.com.rocketmotos.dao.DAOMoto;
import br.com.rocketmotos.dao.DAOProduto;
import br.com.rocketmotos.entidade.EntidadeCategoriaProduto;
import br.com.rocketmotos.entidade.EntidadeCliente;
import br.com.rocketmotos.entidade.EntidadeMoto;
import br.com.rocketmotos.entidade.EntidadeProduto;



public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Double valor = 130.00;
//		EntidadeClientePJ clientePJ = new EntidadeClientePJ();
//		Double valorDesconto = clientePJ.getDesconto();
//		valor = valor + (valor * valorDesconto);

		EntidadeProduto eProduto = new EntidadeProduto();
		eProduto.setCodigoProduto("123456789");
		eProduto.setNome("OLEO LUBRAX 20W50");
		eProduto.setDescricao("OLEO LUBRAX LUBRAX 20W50");
		eProduto.setValidade(Date.valueOf("2030-12-15"));
		eProduto.setCodigoCategoria(2);
		eProduto.setValor(20.00);
		eProduto.setQuantidade(100);
		
		//DAOProduto.incluir(eProduto);
		
		ArrayList<EntidadeProduto> alProduto = new ArrayList<EntidadeProduto>();
		alProduto = DAOProduto.consultarTodos();
		
		for (EntidadeProduto ep : alProduto) {
			
			System.out.println(ep);
			
		}
	}
}
