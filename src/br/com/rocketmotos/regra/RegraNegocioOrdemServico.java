package br.com.rocketmotos.regra;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.rocketmotos.dao.DAOItemOrdemServico;
import br.com.rocketmotos.dao.DAOOrdemServico;
import br.com.rocketmotos.dao.DAOProduto;
import br.com.rocketmotos.entidade.EntidadeItemOrdemServico;
import br.com.rocketmotos.entidade.EntidadeOrdemServico;
import br.com.rocketmotos.entidade.EntidadeProduto;
import br.com.rocketmotos.entidade.EntidadeServico;
import br.com.rocketmotos.util.Constantes;


public class RegraNegocioOrdemServico {
	
	//método responsável por percorrer todos os itens da ordem de serviço, atualizar a quantidade de produto utilizada
	public static void processar (String cdOrdemServico) throws SQLException{
		//declaracao de variaveis
		ResultSet rsResposta = null;
		EntidadeOrdemServico eOrdemServico = null;
		Double somatorioTotal = new Double("0.00");
		Double valorProduto = new Double("0.00");
		Double valorServico = new Double("0.00");
		int qtdProdutoUtilizado = 0;
		int qtdTotalProduto = 0;
		String cdProduto = "";
		
		//consulta todos os itens da ordem de serviço que foi passada para poder 
		//calcular os valores e atualizar a ordem de serviço
		if(cdOrdemServico != null && !cdOrdemServico.equals("")){
			//retorna o resultset com inner join em servico, produto e categoria produto
			rsResposta = DAOItemOrdemServico.consultarTodosPorCodigoOrdem(Integer.valueOf(cdOrdemServico));
			eOrdemServico = DAOOrdemServico.consultarPorCodigo(cdOrdemServico);
			
			if(rsResposta != null){
				//itera o laço com todos os itens referentes a ordem de serviço  
				while (rsResposta.next()) {
					//recupera o codigo do produto para consultar em produto e atualizar a quantidade ainda disponivel
					cdProduto = rsResposta.getString(EntidadeItemOrdemServico.NM_COL_CodigoProduto);
					qtdProdutoUtilizado = rsResposta.getInt(EntidadeItemOrdemServico.NM_COL_QtdProdutoUtilizado);
					valorProduto = rsResposta.getDouble(EntidadeProduto.NM_COL_Valor);
					valorServico = rsResposta.getDouble(EntidadeServico.NM_COL_Valor);
					
					//recupera o produto para atualizar a quantidade
					EntidadeProduto eProduto = DAOProduto.consultarPorCodigo(cdProduto).get(0);
					qtdTotalProduto = eProduto.getQuantidade();
					qtdTotalProduto = qtdTotalProduto - qtdProdutoUtilizado;
					eProduto.setQuantidade(qtdTotalProduto);
					
					//atualiza a quantidade do produto
					DAOProduto.alterar(eProduto);
					
					//atualiza a variavel de soma total da ordem de serviço e com o valor do serviço
					somatorioTotal = somatorioTotal + (valorProduto * qtdProdutoUtilizado);
					somatorioTotal = somatorioTotal + valorServico;
				}
			}
			//appós iterar todos os itens da ordem de serviço, atualiza o indicador da 
			//ordem de serviço para NÃO e inclui o valor total da ordem de serviço
			eOrdemServico.setIndicadorOrcamento(Constantes.CD_NAO);
			eOrdemServico.setValor(somatorioTotal);
			
			//atualiza a ordem de serviço
			DAOOrdemServico.alterar(eOrdemServico);
		}
	}

}
