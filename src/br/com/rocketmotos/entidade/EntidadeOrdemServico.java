package br.com.rocketmotos.entidade;

import java.sql.Date;

public class EntidadeOrdemServico {
	
	public static final String NM_ENTIDADE = EntidadeItemOrdemServico.class
			.getSimpleName();
	public static final String NM_TABELA = "ORDEM_SERVICO";

	public static final String NM_COL_CodigoOrdemServico = "ORDEM_SERVICO_CD";
	public static final String NM_COL_PlacaMoto = EntidadeMoto.NM_COL_PlacaMoto;
	public static final String NM_COL_Data = "DATA";
	public static final String NM_COL_IndicadorOrcamento = "INDICADOR_ORCAMENTO";
	public static final String NM_COL_Valor = "VALOR";
	public static final String NM_COL_Desconto = "DESCONTO";

	private int codigoOrdemServico;
	private String placaMoto;
	private Date data;
	private String indicadorOrcamento;
	private Double valor;
	private Double desconto;

	public int getCodigo() {
		return codigoOrdemServico;
	}

	public void setCodigo(int codigoOrdemServico) {
		this.codigoOrdemServico = codigoOrdemServico;
	}

	public String getPlacaMoto() {
		return placaMoto;
	}

	public void setPlacaMoto(String placaMoto) {
		this.placaMoto = placaMoto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getIndicadorOrcamento() {
		return indicadorOrcamento;
	}

	public void setIndicadorOrcamento(String indicadorOrcamento) {
		this.indicadorOrcamento = indicadorOrcamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return "EntidadeOrdemServico [codigoOrdemServico=" + codigoOrdemServico + ", placaMoto=" + placaMoto
				+ ", data=" + data + ", indicadorOrcamento="
				+ indicadorOrcamento + ", valor=" + valor + ", desconto="
				+ desconto + "]";
	}

}
