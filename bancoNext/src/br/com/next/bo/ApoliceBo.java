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
				+ "\ni. Indeniza��o por despesas m�dico-hospitalares, ou por perda parcial ou"
				+ "\ntotal do funcionamento dos membros ou �rg�os;"
				+ "\n"
				+ "\nii. Reembolso de custos em diagn�stico de doen�as graves, como infarto,"
				+ "\nacidente vascular cerebral e c�ncer;"
				+ "\n"
				+ "\niii. Assist�ncia funeral, para voc� e a sua fam�lia."
				+ "\n"
				+ "\niv. O valor do seguro individual � de R$36,00 ao ano."
				+ "\n"
				+ "\n"
				+ "Todos os seguros garantem recupera��o de 100% do valor "
				+ "\ninvestido pelo segurado."
				+ "\n"
				+ "\nPrazo de car�ncia: 15 dias."
				+ "\n"
				+ "\nO valor s� pode ser recuperado se o prazo de car�ncia for cumprido.");
	}
	
	public void seguroInvalidez() {
		Seguro seguro = new Seguro();
		
		seguro.setId(UUID.randomUUID().toString());
		seguro.setNomeSeguro("Seguro Invalidez");
		seguro.setRegraSeguro("Regras do Seguro: "
				+ "\n"
				+ "\ni. Invalidez parcial: ocorre quando h� uma perda parcial das fun��es."
				+ "\nPor exemplo, uma pessoa que sofre um acidente e perda a vis�o em um s�"
				+ "\ndos olhos."
				+ "\n"
				+ "\nii. Invalidez total: ocorre quando h� uma perda total das fun��es."
				+ "\n"
				+ "\nIntuitivamente, um bom exemplo seria o caso onde a pessoa sofre um"
				+ "\nacidente e perde a vis�o em ambos os olhos."
				+ "\n"
				+ "\niii. O valor do seguro individual � de R$26,00 ao ano."
				+ "\n"
				+ "Todos os seguros garantem recupera��o de 100% do valor "
				+ "\ninvestido pelo segurado."
				+ "\n"
				+ "\nPrazo de car�ncia: 15 dias."
				+ "\n"
				+ "\nO valor s� pode ser recuperado se o prazo de car�ncia for cumprido.");
		
	}
	
	public void seguroDesemprego() {
		Seguro seguro = new Seguro();
		
		seguro.setId(UUID.randomUUID().toString());
		seguro.setNomeSeguro("Seguro Desemprego");
		seguro.setRegraSeguro("Regras do Seguro: "
				+ "\ni. Necess�rio trabalhar com registro CLT, com o tempo m�nimo de"
				+ "\nestabilidade de 12 meses."
				+ "\n"
				+ "\nii. V�lido apenas para desligamento involunt�rios e sem justa causa."
				+ "\n"
				+ "\niii. N�o � valido em caso de demiss�o em massa (10% ou mais de"
				+ "\ndemiss�es simult�neas) ou fal�ncia/encerramento das atividades."
				+ "\n"
				+ "\niv. O valor do seguro individual � de R$16,00 ao ano."
				+ "\n"
				+ "Todos os seguros garantem recupera��o de 100% do valor "
				+ "\ninvestido pelo segurado."
				+ "\n"
				+ "\nPrazo de car�ncia: 15 dias."
				+ "\n"
				+ "\nO valor s� pode ser recuperado se o prazo de car�ncia for cumprido.");
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
