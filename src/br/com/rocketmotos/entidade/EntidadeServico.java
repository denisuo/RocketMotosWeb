package br.com.rocketmotos.entidade;

public class EntidadeServico {

	private int codigo;
	private String nome;
	private String descricao;
	private Double valor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "EntidadeServico [codigo=" + codigo + ", nome=" + nome
				+ ", descricao=" + descricao + ", valor=" + valor + "]";
	}

}
