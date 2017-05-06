package br.com.rocketmotos.entidade;

public abstract class EntidadeCliente {

	private String documento;
	private String nome;
	private String endereco;
	private String telefone;
	private String tipoCliente;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public abstract Double getDesconto();

	@Override
	public String toString() {
		return "EntidadeCliente [documento=" + documento + ", nome=" + nome
				+ ", endereco=" + endereco + ", telefone=" + telefone
				+ ", tipoCliente=" + tipoCliente + "]";
	}

}
