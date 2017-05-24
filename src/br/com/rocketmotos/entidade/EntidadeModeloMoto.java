package br.com.rocketmotos.entidade;

public class EntidadeModeloMoto {

	public static final String NM_ENTIDADE = EntidadeModeloMoto.class
			.getSimpleName();
	public static final String NM_TABELA = "MODELO_MOTO";

	public static final String NM_COL_CodigoModeloMoto = "MODELO_MOTO_CD";
	public static final String NM_COL_Nome = "NOME";
	public static final String NM_COL_CodigoMarcaMoto = EntidadeMarcaMoto.NM_COL_CodigoMarcaMoto;
	public static final String NM_COL_Cilindrada = "CILINDRADA";

	private int codigoModeloMoto;
	private String nome;
	private int codigoMarcaMoto;
	private String nomeMarcaMoto;
	private String cilindrada;

	public int getCodigoModeloMoto() {
		return codigoModeloMoto;
	}

	public void setCodigoModeloMoto(int codigo) {
		this.codigoModeloMoto = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoMarcaMoto() {
		return codigoMarcaMoto;
	}

	public void setCodigoMarcaMoto(int codigoMarcaMoto) {
		this.codigoMarcaMoto = codigoMarcaMoto;
	}

	public String getNomeMarcaMoto() {
		return nomeMarcaMoto;
	}

	public void setNomeMarcaMoto(String nomeMarcaMoto) {
		this.nomeMarcaMoto = nomeMarcaMoto;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "EntidadeModeloMoto [codigoModeloMoto=" + codigoModeloMoto
				+ ", nome=" + nome + ", codigoMarcaMoto=" + codigoMarcaMoto
				+ ", nomeMarcaMoto=" + nomeMarcaMoto + ", cilindrada="
				+ cilindrada + "]";
	}

}
