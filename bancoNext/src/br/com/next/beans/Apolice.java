package br.com.next.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Apolice {
	
	private String id;
	private double valorApolice;
	private String descricaoCondicoes;
	private Date dataAssinatura;
	private Date dataCarencia;
	private Seguro seguro;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValorApolice() {
		return valorApolice;
	}

	public void setValorApolice(double valorApolice) {
		this.valorApolice = valorApolice;
	}

	public String getDescricaoCondicoes() {
		return descricaoCondicoes;
	}

	public void setDescricaoCondicoes(String descricaoCondicoes) {
		this.descricaoCondicoes = descricaoCondicoes;
	}

	public Date getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}
	public Date getDataAtual() {
		Calendar cal = Calendar.getInstance();
		
		Date data = cal.getTime();
		
		return data;
		
	}

	public Date getDataCarencia() {
		return dataCarencia;
	}

	public void setDataCarencia(Date dataCarencia) {
		this.dataCarencia = dataCarencia;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
}
