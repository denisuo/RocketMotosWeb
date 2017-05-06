package br.com.rocketmotos.entidade;

public class EntidadeItemVenda {

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
