package br.com.next.beans;

import java.util.Date;

public class Cliente {
	private String idCliente;
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private Endereco endereco;
	private TipoCliente tipoCliente;
	private String senhaConta;
	
	
	public String getSenhaConta() {
		return senhaConta;
	}
	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipo) {
		this.tipoCliente = tipo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	

}
