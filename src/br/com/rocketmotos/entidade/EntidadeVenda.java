package br.com.rocketmotos.entidade;

import java.sql.Date;

public class EntidadeVenda {

	public static final String NM_ENTIDADE = EntidadeVenda.class
			.getSimpleName();
	public static final String NM_TABELA = "VENDA";

	public static final String NM_COL_CodigoVenda = "VENDA_CD";
	public static final String NM_COL_NumeroDocumentoCliente = EntidadeCliente.NM_COL_NumeroDocumento;
	public static final String NM_COL_Data = "DATA";
	public static final String NM_COL_Valor = "VENDA_VALOR";
	public static final String NM_COL_TipoPagamento = "VENDA_TIPO";
	public static final String NM_COL_Desconto = "DESCONTO";

	private int codigo;
	private String documentoCliente;
	private Date data;
	private double valor;
	private String tipoPagamento; // débito ou crédito
	private Double desconto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return "EntidadeVenda [codigo=" + codigo + ", documentoCliente="
				+ documentoCliente + ", data=" + data + ", valor=" + valor
				+ ", tipoPagamento=" + tipoPagamento + ", desconto=" + desconto
				+ "]";
	}


}
