package model.entities;

import java.io.Serializable;

public class BaseProgramaComputadores implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String numeroDoRegistro;
	private String dataDoDeposito;
	private String linguagem;
	private String campoDeAplicacao;
	private String descricaoDoCampoDeAplicacao;
	private String tituloDoPrograma;
	private String tipoDePrograma;
	private String descricaoDoTipoDePrograma;
	private String nomeDoTitular;
	private String nomeDoAutor;
	private String nomeProcurador;
	private String numeroDaRPI;
	private String dataDaPublicacaoRPI;
	private String numeroDoDespacho;
	private String descricaoDoDespacho;
	private String complementoDoDespacho;
	private String dataDeLancamento;
	private String dataProtocoloExterno;
	private String codigoSigiloDoPrograma;
	private String cdRegistProgram;
	
	public BaseProgramaComputadores() {}
	public BaseProgramaComputadores(String numeroDoRegistro, String dataDoDeposito, String linguagem,
			String campoDeAplicacao, String descricaoDoCampoDeAplicacao, String tituloDoPrograma, String tipoDePrograma,
			String descricaoDoTipoDePrograma, String nomeDoTitular, String nomeDoAutor, String nomeProcurador,
			String numeroDaRPI, String dataDaPublicacaoRPI, String numeroDoDespacho, String descricaoDoDespacho,
			String complementoDoDespacho, String dataDeLancamento, String dataProtocoloExterno,
			String codigoSigiloDoPrograma) {
		this.numeroDoRegistro = numeroDoRegistro;
		this.dataDoDeposito = dataDoDeposito;
		this.linguagem = linguagem;
		this.campoDeAplicacao = campoDeAplicacao;
		this.descricaoDoCampoDeAplicacao = descricaoDoCampoDeAplicacao;
		this.tituloDoPrograma = tituloDoPrograma;
		this.tipoDePrograma = tipoDePrograma;
		this.descricaoDoTipoDePrograma = descricaoDoTipoDePrograma;
		this.nomeDoTitular = nomeDoTitular;
		this.nomeDoAutor = nomeDoAutor;
		this.nomeProcurador = nomeProcurador;
		this.numeroDaRPI = numeroDaRPI;
		this.dataDaPublicacaoRPI = dataDaPublicacaoRPI;
		this.numeroDoDespacho = numeroDoDespacho;
		this.descricaoDoDespacho = descricaoDoDespacho;
		this.complementoDoDespacho = complementoDoDespacho;
		this.dataDeLancamento = dataDeLancamento;
		this.dataProtocoloExterno = dataProtocoloExterno;
		this.codigoSigiloDoPrograma = codigoSigiloDoPrograma;
	}
	
	public String getNumeroDoRegistro() {
		return numeroDoRegistro;
	}
	public void setNumeroDoRegistro(String numeroDoRegistro) {
		this.numeroDoRegistro = numeroDoRegistro;
	}
	public String getDataDoDeposito() {
		return dataDoDeposito;
	}
	public void setDataDoDeposito(String dataDoDeposito) {
		this.dataDoDeposito = dataDoDeposito;
	}
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	public String getCampoDeAplicacao() {
		return campoDeAplicacao;
	}
	public void setCampoDeAplicacao(String campoDeAplicacao) {
		this.campoDeAplicacao = campoDeAplicacao;
	}
	public String getDescricaoDoCampoDeAplicacao() {
		return descricaoDoCampoDeAplicacao;
	}
	public void setDescricaoDoCampoDeAplicacao(String descricaoDoCampoDeAplicacao) {
		this.descricaoDoCampoDeAplicacao = descricaoDoCampoDeAplicacao;
	}
	public String getTituloDoPrograma() {
		return tituloDoPrograma;
	}
	public void setTituloDoPrograma(String tituloDoPrograma) {
		this.tituloDoPrograma = tituloDoPrograma;
	}
	public String getTipoDePrograma() {
		return tipoDePrograma;
	}
	public void setTipoDePrograma(String tipoDePrograma) {
		this.tipoDePrograma = tipoDePrograma;
	}
	public String getDescricaoDoTipoDePrograma() {
		return descricaoDoTipoDePrograma;
	}
	public void setDescricaoDoTipoDePrograma(String descricaoDoTipoDePrograma) {
		this.descricaoDoTipoDePrograma = descricaoDoTipoDePrograma;
	}
	public String getNomeDoTitular() {
		return nomeDoTitular;
	}
	public void setNomeDoTitular(String nomeDoTitular) {
		this.nomeDoTitular = nomeDoTitular;
	}
	public String getNomeDoAutor() {
		return nomeDoAutor;
	}
	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}
	public String getNomeProcurador() {
		return nomeProcurador;
	}
	public void setNomeProcurador(String nomeProcurador) {
		this.nomeProcurador = nomeProcurador;
	}
	public String getNumeroDaRPI() {
		return numeroDaRPI;
	}
	public void setNumeroDaRPI(String numeroDaRPI) {
		this.numeroDaRPI = numeroDaRPI;
	}
	public String getDataDaPublicacaoRPI() {
		return dataDaPublicacaoRPI;
	}
	public void setDataDaPublicacaoRPI(String dataDaPublicacaoRPI) {
		this.dataDaPublicacaoRPI = dataDaPublicacaoRPI;
	}
	public String getNumeroDoDespacho() {
		return numeroDoDespacho;
	}
	public void setNumeroDoDespacho(String numeroDoDespacho) {
		this.numeroDoDespacho = numeroDoDespacho;
	}
	public String getDescricaoDoDespacho() {
		return descricaoDoDespacho;
	}
	public void setDescricaoDoDespacho(String descricaoDoDespacho) {
		this.descricaoDoDespacho = descricaoDoDespacho;
	}
	public String getComplementoDoDespacho() {
		return complementoDoDespacho;
	}
	public void setComplementoDoDespacho(String complementoDoDespacho) {
		this.complementoDoDespacho = complementoDoDespacho;
	}
	public String getDataDeLancamento() {
		return dataDeLancamento;
	}
	public void setDataDeLancamento(String dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}
	public String getDataProtocoloExterno() {
		return dataProtocoloExterno;
	}
	public void setDataProtocoloExterno(String dataProtocoloExterno) {
		this.dataProtocoloExterno = dataProtocoloExterno;
	}
	public String getCodigoSigiloDoPrograma() {
		return codigoSigiloDoPrograma;
	}
	public void setCodigoSigiloDoPrograma(String codigoSigiloDoPrograma) {
		this.codigoSigiloDoPrograma = codigoSigiloDoPrograma;
	}

	public String getCdRegistProgram() {
		return cdRegistProgram;
	}
	public void setCdRegistProgram(String cdRegistProgram) {
		this.cdRegistProgram = cdRegistProgram;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campoDeAplicacao == null) ? 0 : campoDeAplicacao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseProgramaComputadores other = (BaseProgramaComputadores) obj;
		if (campoDeAplicacao == null) {
			if (other.campoDeAplicacao != null)
				return false;
		} else if (!campoDeAplicacao.equals(other.campoDeAplicacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseProgramaComputadores [numeroDoRegistro=" + numeroDoRegistro + ", dataDoDeposito=" + dataDoDeposito
				+ ", linguagem=" + linguagem + ", campoDeAplicacao=" + campoDeAplicacao
				+ ", descricaoDoCampoDeAplicacao=" + descricaoDoCampoDeAplicacao + ", tituloDoPrograma="
				+ tituloDoPrograma + ", tipoDePrograma=" + tipoDePrograma + ", descricaoDoTipoDePrograma="
				+ descricaoDoTipoDePrograma + ", nomeDoTitular=" + nomeDoTitular + ", nomeDoAutor=" + nomeDoAutor
				+ ", nomeProcurador=" + nomeProcurador + ", numeroDaRPI=" + numeroDaRPI + ", dataDaPublicacaoRPI="
				+ dataDaPublicacaoRPI + ", numeroDoDespacho=" + numeroDoDespacho + ", descricaoDoDespacho="
				+ descricaoDoDespacho + ", complementoDoDespacho=" + complementoDoDespacho + ", dataDeLancamento="
				+ dataDeLancamento + ", dataProtocoloExterno=" + dataProtocoloExterno + ", codigoSigiloDoPrograma="
				+ codigoSigiloDoPrograma + ", cdRegistProgram=" + cdRegistProgram + "]";
	}
	

}
