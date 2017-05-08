package br.com.rocketmotos.entidade;

public class EntidadeServico {

	public static final String NM_ENTIDADE = EntidadeServico.class
			.getSimpleName();
	public static final String NM_TABELA = "SERVICO";

	public static final String NM_COL_CodigoServico = "SERVICO_CD";
	public static final String NM_COL_Nome = "NOME";
	public static final String NM_COL_Descricao = "DESCRICAO";
	public static final String NM_COL_Valor = "VALOR";

	private int codigoServico;
	private String nome;
	private String descricao;
	private Double valor;

	public int getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(int codigoServico) {
		this.codigoServico = codigoServico;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "EntidadeServico [codigoServico=" + codigoServico + ", nome="
				+ nome + ", descricao=" + descricao + ", valor=" + valor + "]";
	}

}
