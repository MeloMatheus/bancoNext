package br.com.next.beans;

import java.util.UUID;

public abstract class Cartao {
	private String idCartao;
	private String nCartao;
	private Bandeira bandeira;
	private String senha;
	private boolean isAtivo;
	private CartaoCredito cartaoCredito;
	
	public Cartao(String nCartao, Bandeira bandeira, String senha, boolean isAtivo) {
		super();
		this.idCartao = UUID.randomUUID().toString();
		this.nCartao = nCartao;
		this.bandeira = bandeira;
		this.senha = senha;
		this.isAtivo = isAtivo;
	}
	public String getIdCartao() {
		return idCartao;
	}
	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}
	public String getnCartao() {
		return nCartao;
	}
	public void setnCartao(String nCartao) {
		this.nCartao = nCartao;
	}
	public Bandeira getBandeira() {
		return bandeira;
	}
	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return isAtivo;
	}
	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}
	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	
	
	
	

}
