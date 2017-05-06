package br.com.rocketmotos.entidade;

import java.sql.Date;

public class EntidadeProduto {

	private String codigo;
	private String nome;
	private String descricao;
	private Date validade;
	private int codigoCategoria;
	private Double valor;
	private int quantidade;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "EntidadeProduto [codigo=" + codigo + ", nome=" + nome
				+ ", descricao=" + descricao + ", validade=" + validade
				+ ", codigoCategoria=" + codigoCategoria + ", valor=" + valor
				+ ", quantidade=" + quantidade + "]";
	}

}
