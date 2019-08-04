package usuario;
import usuario.*;
import agenda.*;
import erros.JaExiste;
import erros.OpcaoInvalida;

import java.util.Scanner;

public class Usuarios {
	private Usuario[] clientes = new Usuario[1000];
	private Usuario[] atendentes = new Usuario[1000];
	private int indiceCliente;
	private int indiceAtendente;
	private static int logado = 0;
	private static int usuarioID;
	private static String tipoDeUsuario;

	public Usuarios() {
		this.indiceCliente = -1;
		this.indiceAtendente = -1;
	}

	public void setLogado(boolean logado) {
		if(logado) {
			Usuarios.logado = 1;
		} else {
			Usuarios.logado = 0;
		}
	}

	public int getLogado() {
		return logado;
	}

	public void setUsuarioID(int id) {
		Usuarios.usuarioID = id;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setTipoDeUsuario(String usuario) {
		Usuarios.tipoDeUsuario = usuario;
	}

	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void novoCliente(String usuario, String senha) {
		boolean clienteJaExiste = false;
		if(this.indiceCliente > -1) {
			for(int i=0; i<indiceCliente+1; i++) {
				if(this.clientes[i].getUsuario().equals(usuario)) {
					clienteJaExiste = true;
					try {
						throw new JaExiste(usuario);
					} catch (JaExiste e) {
						e.printStackTrace();
					}
				}
			}
		}
		if(!clienteJaExiste) {
			Cliente cliente = new Cliente(usuario,senha);
			indiceCliente++;
			this.clientes[indiceCliente] = cliente;
		}
	}

	public void novoAtendente(String usuario, String senha) {
		boolean atendenteJaExiste = false;
		if(this.indiceAtendente > -1) {
			for(int i=0; i<indiceAtendente+1; i++) {
				if(this.atendentes[i].getUsuario().equals(usuario)) {
					atendenteJaExiste = true;
					try {
						throw new JaExiste(usuario);
					} catch (JaExiste e) {
						e.printStackTrace();
					}
				}
			}
		}
		if(!atendenteJaExiste) {
			Atendente atendente = new Atendente(usuario,senha);
			indiceAtendente++;
			this.atendentes[indiceAtendente] = atendente;
		}
	}

	public boolean loginCliente(String usuario, String senha) {
		for(int i=0; i<clientes.length; i++) {
			if(this.clientes[i].getUsuario().equals(usuario)) {
				if(this.clientes[i].getSenha().equals(senha)) {
					setUsuarioID(i);
					setTipoDeUsuario("Cliente");
					setLogado(true);
					return true;
				}
			}
		}
		return false;
	}

	public boolean loginAtendente(String usuario, String senha) {
		for(int i=0; i<atendentes.length; i++) {
			if(this.atendentes[i].getUsuario().equals(usuario)) {
				if(this.atendentes[i].getSenha().equals(senha)) {
					setUsuarioID(i);
					setTipoDeUsuario("Atendente");
					setLogado(true);
					return true;
				}
			}
		}
		return false;
	}

	public void logout() {
		setLogado(false);
		setUsuarioID(-1);
		setTipoDeUsuario("Nenhum");
	}

	public void comprarVoo(Agenda agenda, int data) {
		boolean bool = true;
		Scanner input = new Scanner(System.in);
		System.out.println("Possuímos as viagens a seguir para o dia " + (data + 1));
		Data dataEscolhida = agenda.datas[data];
		dataEscolhida.imprimeVoosDoDia();
		System.out.println("Digite o código da viagem escolhida: ");
		int codigo = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
	    			codigo = input.nextInt();
	        		bool = false;
				} else {
	    			input.next();
	    			throw new OpcaoInvalida();
	    		}
	        	input.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bool = true;
		int	codigoDoVoo = dataEscolhida.buscaVoo(codigo);
		if(codigoDoVoo >= 0) {
			System.out.println("Digite o número de passagens que gostaria de comprar: ");
			int passagens = 0;
			while(bool) {
				try {
					if(input.hasNextInt()) {
		    			passagens = input.nextInt();
		        		bool = false;
					} else {
		    			input.next();
		    			throw new OpcaoInvalida();
		    		}
		        	input.nextLine();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			bool = true;
			System.out.println("Algum dos passageiros é menor de idade? Se sim, digite a quantidade, se não, digite 0");
			int passageirosMenoresDeIdade = 0;
			while(bool) {
				try {
					if(input.hasNextInt()) {
						passageirosMenoresDeIdade = input.nextInt();
		        		bool = false;
					} else {
		    			input.next();
		    			throw new OpcaoInvalida();
		    		}
		        	input.nextLine();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			bool = true;
			System.out.println("Gostaria de comprar no setor de primeira classe(1) ou econômica(2)?");
			int classe = 0; 
			while(bool) {
				try {
					if(input.hasNextInt()) {
						classe = input.nextInt();
		        		bool = false;
					} else {
		    			input.next();
		    			throw new OpcaoInvalida();
		    		}
		        	input.nextLine();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			bool = true;
			System.out.println("Por favor, escolha os lugares das poltronas");
			Voo vooEscolhido = dataEscolhida.listaDeVoos[codigoDoVoo];
			vooEscolhido.imprimePoltronas(classe);
			for(int i=0; i<passagens; i++) {
				System.out.println("Escolha a cadeira: ");
				System.out.println("Digite a linha: ");
				int linha = 0;
				while(bool) {
					try {
						if(input.hasNextInt()) {
							linha = input.nextInt();
			        		bool = false;
						} else {
			    			input.next();
			    			throw new OpcaoInvalida();
			    		}
			        	input.nextLine();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				bool = true;
				System.out.println("Digite a coluna: ");
				int coluna = 0;
				while(bool) {
					try {
						if(input.hasNextInt()) {
							coluna = input.nextInt();
			        		bool = false;
						} else {
			    			input.next();
			    			throw new OpcaoInvalida();
			    		}
			        	input.nextLine();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				bool = true;
				vooEscolhido.adicionaPoltrona(linha, coluna, classe, getUsuarioID());
				clientes[usuarioID].adicionaCompras(vooEscolhido, vooEscolhido.buscaPoltrona(linha,coluna,classe));
			}
			System.out.println("O valor total da compra é: " +vooEscolhido.calculaValorTotal(passagens, passageirosMenoresDeIdade, classe));
			System.out.println("Compra efetuada com sucesso!");
		}
	}
	
	public void imprimeCompras() {
		clientes[usuarioID].imprimeCompras();
	}
	
	public void cancelaCompra(Agenda agenda) {
		int codigoCompra;
		int data;
		int codigoVoo;
		int classe;
		int linha;
		int coluna;
		int vooID;
		boolean bool = true;
		
		Scanner input = new Scanner(System.in);
		
		imprimeCompras();
		System.out.println("Digite o código da compra a ser cancelada: ");
		codigoCompra = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
					codigoCompra = input.nextInt();
	        		bool = false;
				} else {
	    			input.next();
	    			throw new OpcaoInvalida();
	    		}
	        	input.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bool = true;
		System.out.println("Confirme a data: ");
		data = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
					data = input.nextInt();
	        		bool = false;
				} else {
	    			input.next();
	    			throw new OpcaoInvalida();
	    		}
	        	input.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bool = true;
		System.out.println("Confirme o código do voo: ");
		codigoVoo = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
					codigoVoo = input.nextInt();
	        		bool = false;
				} else {
	    			input.next();
	    			throw new OpcaoInvalida();
	    		}
	        	input.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bool = true;
		System.out.println("Confirme a classe (1-Primeira/2-Economica)");
		classe = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
					classe = input.nextInt();
	        		bool = false;
				} else {
	    			input.next();
	    			throw new OpcaoInvalida();
	    		}
	        	input.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bool = true;
		System.out.println("Confirme a linha da poltrona: ");
		linha = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
					linha = input.nextInt();
	        		bool = false;
				} else {
	    			input.next();
	    			throw new OpcaoInvalida();
	    		}
	        	input.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bool = true;
		System.out.println("Confirme a coluna da poltrona: ");
		coluna = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
					coluna = input.nextInt();
	        		bool = false;
				} else {
	    			input.next();
	    			throw new OpcaoInvalida();
	    		}
	        	input.nextLine();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		bool = true;
		Usuario clienteAtual = clientes[usuarioID];
		Data dataDoVoo = agenda.datas[data - 1];
		vooID = dataDoVoo.buscaVoo(codigoVoo);
		dataDoVoo.listaDeVoos[vooID].removeDaPoltrona(linha, coluna, classe);
		clienteAtual.apagaCompra(codigoCompra);
	}
}

