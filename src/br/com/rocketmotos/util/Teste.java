package br.com.rocketmotos.util;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

import br.com.rocketmotos.dao.DAOCategoriaProduto;
import br.com.rocketmotos.dao.DAOItemOrdemServico;
import br.com.rocketmotos.dao.DAOItemVenda;
import br.com.rocketmotos.dao.DAOOrdemServico;
import br.com.rocketmotos.dao.DAOServico;
import br.com.rocketmotos.dao.DAOMoto;
import br.com.rocketmotos.dao.DAOProduto;
import br.com.rocketmotos.dao.DAOVenda;
import br.com.rocketmotos.entidade.EntidadeCategoriaProduto;
import br.com.rocketmotos.entidade.EntidadeCliente;
import br.com.rocketmotos.entidade.EntidadeItemOrdemServico;
import br.com.rocketmotos.entidade.EntidadeItemVenda;
import br.com.rocketmotos.entidade.EntidadeOrdemServico;
import br.com.rocketmotos.entidade.EntidadeServico;
import br.com.rocketmotos.entidade.EntidadeMoto;
import br.com.rocketmotos.entidade.EntidadeProduto;
import br.com.rocketmotos.entidade.EntidadeVenda;



public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dataHoje = new Date(System.currentTimeMillis()).toString();
		dataHoje = dataHoje.replace("-", "");
		
		System.out.println(dataHoje);
		
		
		
	}
}
