package br.com.rocketmotos.entidade;

public class EntidadeItemVenda {
	
	public static final String NM_ENTIDADE = EntidadeItemVenda.class
			.getSimpleName();
	public static final String NM_TABELA = "ITEM_VENDA";

	public static final String NM_COL_CodigoVenda = EntidadeVenda.NM_COL_CodigoVenda;
	public static final String NM_COL_CodigoProduto = EntidadeProduto.NM_COL_CodigoProduto;
	public static final String NM_COL_Quantidade = "QTD";
	
	private int codigoVenda;
	private String codigoProduto;
	private int qtd;

	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "EntidadeItemVenda [codigoVenda=" + codigoVenda
				+ ", codigoProduto=" + codigoProduto + ", qtd=" + qtd + "]";
	}

}
