package br.com.rocketmotos.relatorio;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.rocketmotos.dao.DAOItemOrdemServico;
import br.com.rocketmotos.dao.DAOOrdemServico;
import br.com.rocketmotos.entidade.EntidadeItemOrdemServico;
import br.com.rocketmotos.entidade.EntidadeOrdemServico;
import br.com.rocketmotos.entidade.EntidadeProduto;
import br.com.rocketmotos.util.Constantes;

public class RelatorioPDF {
	
	//declara variaveis
    private HashMap<String, Object> hmCamposRelatorio = new HashMap<String, Object>();
    private ArrayList<HashMap<String, Object>> arCamposRelatorio = new ArrayList<HashMap<String, Object>>();
    
    public void gerar(String cdOrdemServico) throws JRException, URISyntaxException, SQLException {

    	//declara as variaveis
    	EntidadeOrdemServico eOrdemServico = null;
    	ResultSet rsRetornoConsulta = null;
    	
        int contador = 0;
        String caminhoArquivoCompilar = "C:/desenvolvimento/workspace/RocketMotosWeb/src/br/com/rocketmotos/relatorio/Relatorio.jrxml";

        //consulta em ordem de servico
        eOrdemServico = DAOOrdemServico.consultarPorCodigo(cdOrdemServico);
        
		//inclui os campos do cabeçalho
        this.incluirCamposCabecalho(eOrdemServico);
        
        //consulta todos os itens pelo codigo da ordem de servico
        rsRetornoConsulta = DAOItemOrdemServico.consultarTodosPorCodigoOrdem(Integer.valueOf(cdOrdemServico));
        
        //itera o resultSet para preencher o arrayList com todos os itens referentes a ordem de servico
        if(rsRetornoConsulta != null){
        	while (rsRetornoConsulta.next()) {
        		String codigoProduto = rsRetornoConsulta.getString(EntidadeProduto.NM_COL_CodigoProduto);
        		String descricaoProduto = rsRetornoConsulta.getString(EntidadeProduto.NM_COL_Descricao);
        		double valorProduto = rsRetornoConsulta.getDouble(EntidadeProduto.NM_COL_Valor);
        		int qtdUtilizado = rsRetornoConsulta.getInt(EntidadeItemOrdemServico.NM_COL_QtdProdutoUtilizado);
        		
        		//inclui os campos no hashMap
        		hmCamposRelatorio.put("CD_PRODUTO", codigoProduto);
        		hmCamposRelatorio.put("DSC_PRODUTO", descricaoProduto);
        		hmCamposRelatorio.put("QTD_UTILIZADO", qtdUtilizado);
        		hmCamposRelatorio.put("VALOR_PRODUTO", valorProduto);
        		
        		//adiciona os campos que irão se repetir no hashMap
        		arCamposRelatorio.add(hmCamposRelatorio);
        		hmCamposRelatorio = new HashMap<String, Object>();
			}
        }
        
        //inclui o valor total no hashMap
        hmCamposRelatorio.put("VALOR_TOTAL", eOrdemServico.getValor());
        arCamposRelatorio.add(hmCamposRelatorio);

        
        System.out.println("Gerando Relatório...");

        try {
            
            String nmUsuario = System.getProperty("user.name");
            JasperReport report = JasperCompileManager.compileReport("C:/desenvolvimento/workspace/RocketMotosWeb/src/br/com/rocketmotos/relatorio/Relatorio.jrxml");

            JasperPrint print = JasperFillManager.fillReport(report, hmCamposRelatorio,
                    new JRBeanCollectionDataSource(arCamposRelatorio));
            
            //exporta o arquivo para a area de trabalho
            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\"  +nmUsuario + "\\Desktop\\RelatorioPDF.pdf");
            System.out.println("Relatório gerado com Sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO AO GERAR RELATÓRIO!");
        }
    }

    //metodo responsavel por preencher o cabeçalho do relatorio
	private void incluirCamposCabecalho(EntidadeOrdemServico eOrdemServico) {
        hmCamposRelatorio.put("CD_ORDEM", eOrdemServico.getCodigo());
        
        //verifica o indicador de orçamento para incluir o titulo de acordo 
        if(eOrdemServico.getIndicadorOrcamento().equals(Constantes.CD_NAO)){
        	hmCamposRelatorio.put("TITULO", "ORDEM DE SERVIÇO");
        } else {
        	hmCamposRelatorio.put("TITULO", "ORÇAMENTO");
        }
        
        hmCamposRelatorio.put("DATA", eOrdemServico.getData());
        arCamposRelatorio.add(hmCamposRelatorio);
        hmCamposRelatorio = new HashMap<String, Object>();
	}
}
