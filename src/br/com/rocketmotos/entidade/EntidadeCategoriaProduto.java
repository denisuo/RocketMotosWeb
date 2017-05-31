package br.com.rocketmotos.entidade;

public class EntidadeCategoriaProduto {

	public static final String NM_ENTIDADE = EntidadeCategoriaProduto.class
			.getSimpleName();
	public static final String NM_TABELA = "CATEGORIA_PRODUTO";

	public static final String NM_COL_CodigoCategoriaProduto = "CATEGORIA_CD";
	public static final String NM_COL_Nome = "CATEGORIA_NOME";
	public static final String NM_COL_Descricao = "CATEGORIA_DESCRICAO";

	private int codigo;
	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "EntidadeCategoriaProduto [codigo=" + codigo + ", nome=" + nome
				+ ", descricao=" + descricao + "]";
	}

}
