package br.com.next.utils;

public class Menu {
	
	public void exibirMenu() {
		System.out.println("==================================");
		System.out.println("|          BANCO NEXT            |");
		System.out.println("==================================");
		System.out.println("| 1- Cadastrar novo cliente      |");
		System.out.println("| 2- Acessar conta               |");
		System.out.println("| 3- Sair                        |");
		System.out.println("==================================");
		
		
	}
	
	public void exibirMenuServicos() {
		
		System.out.println("==================================");
		System.out.println("|           SERVI�OS             |");
		System.out.println("==================================");
		System.out.println("| 1- Transa��es                  |");
		System.out.println("| 2- �rea Pix                    |");
		System.out.println("| 3- Cart�es                     |");
		System.out.println("| 4- Compras                     |");
		System.out.println("| 5- Consultar saldo             |");
		System.out.println("| 6- Voltar                      |");
		System.out.println("==================================");
		
		
		
	}
	
	public void exibirMenuConta() {
		
		System.out.println("==================================");
		System.out.println("|           TIPO CONTA           |");
		System.out.println("==================================");
		System.out.println("| Qual o tipo de conta :         |");
		System.out.println("|                                |");
		System.out.println("| 1- Conta corrente              |");
		System.out.println("| 2- Conta poupan�a              |");
		System.out.println("==================================");
	}

	public void acessarCadastrarPix() {
		
		System.out.println("==================================");
		System.out.println("|        CADASTRAR PIX           |");
		System.out.println("==================================");
		System.out.println("| Qual o tipo da chave PIX:      |");
		System.out.println("|                                |");
		System.out.println("| 1- CPF                         |");
		System.out.println("| 2- E-mail                      |");
		System.out.println("| 3- Telefone                    |");
		System.out.println("| 4- Aleat�rio                   |");
		System.out.println("| 5- Voltar                      |");
		System.out.println("==================================");
		
	}

	public void exibirMenuProsseguir() {

		System.out.println("==================================");
		System.out.println("| Deseja continuar?              |");
		System.out.println("|                                |");
		System.out.println("| 1- Sim                         |");
		System.out.println("| 2- N�o                         |");
		System.out.println("==================================");
	}
		
	

	public void exibirOpcaoCataoOuConta() {
	
		System.out.println("==================================");
		System.out.println("| Deseja informar:               |");
		System.out.println("|                                |");
		System.out.println("| 1- Informar n�mero da conta    |");
		System.out.println("| 2- Informar n�mero do CPF      |");
		System.out.println("==================================");
		
	}

	public void acessarMenuTransacoes() {
		
		System.out.println("==================================");
		System.out.println("|           TRANS��ES            |");
		System.out.println("==================================");
		System.out.println("| 1- Depositar dinheiro          |");
		System.out.println("| 2- Transferir dinheiro         |");
		System.out.println("| 3- Voltar                      |");
		System.out.println("==================================");
		
	}
	
	public void acessarAreaPix() {
		System.out.println("==================================");
		System.out.println("|           �REA PIX             |");
		System.out.println("==================================");
		System.out.println("| 1- Cadastrar PIX               |");
		System.out.println("| 2- Transferir PIX              |");
		System.out.println("| 3- Voltar                      |");
		System.out.println("==================================");
	}
	
	//ALTERAR MENU
	public void exibirCartoes() {
		System.out.println("==================================");
		System.out.println("|            CART�ES             |");
		System.out.println("==================================");
		System.out.println("| 1- Cart�o de cr�dito           |");
		System.out.println("| 2- Cart�o de d�bito            |");
		System.out.println("| 3- Cr�dito/ D�bito             |");
		System.out.println("| 4- Voltar                      |");
		System.out.println("==================================");
		
	}
	
	public void acessarDebito() {
		System.out.println("==================================");
		System.out.println("|             D�BITO             |");
		System.out.println("==================================");
		System.out.println("| 1- Adicionar cart�o de cr�dito |");
		System.out.println("| 2- Voltar                      |");
		System.out.println("==================================");
	}

	public void acessarCredito() {
		System.out.println("==================================");
		System.out.println("|            CR�DITO             |");
		System.out.println("==================================");
		System.out.println("| 1- Adicionar cart�o de cr�dito |");
		System.out.println("| 2- Desativar cart�o de cr�dito |");
		System.out.println("| 3- Ap�lice                     |");
		System.out.println("| 4- Exibir Fatura               |");
		System.out.println("| 5- Pagar Fatura                |");
		System.out.println("| 6- Voltar                      |");
		System.out.println("==================================");
	}
	
	public void acessarApolice() {
		System.out.println("==================================");
		System.out.println("|            APOLICE             |");
		System.out.println("==================================");
		System.out.println("| 1- Contratar ap�lice           |");
		System.out.println("| 2- Resgatar ap�lice            |");
		System.out.println("| 3- Voltar                      |");
		System.out.println("==================================");
	}
	
	public void acessarCompras() {
		
		System.out.println("==================================");
		System.out.println("|            COMPRAS             |");
		System.out.println("==================================");
		System.out.println("| 1- Compras cart�o de d�bito    |");
		System.out.println("| 2- Compras cart�o de cr�dito   |");
		System.out.println("| 3- Voltar                      |");
		System.out.println("==================================");
	}

	public void exibirTipoBandeira() {
		System.out.println("==================================");
		System.out.println("|         TIPO BANDEIRA          |");
		System.out.println("==================================");
		System.out.println("| 1- Mastercard                  |");
		System.out.println("| 2- VISA                        |");
		System.out.println("| 3- ELO                         |");
		System.out.println("==================================");
		
	}
	
	public void acessarSeguros() {
		System.out.println("==================================");
		System.out.println("|            SEGUROS             |");
		System.out.println("==================================");
		System.out.println("| 1- Morte                       |");
		System.out.println("| 2- Invalidez                   |");
		System.out.println("| 3- Desemprego                  |");
		System.out.println("| 4- Voltar                      |");
		System.out.println("==================================");
	}
}
