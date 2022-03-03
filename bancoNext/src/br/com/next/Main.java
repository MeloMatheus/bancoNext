package br.com.next;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import br.com.next.beans.Bandeira;
import br.com.next.beans.Cartao;
import br.com.next.beans.CartaoCredito;
import br.com.next.beans.CartaoDebito;
import br.com.next.beans.Cliente;
import br.com.next.beans.Conta;
import br.com.next.beans.Endereco;
import br.com.next.beans.Pix;
import br.com.next.beans.TipoChavePix;
import br.com.next.beans.TipoCliente;
import br.com.next.beans.TipoConta;
import br.com.next.bo.ApoliceBo;
import br.com.next.bo.ClienteBo;
import br.com.next.bo.ContaBo;
import br.com.next.utils.BancoDeDados;
import br.com.next.utils.Menu;


public class Main {
		
	public static Map<String, Cliente> mapCliente = new HashMap<String, Cliente>();
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		
		
		Menu menu = new Menu();
		
		int opcao =-1;
		
		while(opcao != 3) {
			//MENU PRINCIPAL
			menu.exibirMenu();
			opcao = s.nextInt();
			//CADASTRAR NOVO CLIENTE
			if(opcao == 1) {
				Cliente cliente = Main.cadastrarCliente(s);
				
				if(cliente == null) {
					continue;
				}
				
				menu.exibirMenuConta();
				int opcaoConta = s.nextInt();
				
				String cpf = cliente.getCpf();
				
				List<Conta> lConta = BancoDeDados.buscarContaPorCliente(cpf);
				for(Conta conta: lConta) {
					if(opcaoConta == conta.getTipoConta().getId()) {
						System.out.println("Conta existente!");
						continue;
					}
				}
				//TIPO DE CONTA E CADASTRO DE CLIENTE
				if(opcaoConta == 1) {
					new ContaBo(cliente, TipoConta.CORRENTE);
				}else if(opcaoConta == 2) {
					new ContaBo(cliente, TipoConta.POUPANCA);
				}
			
				//ACESSAR CONTA
			}else if(opcao == 2) {
				
			//TELA DE LOGIN
				
			//FAZER A TELA DE LOGIN	
				
				
				//MENU DE SERVIÇOS
				menu.exibirMenuServicos();
				int opcaoServicos = s.nextInt();
				//TRANSÇÕES
				if(opcaoServicos == 1) {
					
					//MENU TRANSAÇOES
					menu.acessarMenuTransacoes();
					int opcaoTransacao = s.nextInt();
					
					//DEPOSITAR
					if(opcaoTransacao == 1) {
						s.nextLine();
						System.out.println("Qual conta deseja depositar: ");
						String numeroConta = s.nextLine();
						
						Conta conta = BancoDeDados.buscaContaPorNumero(numeroConta);
						
						while(numeroConta == null) {
							System.out.println("Qual conta deseja depositar: ");
							numeroConta = s.nextLine();
						}
						
						System.out.println("Qual valor deseja depositar: ");
						double valor = s.nextDouble();
						
						ContaBo contaBo = new ContaBo(conta);
						
						contaBo.depositar(valor);
						
						continue;
						
						//TRANSFERIR
					}else if(opcaoTransacao == 2) {
						s.nextLine();
						System.out.println("Qual conta deseja transfeir: ");
						String numeroContaRecebe = s.nextLine();
						
						Conta contaRecebe = BancoDeDados.buscaContaPorNumero(numeroContaRecebe);
						
						if(contaRecebe == null) {
							continue;
						}
						
						System.out.println("Qual a sua conta: ");
						String numeroContaEnvia = s.nextLine();
						Conta contaEnvia = BancoDeDados.buscaContaPorNumero(numeroContaEnvia);
						
						if(contaEnvia == null) {
							continue;
						}
						System.out.println("Qual o valor deseja transferir: ");
						double valor = s.nextDouble();
						
						ContaBo contaBo = new ContaBo(contaEnvia);
						
						contaBo.transferir(contaRecebe, contaEnvia, valor);
						
						System.out.println("Transferencia realizada com sucesso!");
						continue;
						
						//VOLTAR
				}else if(opcaoTransacao == 3) {
					continue;
				}
					//AREA PIX
				}else if(opcaoServicos == 2) {
					
					menu.acessarAreaPix();
					int opcaoAreaPix = s.nextInt();
					
					//CADASTRAR PIX
					if(opcaoAreaPix == 1) {
						
						s.nextLine();
						System.out.println("Qual o numero da conta: ");
						String numeroConta = s.nextLine();
						
						Conta conta = BancoDeDados.buscaContaPorNumero(numeroConta);
						
						if(numeroConta == null) {
							continue;		
						}
						
						menu.acessarCadastrarPix();
						int tipoPix = s.nextInt();
						
						String chavePix = " ";
						
						TipoChavePix tcp = null;
						
						if(tipoPix == 4 ) {
							
							chavePix = UUID.randomUUID().toString();
							tcp = TipoChavePix.ALEATORIO;
							System.out.println("Cadastro realizado com sucesso!");
							System.out.println("Chave Pix: " + chavePix);
						} else { 
							
							System.out.println("Informe a chave: ");
							chavePix = s.next();
						}
						
						Pix pix = new Pix();
						
						pix.setAtivo(true);
						pix.setChave(chavePix);
						
						if(tipoPix == 1) {
							tcp = TipoChavePix.CPF;
						}else if(tipoPix == 2) {
							tcp = TipoChavePix.EMAIL;
						}else if(tipoPix == 3) {
							tcp = TipoChavePix.TELEFONE;
						}
						pix.setTipoChavePix(tcp);
						
						ContaBo contaBo = new ContaBo(conta);
						contaBo.adicionaPix(pix);
						
						//TRANSFERIR PIX
					}else if(opcaoAreaPix == 2) {
						
						s.nextLine();
						System.out.println("Qual a sua conta: ");
						String numeroContaEnvia = s.nextLine();
						
						Conta conta = BancoDeDados.buscaContaPorNumero(numeroContaEnvia);
						
						if(conta == null) {
							System.out.println("Conta não encontrada!");
							continue;
						}
						
						System.out.println("Informe a chave pix: ");
						String chavePix = s.next();
						
						Conta contaRecebe = BancoDeDados.getContaPix(chavePix);
						
						if(contaRecebe == null) {
							System.out.println("Chave pix inválida!");
							continue;
						}
						
						System.out.println("Qual valor deseja transferir: ");
						double valor = s.nextDouble();
						
						ContaBo contaBo = new ContaBo(conta);
						contaBo.transferir(contaRecebe, conta, valor);
						
						//VOLTAR
					}else if(opcaoAreaPix == 3) {
						continue;
					}
					
					//CARTÕES
				}else if(opcaoServicos == 3) {
					
					
					menu.exibirCartoes();
					int opcaoCartoes = s.nextInt();
					
					
					//CARTÃO DE CRÉDITO
					if(opcaoCartoes == 1) {
						
						menu.acessarCredito();
						int opcaoCredito = s.nextInt();
						
						//ADICIONAR CARTÃO DE CRÉDITO
						if(opcaoCredito == 1) {
							s.nextLine();
							System.out.println("Qual a sua conta: ");
							String numeroConta = s.nextLine();
							
							Conta conta = BancoDeDados.buscaContaPorNumero(numeroConta);
							
							if(conta == null) {
								System.out.println("Conta não encontrada!");
								continue;
							}
							
							TipoCliente tipoCliente = conta.getCliente().getTipoCliente();
							
							double limite = 0;
							
							if(tipoCliente == TipoCliente.COMUM) {
								
								limite = 1000;
								
							}else if(tipoCliente == TipoCliente.PREMIUM) {
								
								limite = 3000;
				
							}else if(tipoCliente == TipoCliente.SUPER) {
								limite = 12000;
							}
							
							System.out.println("Limite do cartão é: " + limite + " reais.");
							menu.exibirMenuProsseguir();
							
							int opcaoProsseguir = s.nextInt();
							
							if(opcaoProsseguir == 1) {
								
								String numero = UUID.randomUUID().toString();
								
								Bandeira bandeira = null;
								
								menu.exibirTipoBandeira();
								int tb = s.nextInt();
								
								if(tb == 1) {
									bandeira = Bandeira.MASTERCARD;
								}else if(tb == 2) {
									bandeira = Bandeira.VISA;
								}else if(tb == 3) {
									bandeira = Bandeira.ELO;
								}
								
								s.nextLine();
								System.out.println("Informe a senha do cartão: ");
								String senha = s.nextLine();
								
								
								CartaoCredito cartaoCredito = new CartaoCredito(numero, bandeira, senha, true, limite);
								
								ContaBo contaBo = new ContaBo(conta);
								
								contaBo.adicionarCartao(cartaoCredito);
							}
							
							//DESATIVAR CARTÃO DE CRÉDITO
						}else if(opcaoCredito == 2) {
							
							System.out.println("Qual conta deseja desativar: ");
							String nConta = s.nextLine();
							
							Conta conta = BancoDeDados.buscarContaPorNumeroCartao(nConta);
							
							if(conta == null) {
								System.out.println("Conta não encontrada!");
								continue;
							}
							
							ContaBo contaBo = new ContaBo(conta);
							
							contaBo.desativarCartao(conta);
						
							//ACESSAR APÓLICE
						}else if(opcaoCredito == 3) {
							menu.acessarApolice();
							int opcaoApolice = s.nextInt();
							
							//CONTRATAR SEGUROS
							if(opcaoApolice == 1) {
								
								//MENU SEGUROS
								menu.acessarSeguros();
								int opcaoSeguros = s.nextInt();
								
								//SEGURO MORTE 
								if(opcaoSeguros == 1) {
									ApoliceBo apoliceBo = new ApoliceBo();
									
									apoliceBo.seguroMorte();
									
									System.out.println("Quantos anos deseja contratar: ");
									int tempoContrato = s.nextInt();
									
									s.nextLine();
									System.out.println("Por qual número de cartão de crédito deseja contratar? ");
									String nCartao = s.nextLine();
									
									Conta conta = BancoDeDados.buscarContaPorNumeroCartao(nCartao);
									
									if(conta == null) {
										continue;
									}
									
									ContaBo contaBo = new ContaBo(conta);
									
									apoliceBo.contratarSeguroMorte(tempoContrato);
									
									List<Cartao> lCartao = conta.getCartoes();
									
										for(Cartao cartao : lCartao) {
											
											if(cartao.getClass().getSimpleName().toLowerCase().contains("crédito")) {
												
												contaBo.pagarSeguroMorte(cartao);
											}
										}
									
									
									
									
							}   //SEGURO INVALIDEZ
								else if(opcaoSeguros == 2){
									ApoliceBo apoliceBo = new ApoliceBo();
									
									apoliceBo.seguroInvalidez();
									
									System.out.println("Quantos anos deseja contratar: ");
									int tempoContrato = s.nextInt();
									
									System.out.println("Por qual número de cartão de crédito deseja contratar? ");
									String nCartao = s.nextLine();
									
									Conta conta = BancoDeDados.buscarContaPorNumeroCartao(nCartao);
									
									if(conta == null) {
										continue;
									}
									
									apoliceBo.contratarSeguroInvalidez(tempoContrato);
									
									ContaBo contaBo = new ContaBo(conta);
									
									List<Cartao> lCartao = conta.getCartoes();
									
										for(Cartao cartao : lCartao) {
											
											if(cartao.getClass().getSimpleName().toLowerCase().contains("crédito")) {
												
												contaBo.pagarSeguroMorte(cartao);
											}
										}
									
									}
									//SEGURO DESEMPREGO
									else if(opcaoSeguros == 3) {
										ApoliceBo apoliceBo = new ApoliceBo();
										
										apoliceBo.seguroDesemprego();
										
										System.out.println("Quantos anos deseja contratar: ");
										int tempoContrato = s.nextInt();
										
										System.out.println("Por qual número de cartão de crédito deseja contratar? ");
										String nCartao = s.nextLine();
										
										Conta conta = BancoDeDados.buscarContaPorNumeroCartao(nCartao);
										
										if(conta == null) {
											continue;
										}
										
										apoliceBo.contratarSeguroDesemprego(tempoContrato);
										

										apoliceBo.contratarSeguroMorte(tempoContrato);
										
										ContaBo contaBo = new ContaBo(conta);
										
										List<Cartao> lCartao = conta.getCartoes();
										
											for(Cartao cartao : lCartao) {
												
												if(cartao.getClass().getSimpleName().toLowerCase().contains("crédito")) {
													
													contaBo.pagarSeguroMorte(cartao);
												}
											}
									}
									//VOLTAR
									else if(opcaoSeguros == 4) {
										continue;
									}
								}
							//RECUPERAR APÓLICE
							else if(opcaoApolice == 2) {
									System.out.println("Em contrução!!");
								}
									
							//VOLTAR
							else if(opcaoApolice == 3) {
							continue;	
						}
					}   //EXIBIR FATURA
						else if(opcaoCredito == 4){
							
							Conta conta = new Conta();
							menu.exibirOpcaoCataoOuConta();
							int opcaoAcesso = s.nextInt();
							
							if(opcaoAcesso == 1) {
								s.nextLine();
								System.out.println("Qual a sua conta: ");
								String nConta = s.nextLine();
								
								conta = BancoDeDados.buscaContaPorNumero(nConta);
								
							}else if(opcaoAcesso == 2) {
								s.nextLine();
								System.out.println("Qual o número do cartão: ");
								String nCartao = s.nextLine();
								
								conta = BancoDeDados.buscarContaPorNumeroCartao(nCartao);
								}
							if(conta == null) {
								System.out.println("Cartão não encontrado!");
								continue;
							}
							List<Cartao> lCartao = conta.getCartoes();
							
							if(lCartao != null) {
								boolean encontrouCartaoDeCredito = false;
								for(Cartao cartao : lCartao) {
									
									if(cartao.getClass().getSimpleName().toLowerCase().contains("crédito")) {
										encontrouCartaoDeCredito = true;
										
										ContaBo contaBo = new ContaBo(conta);
										contaBo.exibirFatura(cartao);
										
									}
							}
								if(encontrouCartaoDeCredito == false) {
									System.out.println("Nenhum cartão de crédito encontrado!");
								}
							}
						}
						//PAGAR FATURA
						else if(opcaoCredito == 5) {
							
							System.out.println("Qual o cartao deseja pagar a fatura: ");
							String nCartao = s.nextLine();
							
							Conta conta = BancoDeDados.buscarContaPorNumeroCartao(nCartao);
							
							if(conta == null) {
								continue;
							}
							
							ContaBo contaBo = new ContaBo(conta);
							
							List<Cartao> lCartao = conta.getCartoes();
							
							for(Cartao cartao : lCartao) {
								contaBo.pagarFaturaCartaoCredito(cartao);
							}
							
							
						} //VOLTAR
						else if(opcaoCredito == 6) {
							continue;
						}
									
						//CARTÃO DE DEBITO
					}else if(opcaoCartoes == 2) {
						
						menu.acessarDebito();
						int opcaoDebito = s.nextInt();
						
						//ADICIONAR CARTÃO DE DEBITO
						if(opcaoDebito == 1) {

							s.nextLine();
							System.out.println("Qual a sua conta: ");
							String numeroConta = s.nextLine();
							
							Conta conta = BancoDeDados.buscaContaPorNumero(numeroConta);
							
							if(conta == null) {
								System.out.println("Conta não encontrada!");
								continue;
							}
							
							String nCartao = UUID.randomUUID().toString();
							
							System.out.println("Informe seu limite de transação: ");
							double limite = s.nextDouble();
							
							Bandeira bandeira = null;
							
							menu.exibirTipoBandeira();
							int tb = s.nextInt();
							
							if(tb == 1) {
								bandeira = Bandeira.MASTERCARD;
							}else if(tb == 2) {
								bandeira = Bandeira.VISA;
							}else if(tb == 3) {
								bandeira = Bandeira.ELO;
							}
							
							System.out.println("Qual a senha do cartão: ");
							String senha = s.nextLine();
							
							CartaoDebito cartaoDebito = new CartaoDebito(nCartao, bandeira, senha, true, limite);
							
							ContaBo contaBo = new ContaBo(conta);
							contaBo.adicionarCartao(cartaoDebito);
						}
						//VOLTAR
						else if(opcaoDebito == 2) {
							continue;
						}
				
						//DEBITO CREDITO
					}else if(opcaoCartoes == 3) {
						List<Conta> lConta = BancoDeDados.buscaTodasContas();
						
						for (Conta conta : lConta) {
							ContaBo contaBo = new ContaBo(conta);
							contaBo.debitoCredito();
						}
						//VOLTAR
					}else if(opcaoCartoes == 4) {
						continue;
					}
					
					
					
					//COMPRAS
				}else if(opcaoServicos == 4) {
					
					
					menu.acessarCompras();
					int opcaoCompra = s.nextInt();
					
					//COMPRA COM DÉBITO
					if(opcaoCompra == 1) {
						
						Conta conta = new Conta();
						menu.exibirOpcaoCataoOuConta();
						int opcaoAcesso = s.nextInt();
						
						if(opcaoAcesso == 1) {
							s.nextLine();
							System.out.println("Qual a sua conta: ");
							String nConta = s.nextLine();
							
							conta = BancoDeDados.buscaContaPorNumero(nConta);
							
						}else if(opcaoAcesso == 2) {
							s.nextLine();
							System.out.println("Qual o número do cartão: ");
							String nCartao = s.nextLine();
							
							conta = BancoDeDados.buscarContaPorNumeroCartao(nCartao);
							}
						if(conta == null) {
							System.out.println("Cartão não encontrado!");
							continue;
						}
						
						List<Cartao> lCartao = conta.getCartoes();
						
						if(lCartao != null) {
							boolean encontrouCartaoDebito = false;
							for(Cartao cartao : lCartao) {
								
								if(cartao.getClass().getSimpleName().toLowerCase().contains("debito")) {
									
									if(cartao.isAtivo()) {
										encontrouCartaoDebito = true;
										
										System.out.println("Qual o valor da compra: ");
										double valor = s.nextDouble();
										
										System.out.println("Senha do cartão: ");
										String senha = s.next();
										
										ContaBo contaBo = new ContaBo(conta);
										
										if(senha.equals(cartao.getSenha())) {
											contaBo.comprarComCartaoDeDebito(cartao, valor);
										}else {
											System.out.println("Senha incorreta!");
											
											while(!senha.equals(cartao.getSenha())){
												System.out.println("Insira sua senha novamente: ");
												senha = s.next();
											}
										}
									}else {
										System.out.println("Cartão não esta ativo.");
									}
								}
								if(encontrouCartaoDebito == false) {
									System.out.println("Não foi encontrado cartão de Débito");
								}
							}
						}else {
							
							System.out.println("Nenhum cartão encontrado");
							
						}
						
						//COMPRA COM CRÉDITO
					}else if(opcaoCompra == 2) {
						
						Conta conta = new Conta();
						menu.exibirOpcaoCataoOuConta();
						int opcaoAcesso = s.nextInt();
						
						if(opcaoAcesso == 1) {
							s.nextLine();
							System.out.println("Qual a sua conta: ");
							String nConta = s.nextLine();
							
							conta = BancoDeDados.buscaContaPorNumero(nConta);
							
						}else if(opcaoAcesso == 2) {
							s.nextLine();
							System.out.println("Qual o número do cartão: ");
							String nCartao = s.nextLine();
							
							conta = BancoDeDados.buscarContaPorNumeroCartao(nCartao);
							}
						if(conta == null) {
							System.out.println("Cartão não encontrado!");
							continue;
						}
						
						List<Cartao> lCartao = conta.getCartoes();
						
						if(lCartao != null) {
							boolean encontrouCartaoDeCredito = false;
							for(Cartao cartao : lCartao) {
								
								if(cartao.getClass().getSimpleName().toLowerCase().contains("crédito")) {
									if(cartao.isAtivo()) {
										encontrouCartaoDeCredito = true;
										
										System.out.println("Qual o valor da compra: ");
										double valor = s.nextDouble();
										
										ContaBo contaBo = new ContaBo(conta);
										
										System.out.println("Senha: ");
										String senha = s.next();
										
										if(senha.equals(cartao.getSenha())) {
											contaBo.compraComCartaoDeCredito(cartao, valor);
										}else {
											System.out.println("Senha incorreta!");
											
											while(!senha.equals(cartao.getSenha())) {
												System.out.println("Tente novamente: ");
												senha = s.next();
											}
										}
										
									}else {
										System.out.println("Cartão não está Ativado!");
									}
								}
								if(encontrouCartaoDeCredito = false) {
									System.out.println("Cartão de Crédito não encontrado");
								}
							}
							
						}else {
							
							System.out.println("Nenhum cartão encontrado!");
							
						}
						
						//VOLTAR
					}else if(opcaoCompra == 3) {
						continue;
					}
				}else if(opcaoServicos == 5) {
					
					s.nextLine();
					System.out.println("Qual o numero da conta deseja consultar: ");
					String numeroConta = s.nextLine();
					
					Conta conta = BancoDeDados.buscaContaPorNumero(numeroConta);
					
					if(numeroConta == null) {
						continue;		
					}
					
					ContaBo contaBo = new ContaBo(conta);
					
					contaBo.consultarSaldo();
				}else if(opcaoServicos == 6) {
					continue;
				}
				
			}else if (opcao == 3){
				
				System.out.println("Sisteme encerrado! ");
				System.exit(0);
				
			}
		}
	}
	public static Cliente cadastrarCliente(Scanner s) {
		ClienteBo clienteBo = new ClienteBo();
		Endereco endereco = new Endereco();
		
		s.nextLine();
		System.out.println("Qual o seu logradouro: ");
		String logradouro = s.nextLine();
		
		System.out.println("Qual o numero: ");
		String numero = s.nextLine();
		
		System.out.println("Qual o CEP: ");
		String cep = s.nextLine();
		
		System.out.println("Qual o bairro:");
		String bairro = s.nextLine();
		
		System.out.println("Qual a sua cidade: ");
		String cidade = s.nextLine();
		
		System.out.println("Qual o seu estado: ");
		String estado = s.nextLine();
		
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		
		System.out.println("Qual o nome do cliente: ");
		String nome = s.nextLine();
		
		System.out.println("Qual o seu cpf: ");
		String cpf = s.nextLine();
		
		while(clienteBo.validaCpf(cpf) == false) {
			
			System.out.print("Digite o cpf: ");
			cpf = s.nextLine();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Digite a sua data de nascimento (dd/mm/yyyy): ");
		String data = s.nextLine();
		
		System.out.println("Qual a senha da sua conta: ");
		String senhaConta = s.nextLine();
		
		try {
			Date dataNascimento = sdf.parse(data);
			
			return clienteBo.cadastrarCliente(cpf, nome, dataNascimento, endereco, senhaConta);
		}catch (ParseException e){
			System.out.println("Cliente não cadastrado!");
			return null;
		}
		
		
	}
	
}



