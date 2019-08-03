// input.nextLine(); depois dos inputs de Ints.

package teste;
import java.util.Scanner;
import agenda.*;
import usuario.Usuarios;
import erros.*;

public class Teste {

	public static void main(String[] args) {
		int decisao = 0;
		boolean loop = true;
		int tipoDeUsuario;
		String mesSelecionado;
		int diaSelecionado; 
		
		Usuarios usuarios = new Usuarios();
		
		Agenda janeiro = new Agenda("Janeiro");
		Agenda fevereiro = new Agenda("Fevereiro");
		Agenda mar�o = new Agenda("Mar�o");
		Agenda abril = new Agenda("Abril");
		Agenda maio = new Agenda("Maio");
		Agenda junho = new Agenda("Junho");
		Agenda julho = new Agenda("Julho");
		Agenda agosto = new Agenda("Agosto");
		Agenda setembro = new Agenda("Setembro");
		Agenda outubro = new Agenda("Outubro");
		Agenda novembro = new Agenda("Novembro");
		Agenda dezembro = new Agenda("Dezembro");
		
		Scanner input = new Scanner(System.in);
		do {
		/*------------------------------------------------------------------------------------------*/
		System.out.println("Bem-vindo");
		do {
			try {
				System.out.println("O que gostaria de fazer? (1-Cadastrar/2-Login)");
				decisao = input.nextInt();
				input.nextLine();
				if(decisao != 1 && decisao != 2) {
					throw new OpcaoInvalida();
				}
				
				System.out.println("Voc� � um cliente ou um atendente? (1/2)");
				tipoDeUsuario = input.nextInt();
				input.nextLine();
				if(tipoDeUsuario != 1 && tipoDeUsuario != 2) {
					throw new OpcaoInvalida();
				}
				
				System.out.println("Digite o nome de usu�rio: ");
				String usuario = input.next();
				
				System.out.println("Digite a sua senha: ");
				String senha = input.next();
			
				if(decisao == 1) {
					if(tipoDeUsuario == 1) {
						usuarios.novoCliente(usuario, senha);
					} else if(tipoDeUsuario == 2) {
						usuarios.novoAtendente(usuario, senha);
					} else {
						throw new OpcaoInvalida();
					}
				} else if(decisao == 2) {
					if(tipoDeUsuario == 1) {
						usuarios.loginCliente(usuario, senha);
					} else if(tipoDeUsuario == 2) {
						usuarios.loginAtendente(usuario, senha);
					} else {
						throw new OpcaoInvalida();
					}
				} else {
					throw new OpcaoInvalida();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while(decisao != 2);
		/*------------------------------------------------------------------------------------------*/
		
		if(usuarios.getLogado() == 1) {
			System.out.println("Voc� est� logado!");
			
			//LOOP "MENU LOGADO"
			do {
				try { //<----------------------
					
					System.out.println("O que gostaria de fazer?");
					if(usuarios.getTipoDeUsuario().equals("Atendente")) {
						System.out.println("1- Verificar v�os dispon�veis");
						System.out.println("2- Criar um novo voo");
						System.out.println("3- Deletar um voo");
						System.out.println("4- Logout");
						decisao = input.nextInt();
						input.nextLine();
						
						switch(decisao) {
						
							//dado m�s, imprime os voos do m�s.
							case 1:
								System.out.println("Deseja imprimir os voos de qual m�s?");
								mesSelecionado = input.nextLine();
								
								switch(mesSelecionado) {
									case "Janeiro":
										janeiro.imprimeVoos();
										break;
									case "Fevereiro":
										fevereiro.imprimeVoos();
										break;
									case "Mar�o":
										mar�o.imprimeVoos();
										break;
									case "Abril":
										abril.imprimeVoos();
										break;
									case "Maio":
										maio.imprimeVoos();
										break;
									case "Junho":
										junho.imprimeVoos();
										break;
									case "Julho":
										julho.imprimeVoos();
										break;
									case "Agosto":
										agosto.imprimeVoos();
										break;
									case "Setembro":
										setembro.imprimeVoos();
										break;
									case "Outubro":
										outubro.imprimeVoos();
										break;
									case "Novembro":
										novembro.imprimeVoos();
										break;
									case "Dezembro":
										dezembro.imprimeVoos();
										break;
									default:
										throw new OpcaoInvalida();
								}
								break;			
							
							//Dado m�s e dia, checa se a data j� foi iniciada, cria a data se necess�rio e adiciona um voo na data.
							case 2:
								System.out.println("Em qual m�s voc� deseja criar um voo?");
								mesSelecionado = input.nextLine();
								
								System.out.println("Em qual dia?");
								diaSelecionado =  input.nextInt();
								input.nextLine();
								diaSelecionado--; //retificar data para ser usada como posi��o no vetor
								
								switch(mesSelecionado) {
									case "Janeiro":
										if (janeiro.datas[diaSelecionado].getStatus()) {
											janeiro.datas[diaSelecionado].adicionaVoo("Janeiro");
										} else {
											janeiro.datas[diaSelecionado] =  new Data(diaSelecionado);
											janeiro.datas[diaSelecionado].adicionaVoo("Janeiro");
										}
										break;
									case "Fevereiro":
										if (fevereiro.datas[diaSelecionado].getStatus()) {
											fevereiro.datas[diaSelecionado].adicionaVoo("Fevereiro");
										} else {
											fevereiro.datas[diaSelecionado] =  new Data(diaSelecionado);
											fevereiro.datas[diaSelecionado].adicionaVoo("Fevereiro");
										}
										break;
									case "Mar�o":
										if (mar�o.datas[diaSelecionado].getStatus()) {
											mar�o.datas[diaSelecionado].adicionaVoo("Mar�o");
										} else {
											mar�o.datas[diaSelecionado] =  new Data(diaSelecionado);
											mar�o.datas[diaSelecionado].adicionaVoo("Mar�o");
										}
										break;
									case "Abril":
										if (abril.datas[diaSelecionado].getStatus()) {
											abril.datas[diaSelecionado].adicionaVoo("Abril");
										} else {
											abril.datas[diaSelecionado] =  new Data(diaSelecionado);
											abril.datas[diaSelecionado].adicionaVoo("Abril");
										}
										break;
									case "Maio":
										if (maio.datas[diaSelecionado].getStatus()) {
											maio.datas[diaSelecionado].adicionaVoo("Maio");
										} else {
											maio.datas[diaSelecionado] =  new Data(diaSelecionado);
											maio.datas[diaSelecionado].adicionaVoo("Maio");
										}
										break;
									case "Junho":
										if (junho.datas[diaSelecionado].getStatus()) {
											junho.datas[diaSelecionado].adicionaVoo("Junho");
										} else {
											junho.datas[diaSelecionado] =  new Data(diaSelecionado);
											junho.datas[diaSelecionado].adicionaVoo("Junho");
										}
										break;
									case "Julho":
										if (julho.datas[diaSelecionado].getStatus()) {
											julho.datas[diaSelecionado].adicionaVoo("Julho");
										} else {
											julho.datas[diaSelecionado] =  new Data(diaSelecionado);
											julho.datas[diaSelecionado].adicionaVoo("Julho");
										}
										break;
									case "Agosto":
										if (agosto.datas[diaSelecionado].getStatus()) {
											agosto.datas[diaSelecionado].adicionaVoo("Agosto");
										} else {
											agosto.datas[diaSelecionado] =  new Data(diaSelecionado);
											agosto.datas[diaSelecionado].adicionaVoo("Agosto");
										}
										break;
									case "Setembro":
										if (setembro.datas[diaSelecionado].getStatus()) {
											setembro.datas[diaSelecionado].adicionaVoo("Setembro");
										} else {
											setembro.datas[diaSelecionado] =  new Data(diaSelecionado);
											setembro.datas[diaSelecionado].adicionaVoo("Setembro");
										}
										break;
									case "Outubro":
										if (outubro.datas[diaSelecionado].getStatus()) {
											outubro.datas[diaSelecionado].adicionaVoo("Outubro");
										} else {
											outubro.datas[diaSelecionado] =  new Data(diaSelecionado);
											outubro.datas[diaSelecionado].adicionaVoo("Outubro");
										}
										break;
									case "Novembro":
										if (novembro.datas[diaSelecionado].getStatus()) {
											novembro.datas[diaSelecionado].adicionaVoo("Novembro");
										} else {
											novembro.datas[diaSelecionado] =  new Data(diaSelecionado);
											novembro.datas[diaSelecionado].adicionaVoo("Novembro");
										}
										break;
									case "Dezembro":
										if (dezembro.datas[diaSelecionado].getStatus()) {
											dezembro.datas[diaSelecionado].adicionaVoo("Dezembro");
										} else {
											dezembro.datas[diaSelecionado] =  new Data(diaSelecionado);
											dezembro.datas[diaSelecionado].adicionaVoo("Dezembro");
										}
										break;
									default:
										throw new OpcaoInvalida();
								}
								break;	
							
							//Dado m�s e dia, checa se a data j� foi iniciada, e remove um voo da data
							case 3:
								System.out.println("Em qual m�s voc� deseja remover um voo?");
								mesSelecionado = input.nextLine();
								
								System.out.println("Em qual dia?");
								diaSelecionado =  input.nextInt();
								input.nextLine();
								diaSelecionado--; //retificar data para ser usada como posi��o no vetor
		
								switch(mesSelecionado) {
								case "Janeiro":
									if (janeiro.datas[diaSelecionado].getStatus()) {
										janeiro.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Fevereiro":
									if (fevereiro.datas[diaSelecionado].getStatus()) {
										fevereiro.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Mar�o":
									if (mar�o.datas[diaSelecionado].getStatus()) {
										mar�o.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Abril":
									if (abril.datas[diaSelecionado].getStatus()) {
										abril.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Maio":
									if (maio.datas[diaSelecionado].getStatus()) {
										maio.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Junho":
									if (junho.datas[diaSelecionado].getStatus()) {
										junho.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Julho":
									if (julho.datas[diaSelecionado].getStatus()) {
										julho.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Agosto":
									if (julho.datas[diaSelecionado].getStatus()) {
										julho.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Setembro":
									if (setembro.datas[diaSelecionado].getStatus()) {
										setembro.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Outubro":
									if (outubro.datas[diaSelecionado].getStatus()) {
										outubro.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Novembro":
									if (novembro.datas[diaSelecionado].getStatus()) {
										novembro.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								case "Dezembro":
									if (dezembro.datas[diaSelecionado].getStatus()) {
										dezembro.datas[diaSelecionado].removeVoo();
									} else {
										throw new NaoExisteVoo();
									}
									break;
								default:
									throw new OpcaoInvalida();
								}
								break;	
							
							//user logout;
							case 4:
								System.out.println("Logout");
								usuarios.logout();
								loop = false;
								break;
						}
					} else if(usuarios.getTipoDeUsuario().equals("Cliente")) {
						System.out.println("1- Verificar voos dispon�veis");
						System.out.println("2- Comprar voos");
						System.out.println("3- Verificar passagens adiquiridas");
						System.out.println("4- Cancelar passagens adiquiridas");
						System.out.println("5- Logout");
						decisao = input.nextInt();
						input.nextLine();
						
						switch(decisao) {
							case 1:
								System.out.println("Deseja imprimir os voos de qual m�s?");
								mesSelecionado = input.nextLine();
							
								switch(mesSelecionado) {
									case "Janeiro":
										janeiro.imprimeVoos();
										break;
									case "Fevereiro":
										fevereiro.imprimeVoos();
										break;
									case "Mar�o":
										mar�o.imprimeVoos();
										break;
									case "Abril":
										abril.imprimeVoos();
										break;
									case "Maio":
										maio.imprimeVoos();
										break;
									case "Junho":
										junho.imprimeVoos();
										break;
									case "Julho":
										julho.imprimeVoos();
										break;
									case "Agosto":
										agosto.imprimeVoos();
										break;
									case "Setembro":
										setembro.imprimeVoos();
										break;
									case "Outubro":
										outubro.imprimeVoos();
										break;
									case "Novembro":
										novembro.imprimeVoos();
										break;
									case "Dezembro":
										dezembro.imprimeVoos();
										break;
									default:
										throw new OpcaoInvalida();
								}
								break;	
								
							//Dado m�s, chama m�todo "comprarVoo" dos usu�rios.	
							case 2:
								System.out.println("Voc� deseja comprar um voo em qual m�s?");
								mesSelecionado = input.nextLine();
								
								System.out.println("Em qual dia?");
								diaSelecionado =  input.nextInt();
								input.nextLine();
								
								diaSelecionado--; //retificar data para ser usada como posi��o no vetor
		
								switch(mesSelecionado) {
								case "Janeiro":
									usuarios.comprarVoo(janeiro);
									break;
								case "Fevereiro":
									usuarios.comprarVoo(fevereiro);
									break;
								case "Mar�o":
									usuarios.comprarVoo(mar�o);
									break;
								case "Abril":
									usuarios.comprarVoo(abril);
									break;
								case "Maio":
									usuarios.comprarVoo(maio);
									break;
								case "Junho":
									usuarios.comprarVoo(junho);
									break;
								case "Julho":
									usuarios.comprarVoo(julho);
									break;
								case "Agosto":
									usuarios.comprarVoo(agosto);
									break;
								case "Setembro":
									usuarios.comprarVoo(setembro);
									break;
								case "Outubro":
									usuarios.comprarVoo(outubro);
									break;
								case "Novembro":
									usuarios.comprarVoo(novembro);
									break;
								case "Dezembro":
									usuarios.comprarVoo(dezembro);
									break;
								default:
									//throw new OpcaoInvalida();
								}
								break;	
								
							//
							case 3:
								usuarios.imprimeCompras();
								break;
							case 4:
								System.out.println("Voc� deseja cancelar a compra de um voo em qual m�s?");
								mesSelecionado = input.nextLine();
		
								switch(mesSelecionado) {
								case "Janeiro":
									usuarios.cancelaCompra(janeiro);
									break;
								case "Fevereiro":
									usuarios.cancelaCompra(fevereiro);
									break;
								case "Mar�o":
									usuarios.cancelaCompra(mar�o);
									break;
								case "Abril":
									usuarios.cancelaCompra(abril);
									break;
								case "Maio":
									usuarios.cancelaCompra(maio);
									break;
								case "Junho":
									usuarios.cancelaCompra(junho);
									break;
								case "Julho":
									usuarios.cancelaCompra(julho);
									break;
								case "Agosto":
									usuarios.cancelaCompra(agosto);
									break;
								case "Setembro":
									usuarios.cancelaCompra(setembro);
									break;
								case "Outubro":
									usuarios.cancelaCompra(outubro);
									break;
								case "Novembro":
									usuarios.cancelaCompra(novembro);
									break;
								case "Dezembro":
									usuarios.cancelaCompra(dezembro);
									break;
								default:
									//throw new OpcaoInvalida();
								}
								break;	
							case 5:
								System.out.println("Logout");
								usuarios.logout();
								loop = false;
								break;
							
						}
					}
				} catch (Exception e) {  //<----------------------
					e.printStackTrace();
				}
			} while (loop); //FIM DO LOOP "MENU LOGADO"
		} 	
		}while(true);// else { para caso n esteja logado (?) ERRO
	}
}
