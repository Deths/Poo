package teste;
import java.util.Scanner;
import agenda.*;
import usuario.Usuarios;
import erros.*;

public class Teste {

	public static void main(String[] args) {
		int decisao = 0;
		int tipoDeUsuario;
		String mesSelecionado;
		int diaSelecionado; 
		boolean loop = true;
		
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
			loop = true;
			System.out.println("-------------------------------------------------------");
			System.out.println("                     Bem-vindo");
			System.out.println("-------------------------------------------------------");
			do {
				System.out.println();
				System.out.println("-------------------------------------------------------");
				try {
					decisao = 0;
					System.out.println("O que gostaria de fazer? (1 - Cadastrar / 2 - Login)");
					if(input.hasNextInt())
						decisao = input.nextInt();
					else{
						input.next();
						throw new OpcaoInvalida();
					}
					input.nextLine();
						
					if(decisao != 1 && decisao != 2) {
						throw new OpcaoInvalida();
					}
					
					System.out.println("Voc� � um cliente ou um atendente? (1 - Cliente / 2 - Atendente)");
					if(input.hasNextInt())
						tipoDeUsuario = input.nextInt();
					else{
						input.next();
						throw new OpcaoInvalida();
					}
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
						System.out.println("-------------------------------------------------------");
						System.out.println("O que gostaria de fazer?");
						if(usuarios.getTipoDeUsuario().equalsIgnoreCase("Atendente")) {
							System.out.println("1- Verificar voos dispon�veis");
							System.out.println("2- Criar um novo voo");
							System.out.println("3- Deletar um voo");
							System.out.println("4- Logout");
							System.out.println("-------------------------------------------------------");
							if(input.hasNextInt())
								decisao = input.nextInt();
							else{
								input.next();
								throw new OpcaoInvalida();
							}
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
									if(input.hasNextInt())
										diaSelecionado = input.nextInt();
									else{
										input.next();
										throw new OpcaoInvalida();
									}
									input.nextLine();
									diaSelecionado--; //retificar data para ser usada como posi��o no vetor
									
									switch(mesSelecionado) {
										case "Janeiro":
											try {
												if (janeiro.datas[diaSelecionado].getStatus()) {
													janeiro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {
												janeiro.datas[diaSelecionado] =  new Data(diaSelecionado);
												janeiro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Fevereiro":
											try {
												if (fevereiro.datas[diaSelecionado].getStatus()) {
													fevereiro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {
												fevereiro.datas[diaSelecionado] =  new Data(diaSelecionado);
												fevereiro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Mar�o":
											try {
												if (mar�o.datas[diaSelecionado].getStatus()) {
													mar�o.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {
												mar�o.datas[diaSelecionado] =  new Data(diaSelecionado);
												mar�o.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Abril":
											try {
												if (abril.datas[diaSelecionado].getStatus()) {
													abril.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {
												abril.datas[diaSelecionado] =  new Data(diaSelecionado);
												abril.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Maio":
											try {
												if (maio.datas[diaSelecionado].getStatus()) {
													maio.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												maio.datas[diaSelecionado] =  new Data(diaSelecionado);
												maio.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Junho":
											try {
												if (junho.datas[diaSelecionado].getStatus()) {
													junho.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												junho.datas[diaSelecionado] =  new Data(diaSelecionado);
												junho.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Julho":
											try {
												if (julho.datas[diaSelecionado].getStatus()) {
													julho.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												julho.datas[diaSelecionado] =  new Data(diaSelecionado);
												julho.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Agosto":
											try {
												if (agosto.datas[diaSelecionado].getStatus()) {
													agosto.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												agosto.datas[diaSelecionado] =  new Data(diaSelecionado);
												agosto.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Setembro":
											try {
												if (setembro.datas[diaSelecionado].getStatus()) {
													setembro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												setembro.datas[diaSelecionado] =  new Data(diaSelecionado);
												setembro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Outubro":
											try {
												if (outubro.datas[diaSelecionado].getStatus()) {
													outubro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												outubro.datas[diaSelecionado] =  new Data(diaSelecionado);
												outubro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Novembro":
											try {
												if (novembro.datas[diaSelecionado].getStatus()) {
													novembro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												novembro.datas[diaSelecionado] =  new Data(diaSelecionado);
												novembro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
											}
											break;
										case "Dezembro":
											try {
												if (dezembro.datas[diaSelecionado].getStatus()) {
													dezembro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
												} 
											} catch (Exception e) {  
												dezembro.datas[diaSelecionado] =  new Data(diaSelecionado);
												dezembro.datas[diaSelecionado].adicionaVoo(mesSelecionado);
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
									if(input.hasNextInt())
										diaSelecionado = input.nextInt();
									else{
										input.next();
										throw new OpcaoInvalida();
									}
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
									System.out.println(" - - - - - Logout - - - - - ");
									usuarios.logout();
									loop = false;
									break;
							}
						} else if(usuarios.getTipoDeUsuario().equalsIgnoreCase("Cliente")) {
							System.out.println("1- Verificar voos dispon�veis");
							System.out.println("2- Comprar voos");
							System.out.println("3- Verificar passagens adiquiridas");
							System.out.println("4- Cancelar passagens adiquiridas");
							System.out.println("5- Logout");
							System.out.println("-------------------------------------------------------");
							if(input.hasNextInt())
								decisao = input.nextInt();
							else{
								input.next();
								throw new OpcaoInvalida();
							}
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
									if(input.hasNextInt())
										diaSelecionado = input.nextInt();
									else{
										input.next();
										throw new OpcaoInvalida();
									}
									input.nextLine();
									
									diaSelecionado--; //retificar data para ser usada como posi��o no vetor
			
									switch(mesSelecionado) {
									case "Janeiro":
										usuarios.comprarVoo(janeiro, diaSelecionado);
										break;
									case "Fevereiro":
										usuarios.comprarVoo(fevereiro, diaSelecionado);
										break;
									case "Mar�o":
										usuarios.comprarVoo(mar�o, diaSelecionado);
										break;
									case "Abril":
										usuarios.comprarVoo(abril, diaSelecionado);
										break;
									case "Maio":
										usuarios.comprarVoo(maio, diaSelecionado);
										break;
									case "Junho":
										usuarios.comprarVoo(junho, diaSelecionado);
										break;
									case "Julho":
										usuarios.comprarVoo(julho, diaSelecionado);
										break;
									case "Agosto":
										usuarios.comprarVoo(agosto, diaSelecionado);
										break;
									case "Setembro":
										usuarios.comprarVoo(setembro, diaSelecionado);
										break;
									case "Outubro":
										usuarios.comprarVoo(outubro, diaSelecionado);
										break;
									case "Novembro":
										usuarios.comprarVoo(novembro, diaSelecionado);
										break;
									case "Dezembro":
										usuarios.comprarVoo(dezembro, diaSelecionado);
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
									System.out.println(" - - - - - Logout - - - - - ");
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
			// else { para caso n esteja logado (?) ERRO
		}while (true);
	}
}