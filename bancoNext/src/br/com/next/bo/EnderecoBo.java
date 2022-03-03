package br.com.next.bo;

import br.com.next.beans.Endereco;

public class EnderecoBo {
	
	public boolean exibirEndereco(String cep) {
		return false;
	}
	
	public Endereco cadastrarEndereco(String logradouro, String numero, String cep, String bairro, String cidade, String estado){
		Endereco endereco = new Endereco();
		
		endereco.setCep(cep);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		
		return endereco;
	}

}
