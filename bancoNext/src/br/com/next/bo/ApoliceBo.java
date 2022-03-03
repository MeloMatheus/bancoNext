package br.com.next.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import br.com.next.beans.Apolice;
import br.com.next.beans.Seguro;
import br.com.next.utils.BancoDeDados;

public class ApoliceBo {

	public Apolice apolice;
	
	public void seguroMorte() {
		Seguro seguro = new Seguro();
		
		seguro.setId(UUID.randomUUID().toString());
		seguro.setNomeSeguro("Seguro Morte");
		seguro.setRegraSeguro("Regras do Seguro:"
				+ "\n"
				+ "\ni. Indenização por despesas médico-hospitalares, ou por perda parcial ou"
				+ "\ntotal do funcionamento dos membros ou órgãos;"
				+ "\n"
				+ "\nii. Reembolso de custos em diagnóstico de doenças graves, como infarto,"
				+ "\nacidente vascular cerebral e câncer;"
				+ "\n"
				+ "\niii. Assistência funeral, para você e a sua família."
				+ "\n"
				+ "\niv. O valor do seguro individual é de R$36,00 ao ano."
				+ "\n"
				+ "\n"
				+ "Todos os seguros garantem recuperação de 100% do valor "
				+ "\ninvestido pelo segurado."
				+ "\n"
				+ "\nPrazo de carência: 15 dias."
				+ "\n"
				+ "\nO valor só pode ser recuperado se o prazo de carência for cumprido.");
	}
	
	public void seguroInvalidez() {
		Seguro seguro = new Seguro();
		
		seguro.setId(UUID.randomUUID().toString());
		seguro.setNomeSeguro("Seguro Invalidez");
		seguro.setRegraSeguro("Regras do Seguro: "
				+ "\n"
				+ "\ni. Invalidez parcial: ocorre quando há uma perda parcial das funções."
				+ "\nPor exemplo, uma pessoa que sofre um acidente e perda a visão em um só"
				+ "\ndos olhos."
				+ "\n"
				+ "\nii. Invalidez total: ocorre quando há uma perda total das funções."
				+ "\n"
				+ "\nIntuitivamente, um bom exemplo seria o caso onde a pessoa sofre um"
				+ "\nacidente e perde a visão em ambos os olhos."
				+ "\n"
				+ "\niii. O valor do seguro individual é de R$26,00 ao ano."
				+ "\n"
				+ "Todos os seguros garantem recuperação de 100% do valor "
				+ "\ninvestido pelo segurado."
				+ "\n"
				+ "\nPrazo de carência: 15 dias."
				+ "\n"
				+ "\nO valor só pode ser recuperado se o prazo de carência for cumprido.");
		
	}
	
	public void seguroDesemprego() {
		Seguro seguro = new Seguro();
		
		seguro.setId(UUID.randomUUID().toString());
		seguro.setNomeSeguro("Seguro Desemprego");
		seguro.setRegraSeguro("Regras do Seguro: "
				+ "\ni. Necessário trabalhar com registro CLT, com o tempo mínimo de"
				+ "\nestabilidade de 12 meses."
				+ "\n"
				+ "\nii. Válido apenas para desligamento involuntários e sem justa causa."
				+ "\n"
				+ "\niii. Não é valido em caso de demissão em massa (10% ou mais de"
				+ "\ndemissões simultâneas) ou falência/encerramento das atividades."
				+ "\n"
				+ "\niv. O valor do seguro individual é de R$16,00 ao ano."
				+ "\n"
				+ "Todos os seguros garantem recuperação de 100% do valor "
				+ "\ninvestido pelo segurado."
				+ "\n"
				+ "\nPrazo de carência: 15 dias."
				+ "\n"
				+ "\nO valor só pode ser recuperado se o prazo de carência for cumprido.");
	}

	public void contratarSeguroMorte(int tempoContratato) {
		
		apolice.setDataAssinatura(apolice.getDataAtual());
		
		//Gerar data de carencia aqui
		
		apolice.setValorApolice(tempoContratato * 36);
		
	}
	
public void contratarSeguroInvalidez(int tempoContratato) {
		
		apolice.setDataAssinatura(apolice.getDataAtual());
		
		//Gerar data de carencia aqui
		
		apolice.setValorApolice(tempoContratato * 26);
		
		
		
	}

public void contratarSeguroDesemprego(int tempoContratato) {
	
	apolice.setDataAssinatura(apolice.getDataAtual());
	
	//Gerar data de carencia aqui
	
	apolice.setValorApolice(tempoContratato * 16);
	
}
	
}
