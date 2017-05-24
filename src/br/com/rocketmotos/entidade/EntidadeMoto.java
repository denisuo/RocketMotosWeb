package br.com.rocketmotos.entidade;

public class EntidadeMoto {

	public static final String NM_ENTIDADE = EntidadeMoto.class.getSimpleName();
	public static final String NM_TABELA = "MOTO";

	public static final String NM_COL_PlacaMoto = "PLACA_MOTO";
	public static final String NM_COL_Ano = "ANO";
	public static final String NM_COL_Cor = "COR";
	public static final String NM_COL_NumeroDocumentoCliente = EntidadeCliente.NM_COL_NumeroDocumento;
	public static final String NM_COL_CodigoModeloMoto = EntidadeModeloMoto.NM_COL_CodigoModeloMoto;

	private String placa;
	private String ano;
	private String cor;
	private String numeroDocumentoCliente;
	private int codigoModeloMoto;
	private String nomeModeloMoto;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNumeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	public void setNumeroDocumentoCliente(String documentoCliente) {
		this.numeroDocumentoCliente = documentoCliente;
	}

	public int getCodigoModeloMoto() {
		return codigoModeloMoto;
	}

	public void setCodigoModeloMoto(int codigoModeloMoto) {
		this.codigoModeloMoto = codigoModeloMoto;
	}

	public String getNomeModeloMoto() {
		return nomeModeloMoto;
	}

	public void setNomeModeloMoto(String nomeModeloMoto) {
		this.nomeModeloMoto = nomeModeloMoto;
	}

	@Override
	public String toString() {
		return "EntidadeMoto [placa=" + placa + ", ano=" + ano + ", cor=" + cor
				+ ", numeroDocumentoCliente=" + numeroDocumentoCliente
				+ ", codigoModeloMoto=" + codigoModeloMoto
				+ ", nomeModeloMoto=" + nomeModeloMoto + "]";
	}

}
