package br.com.next.beans;

public class CartaoDebito extends Cartao {

	private double limite;
	
	public CartaoDebito(String nCartao, Bandeira bandeira, String senha, boolean isAtivo, double limite) {
		super(nCartao, bandeira, senha, isAtivo);
		
		this.limite = limite;
	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimitePorTransmissao(double limite) {
		this.limite = limite;
	}
	
}