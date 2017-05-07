package br.com.rocketmotos.entidade;

import java.sql.Date;

public class EntidadeProduto {

	public static final String NM_ENTIDADE = EntidadeProduto.class
			.getSimpleName();
	public static final String NM_TABELA = "PRODUTO";

	public static final String NM_COL_CodigoProduto = "PRODUTO_CD";
	public static final String NM_COL_Nome = "NOME";
	public static final String NM_COL_Descricao = "DESCRICAO";
	public static final String NM_COL_Validade = "VALIDADE";
	public static final String NM_COL_CodigoCategoriaProduto = EntidadeCategoriaProduto.NM_COL_CodigoCategoriaProduto;
	public static final String NM_COL_Valor = "VALOR";
	public static final String NM_COL_QtdEstoque = "QTD_ESTOQUE";

	private String codigoProduto;
	private String nome;
	private String descricao;
	private Date validade;
	private int codigoCategoria;
	private Double valor;
	private int quantidade;

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
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
		return "EntidadeProduto [codigoProduto=" + codigoProduto + ", nome="
				+ nome + ", descricao=" + descricao + ", validade=" + validade
				+ ", codigoCategoria=" + codigoCategoria + ", valor=" + valor
				+ ", quantidade=" + quantidade + "]";
	}

}
