package br.com.next.bo;

import java.util.Date;
import java.util.UUID;
import br.com.next.beans.Cliente;
import br.com.next.beans.Endereco;
import br.com.next.beans.TipoCliente;

public class ClienteBo {
	
	public Cliente cadastrarCliente(String cpf, String nome,Date dataNascimento, Endereco endereco, String senhaConta ) {
		
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(UUID.randomUUID().toString());
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		cliente.setEndereco(endereco);
		cliente.setTipoCliente(TipoCliente.COMUM);
		
		return cliente;
	}
	
	public boolean validaCpf(String cpf) {
		
		try {
			if(cpf.length() != 11 || !cpf.matches("[0-9]*")) {
				System.out.println("CPF inválido;");
				return false;
			} 
			return true;
		}catch(Exception e) {
			return true;
		}
	}
	
	public boolean acessaConta(String senhaAcesso, String cpfAcesso) {
		Cliente cliente = new Cliente();
		
		if(cpfAcesso.equals(cliente.getCpf())) {
			return true;
		}else {
			return false;
		}
	}
}
