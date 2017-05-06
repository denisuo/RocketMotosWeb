package br.com.rocketmotos.entidade;

public class EntidadeMoto {
	private String placa;
	private String ano;
	private String cor;
	private String documentoCliente;
	private int codigoModeloMoto;
	private int codigoMarcaMoto;

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

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public int getCodigoModeloMoto() {
		return codigoModeloMoto;
	}

	public void setCodigoModeloMoto(int codigoModeloMoto) {
		this.codigoModeloMoto = codigoModeloMoto;
	}

	public int getCodigoMarcaMoto() {
		return codigoMarcaMoto;
	}

	public void setCodigoMarcaMoto(int codigoMarcaMoto) {
		this.codigoMarcaMoto = codigoMarcaMoto;
	}

	@Override
	public String toString() {
		return "EntidadeMoto [placa=" + placa + ", ano=" + ano + ", cor=" + cor
				+ ", documentoCliente=" + documentoCliente
				+ ", codigoModeloMoto=" + codigoModeloMoto
				+ ", codigoMarcaMoto=" + codigoMarcaMoto + "]";
	}

}
