package br.com.next.beans;

public class Pix {
	
	private TipoChavePix tipoChavePix;
	private String chave;
	private boolean isAtivo;
	
	
	public TipoChavePix getTipoChavePix() {
		return tipoChavePix;
	}
	public void setTipoChavePix(TipoChavePix tipoChavePix) {
		this.tipoChavePix = tipoChavePix;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public boolean isAtivo() {
		return isAtivo;
	}
	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
	
	
}