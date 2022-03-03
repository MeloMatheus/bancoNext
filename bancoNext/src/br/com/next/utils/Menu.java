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
		System.out.println("|           SERVIÇOS             |");
		System.out.println("==================================");
		System.out.println("| 1- Transações                  |");
		System.out.println("| 2- Área Pix                    |");
		System.out.println("| 3- Cartões                     |");
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
		System.out.println("| 2- Conta poupança              |");
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
		System.out.println("| 4- Aleatório                   |");
		System.out.println("| 5- Voltar                      |");
		System.out.println("==================================");
		
	}

	public void exibirMenuProsseguir() {

		System.out.println("==================================");
		System.out.println("| Deseja continuar?              |");
		System.out.println("|                                |");
		System.out.println("| 1- Sim                         |");
		System.out.println("| 2- Não                         |");
		System.out.println("==================================");
	}
		
	

	public void exibirOpcaoCataoOuConta() {
	
		System.out.println("==================================");
		System.out.println("| Deseja informar:               |");
		System.out.println("|                                |");
		System.out.println("| 1- Informar número da conta    |");
		System.out.println("| 2- Informar número do CPF      |");
		System.out.println("==================================");
		
	}

	public void acessarMenuTransacoes() {
		
		System.out.println("==================================");
		System.out.println("|           TRANSÇÕES            |");
		System.out.println("==================================");
		System.out.println("| 1- Depositar dinheiro          |");
		System.out.println("| 2- Transferir dinheiro         |");
		System.out.println("| 3- Voltar                      |");
		System.out.println("==================================");
		
	}
	
	public void acessarAreaPix() {
		System.out.println("==================================");
		System.out.println("|           ÁREA PIX             |");
		System.out.println("==================================");
		System.out.println("| 1- Cadastrar PIX               |");
		System.out.println("| 2- Transferir PIX              |");
		System.out.println("| 3- Voltar                      |");
		System.out.println("==================================");
	}
	
	//ALTERAR MENU
	public void exibirCartoes() {
		System.out.println("==================================");
		System.out.println("|            CARTÕES             |");
		System.out.println("==================================");
		System.out.println("| 1- Cartão de crédito           |");
		System.out.println("| 2- Cartão de débito            |");
		System.out.println("| 3- Crédito/ Débito             |");
		System.out.println("| 4- Voltar                      |");
		System.out.println("==================================");
		
	}
	
	public void acessarDebito() {
		System.out.println("==================================");
		System.out.println("|             DÉBITO             |");
		System.out.println("==================================");
		System.out.println("| 1- Adicionar cartão de crédito |");
		System.out.println("| 2- Voltar                      |");
		System.out.println("==================================");
	}

	public void acessarCredito() {
		System.out.println("==================================");
		System.out.println("|            CRÉDITO             |");
		System.out.println("==================================");
		System.out.println("| 1- Adicionar cartão de crédito |");
		System.out.println("| 2- Desativar cartão de crédito |");
		System.out.println("| 3- Apólice                     |");
		System.out.println("| 4- Exibir Fatura               |");
		System.out.println("| 5- Pagar Fatura                |");
		System.out.println("| 6- Voltar                      |");
		System.out.println("==================================");
	}
	
	public void acessarApolice() {
		System.out.println("==================================");
		System.out.println("|            APOLICE             |");
		System.out.println("==================================");
		System.out.println("| 1- Contratar apólice           |");
		System.out.println("| 2- Resgatar apólice            |");
		System.out.println("| 3- Voltar                      |");
		System.out.println("==================================");
	}
	
	public void acessarCompras() {
		
		System.out.println("==================================");
		System.out.println("|            COMPRAS             |");
		System.out.println("==================================");
		System.out.println("| 1- Compras cartão de débito    |");
		System.out.println("| 2- Compras cartão de crédito   |");
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
