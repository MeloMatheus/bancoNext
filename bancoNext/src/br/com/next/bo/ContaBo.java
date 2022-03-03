package br.com.next.bo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.com.next.beans.Apolice;
import br.com.next.beans.Cartao;
import br.com.next.beans.CartaoCredito;
import br.com.next.beans.CartaoDebito;
import br.com.next.beans.Cliente;
import br.com.next.beans.Compra;
import br.com.next.beans.Conta;
import br.com.next.beans.Pix;
import br.com.next.beans.TipoCliente;
import br.com.next.beans.TipoConta;
import br.com.next.utils.BancoDeDados;

public class ContaBo {
	
	public Conta conta;
		
	
	public ContaBo(Conta conta) {
		this.conta = conta;
	}
	
	public ContaBo(Cliente cliente, TipoConta tipoConta) {
		this.conta = this.cadastrarConta(cliente, tipoConta);
	}                                                                                                                                                      
	
	public Date getDateAdd1Month() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		
		Date data = cal.getTime();
		
		return data;
		
	}
	public void debitoCredito() {
		
		if(this.conta.getData().before(new Date())) {
			
			if( this.conta.getTipoConta() == TipoConta.CORRENTE) {
				double valor = conta.getSaldo();
				valor -= valor * 0.45;
				
				this.conta.setSaldo(valor);
			}else {
				double valor = this.conta.getSaldo();
				valor = valor * 0.03;
				
				this.depositar(valor);
			}
			
			Date data = this.getDateAdd1Month();
			this.conta.setData(data);
			BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
			
		}
	}

	public Conta cadastrarConta(Cliente cliente, TipoConta tipoConta) {
		Conta conta = new Conta();
		
		conta.setIdConta(UUID.randomUUID().toString());
		conta.setNumeroConta(UUID.randomUUID().toString());
		conta.setCliente(cliente);
		conta.setSaldo(0.0);
		conta.setTipoConta(tipoConta);
		
		Date data = this.getDateAdd1Month();
		
		BancoDeDados.insereConta(conta.getNumeroConta(), conta);
		
		System.out.println("N conta: "+conta.getNumeroConta());
		
		return conta;
	
	}
	
	public boolean transferir(Conta contaRecebe,Conta contaEnvia,  double valor) {
		
		if(this.conta.getTipoConta() == TipoConta.CORRENTE && this.conta.getTipoConta().getId() != contaRecebe.getTipoConta().getId()) {
			
			double valorSaldo = this.conta.getSaldo();
			
			if(valorSaldo - 5.60 >- valor) {
				
				System.out.println("Saldo insulficiente!");
				return false;
			}
			valorSaldo -= 5.60;
			this.conta.setSaldo(valorSaldo);
		}
		
		if(conta.getSaldo() >= valor) {
			double meuSaldo = contaEnvia.getSaldo();
			meuSaldo = meuSaldo - valor;
			contaEnvia.setSaldo(meuSaldo);
			
			double saldoOutraConta = contaRecebe.getSaldo();
			saldoOutraConta = saldoOutraConta + valor;
			contaRecebe.setSaldo(saldoOutraConta);
			
			BancoDeDados.insereConta(contaRecebe.getNumeroConta(), contaRecebe);
			BancoDeDados.insereConta(contaEnvia.getNumeroConta(), contaEnvia);
			
			System.out.println("Transferência realizada!");
			return true;
		}
		System.out.println("Saldo insulficiente.");
		return false;
	}
	
	public void depositar(double valor) {
		
		double meuSaldo = this.conta.getSaldo();
		
		meuSaldo += valor;
		conta.setSaldo(meuSaldo);
		
		if(conta.getSaldo() <= 5000) {
			conta.getCliente().setTipoCliente(TipoCliente.COMUM);
		}else if(conta.getSaldo() >= 5000 && conta.getSaldo() <= 10000) {
			conta.getCliente().setTipoCliente(TipoCliente.PREMIUM);
		}else {
			conta.getCliente().setTipoCliente(TipoCliente.SUPER);
		}
		
		BancoDeDados.insereConta(conta.getNumeroConta(), conta);
		
	}
	
	public void consultarSaldo() {
		
		String nome = this.conta.getCliente().getNome();
		String cpf = this.conta.getCliente().getCpf();
		
		double valor = this.conta.getSaldo();
		
		System.out.println("O valor do cliente " + nome + " com o CPF " + cpf + ", tipo conta " + conta.getTipoConta() +" é: " + valor);
	}
	
	public void adicionaPix(Pix pix) {
		this.conta.setPix(pix);
		
		BancoDeDados.insereConta(conta.getNumeroConta(), conta);
		
	}

	public void adicionarCartao(Cartao cartao) {
		
		this.conta.addCartoes(cartao);
		
		System.out.println("Número cartão: " + cartao.getnCartao());
		
		BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
		
	}
	
	public void desativarCartao(Conta nConta) {
		
		if(conta.getCartao().getCartaoCredito().isAtivo() == true) {
			
			conta.getCartao().getCartaoCredito().setAtivo(false);
			conta.getCartao().getCartaoCredito().setLimite(0);
			
			
		}
		
	}
	public void pagarSeguroMorte(Cartao cartao) {
		Apolice apolice = new Apolice();
		CartaoCredito cartaoCredito = (CartaoCredito) cartao; 
		
		if(cartaoCredito.getLimite() >= apolice.getValorApolice()) {
			
			Compra compra = new Compra(new Date(), apolice.getValorApolice());
			cartaoCredito.addCompra(compra);
			double limite = cartaoCredito.getLimite();
			limite -= apolice.getValorApolice();
			cartaoCredito.setLimite(limite);
			
			double valorFatura = cartaoCredito.getValorFatura();
			valorFatura += apolice.getValorApolice();
			cartaoCredito.setValorFatura(valorFatura);
			
			
			this.conta.alterarCartaoCredito(cartaoCredito);
			
			BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
			
			System.out.println("Contratação realizada com sucesso!");
			
		}else {
			System.out.println("Contratação Recusada.");
		}
		
		
	}
	
	public void pagarSeguroInvalidez(Cartao cartao) {
		Apolice apolice = new Apolice();
		CartaoCredito cartaoCredito = (CartaoCredito) cartao; 
		
		if(cartaoCredito.getLimite() >= apolice.getValorApolice()) {
			
			Compra compra = new Compra(new Date(), apolice.getValorApolice());
			cartaoCredito.addCompra(compra);
			double limite = cartaoCredito.getLimite();
			limite -= apolice.getValorApolice();
			cartaoCredito.setLimite(limite);
			
			double valorFatura = cartaoCredito.getValorFatura();
			valorFatura += apolice.getValorApolice();
			cartaoCredito.setValorFatura(valorFatura);
			
			
			this.conta.alterarCartaoCredito(cartaoCredito);
			
			BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
			
			System.out.println("Contratação realizada com sucesso!");
			
		}else {
			System.out.println("Contratação Recusada.");
		}
	}
	
	public void pagarSeguroDesemprego(Cartao cartao) {
		Apolice apolice = new Apolice();
		CartaoCredito cartaoCredito = (CartaoCredito) cartao; 
		
		if(cartaoCredito.getLimite() >= apolice.getValorApolice()) {
			
			Compra compra = new Compra(new Date(), apolice.getValorApolice());
			cartaoCredito.addCompra(compra);
			double limite = cartaoCredito.getLimite();
			limite -= apolice.getValorApolice();
			cartaoCredito.setLimite(limite);
			
			double valorFatura = cartaoCredito.getValorFatura();
			valorFatura += apolice.getValorApolice();
			cartaoCredito.setValorFatura(valorFatura);
			
			
			this.conta.alterarCartaoCredito(cartaoCredito);
			
			BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
			
			System.out.println("Contratação realizada com sucesso!");
			
		}else {
			System.out.println("Contratação Recusada.");
		}
	}
	
	public void pagarFaturaCartaoCredito(Cartao cartao) {
		CartaoCredito cartaoCredito = (CartaoCredito) cartao;
		
		double valorFatura = cartaoCredito.getValorFatura();
		
		double saldoConta = this.conta.getSaldo();
		
		if(valorFatura <= saldoConta) {
			saldoConta -= valorFatura;
			this.conta.setSaldo(saldoConta);
			
			BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
			
			System.out.println("Compra realizada com sucesso!");
			
		}else {
			System.out.println("Saldo indulficiente para realizar a compra!");
		}
	}

	public void comprarComCartaoDeDebito(Cartao cartao, double valor) {
		
		CartaoDebito cartaoDebito = (CartaoDebito) cartao;
		
		if(cartaoDebito.getLimite() >= valor) {
			
			double saldoConta = this.conta.getSaldo();
			
			if(valor <= saldoConta) {
				saldoConta -= valor;
				this.conta.setSaldo(saldoConta);
				
				BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
				
				System.out.println("Compra realizada com sucesso!");
				
			}else {
				System.out.println("Saldo indulficiente para realizar a compra!");
			}
			
		}else {
			System.out.println("Limite de transação é menor que o valor");
		}
		
	}

	public void compraComCartaoDeCredito(Cartao cartao, double valor) {
		
		CartaoCredito cartaoCredito = (CartaoCredito) cartao; 
		
		if(cartaoCredito.getLimite() >= valor) {
			
			Compra compra = new Compra(new Date(), valor);
			cartaoCredito.addCompra(compra);
			double limite = cartaoCredito.getLimite();
			limite -= valor;
			cartaoCredito.setLimite(limite);
			
			double valorFatura = cartaoCredito.getValorFatura();
			valorFatura += valor;
			cartaoCredito.setValorFatura(valorFatura);
			
			
			this.conta.alterarCartaoCredito(cartaoCredito);
			
			BancoDeDados.insereConta(this.conta.getNumeroConta(), this.conta);
			
			System.out.println("Compra realizada com sucesso!");
			
		}else {
			System.out.println("Compra Recusada.");
		}
		
	}

	public void exibirFatura(Cartao cartao) {
		
		CartaoCredito cartaoCredito = (CartaoCredito) cartao;
		
		List<Compra> lCompra = cartaoCredito.getCompra();
		
		System.out.println("Seu limite é: " + cartaoCredito.getLimite());
		System.out.println("Valor da Fatura: " + cartaoCredito.getValorFatura());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String data = sdf.format(cartaoCredito.getDataVencimento());
		
		System.out.println("Data de vencimento: " + data);
		
		System.out.println("------------ COMPRAS ------------");
		
		SimpleDateFormat sdfComHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		for(Compra compra : lCompra) {
			String dataCompra = sdfComHora.format(compra.getData());
			double valor = compra.getValor();
			
			System.out.println("Compra do dia " + dataCompra + " no valor de " + valor);
		}
		System.out.println("------------ FIM ------------");
	}

	
}