package br.com.next.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
	
	private String idConta;
	private String numeroConta;
	private double saldo;
	private Cliente cliente;
	private Pix pix;
	private TipoConta tipoConta;
	private Date data;
	private List<Cartao> cartoes;
	private Cartao cartao;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getIdConta() {
		return idConta;
	}
	public void setIdConta(String idConta) {
		this.idConta = idConta;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pix getPix() {
		return pix;
	}
	public void setPix(Pix pix) {
		this.pix = pix;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	public List<Cartao> getCartoes() {
		return cartoes;
	}
	public void addCartoes(Cartao cartao) {
		if(this.cartoes == null) {
			this.cartoes = new ArrayList<>();
		}
		
		this.cartoes.add(cartao);
	}
	public void alterarCartaoCredito(CartaoCredito cartaoCredito) {
		List<Cartao> lCartao = new ArrayList<Cartao>();
		for(Cartao cartao : this.cartoes) {
			
			if(cartao.getClass().getSimpleName().toLowerCase().contains("crédito")) {
				lCartao.add(cartaoCredito);
				
			}else {
				
				lCartao.add(cartao);
				
			}
			this.cartoes = lCartao;
		}
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
