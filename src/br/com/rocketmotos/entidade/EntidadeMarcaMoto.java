package br.com.rocketmotos.entidade;

public class EntidadeMarcaMoto {

	public static final String NM_ENTIDADE = EntidadeMarcaMoto.class
			.getSimpleName();
	public static final String NM_TABELA = "MARCA_MOTO";
	public static final String NM_COL_CodigoMarcaMoto = "MARCA_MOTO_CD";
	public static final String NM_COL_Nome = "NOME";

	private int codigo;
	private String nome;

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

	@Override
	public String toString() {
		return "EntidadeMarcaMoto [codigo=" + codigo + ", nome=" + nome + "]";
	}

	public static void main(String[] args) {
		System.out.println(EntidadeMarcaMoto.NM_ENTIDADE);
	}

}
