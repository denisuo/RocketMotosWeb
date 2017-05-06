package br.com.rocketmotos.entidade;

import java.sql.Date;

public class EntidadeOrdemServico {

	private int codigo;
	private String placaMoto;
	private Date data;
	private String indicadorOrcamento;
	private Double valor;
	private Double desconto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
		return "EntidadeOrdemServico [codigo=" + codigo + ", placaMoto=" + placaMoto
				+ ", data=" + data + ", indicadorOrcamento="
				+ indicadorOrcamento + ", valor=" + valor + ", desconto="
				+ desconto + "]";
	}

}
