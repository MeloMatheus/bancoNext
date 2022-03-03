package br.com.next.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CartaoCredito extends Cartao {
	
	private double limite;
	private List<Compra> compra;
	private Date dataVencimento;
	private double valorFatura;
	private String id;
	private Apolice apolice;
	
	public CartaoCredito(String nCartao, Bandeira bandeira, String senha, boolean isAtivo, double limite) {
		super(nCartao, bandeira, senha, isAtivo);
		this.limite = limite;
		this.compra = new ArrayList<Compra>();
		this.dataVencimento = this.getDateAdd1Month();
		this.valorFatura = 0; 
		this.setId(UUID.randomUUID().toString());
	}
	
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public List<Compra> getCompra() {
		return compra;
	}
	public void addCompra(Compra compra) {
		this.compra.add(compra);
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public double getValorFatura() {
		return valorFatura;
	}
	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}
	public Date getDateAdd1Month() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		
		Date data = cal.getTime();
		
		return data;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Apolice getApolice() {
		return apolice;
	}

	public void setApolice(Apolice apolice) {
		this.apolice = apolice;
	}
	
	
	
	
	
}
