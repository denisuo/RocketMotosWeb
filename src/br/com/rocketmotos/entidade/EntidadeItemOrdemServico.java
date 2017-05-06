package br.com.rocketmotos.entidade;

public class EntidadeItemOrdemServico {

	private int codigoOrdemServico;
	private String codigoProduto;
	private int codigoServico;
	private int qtdProdutoUtilizado;

	public int getCodigoOrdemServico() {
		return codigoOrdemServico;
	}

	public void setCodigoOrdemServico(int codigoOrdemServico) {
		this.codigoOrdemServico = codigoOrdemServico;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(int codigoServico) {
		this.codigoServico = codigoServico;
	}

	public int getQtdProdutoUtilizado() {
		return qtdProdutoUtilizado;
	}

	public void setQtdProdutoUtilizado(int qtdProdutoUtilizado) {
		this.qtdProdutoUtilizado = qtdProdutoUtilizado;
	}

	@Override
	public String toString() {
		return "EntidadeItemOrdemServico [codigoOrdemServico="
				+ codigoOrdemServico + ", codigoProduto=" + codigoProduto
				+ ", codigoServico=" + codigoServico + ", qtdProdutoUtilizado="
				+ qtdProdutoUtilizado + "]";
	}

}
