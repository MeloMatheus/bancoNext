 package br.com.next.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.next.beans.Apolice;
import br.com.next.beans.Cartao;
import br.com.next.beans.Conta;
import br.com.next.beans.Pix;
import br.com.next.beans.Seguro;

public class BancoDeDados {
	
	private static Map<String, Conta> BANCO_DE_DADOS = new HashMap<String, Conta>();
	
	public static Conta buscaContaPorNumero(String numeroConta) {
		
		Conta conta = BancoDeDados.BANCO_DE_DADOS.get(numeroConta);
		
		if(conta == null) {
			System.out.println("Conta não encontrada");
			return null;
		}
		return conta;
	}
	
	public static void insereConta(String numeroConta, Conta conta) {
		
		BancoDeDados.BANCO_DE_DADOS.put(numeroConta, conta);
	}
	
	public static List<Conta> buscarContaPorCliente(String cpf){
		List<Conta> lConta = new ArrayList<Conta>();
		
		for(Map.Entry<String, Conta> mapaConta: BancoDeDados.BANCO_DE_DADOS.entrySet()) {
			Conta conta = mapaConta.getValue();
			if(mapaConta.getValue().getCliente().getCpf().equals(cpf)) {
				lConta.add(conta);
			}
		}
		return lConta;
	}
	
	public static List<Conta> buscaTodasContas(){
		List<Conta> lConta = new ArrayList<Conta>();
				
		for(Map.Entry<String, Conta> mapaConta: BancoDeDados.BANCO_DE_DADOS.entrySet()) {
			Conta conta = mapaConta.getValue();
			lConta.add(conta);
		}
		return lConta;
	}
	
	public static Conta getContaPix(String chave) {
		for(Map.Entry<String, Conta> mapaConta: BancoDeDados.BANCO_DE_DADOS.entrySet()) {
			Conta conta = mapaConta.getValue();
			
			Pix pix = conta.getPix();
			
			if(pix != null) {
				
				if(pix.getChave().equals(chave)){
					return conta;
				}
			}
		}
		return null;
	}
	
	public static Conta buscarContaPorNumeroCartao(String nCartao) {
		for(Map.Entry<String, Conta> mapaConta: BancoDeDados.BANCO_DE_DADOS.entrySet()) {
			Conta conta = mapaConta.getValue();
			
			List<Cartao> lCartao = conta.getCartoes();
			
			if(lCartao != null) {
				
				for(Cartao cartao : lCartao){
					if(cartao.getnCartao().equals(nCartao)) {
						return conta;
					}
				}
			}
		}
		return null;
	}
	
	//VALIDA SE O CPF ESTÁ OU NÃO NO BANCO DE DADOS
	public static boolean validaCpf(String cpf) {
		
		for(Map.Entry<String, Conta> mapeamentoConta : BancoDeDados.BANCO_DE_DADOS.entrySet()){
			Conta conta = mapeamentoConta.getValue();
			
			if(conta.getCliente().getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
	
}
