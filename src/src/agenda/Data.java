package agenda;

import java.util.Scanner;

public class Data {
	int data;
	protected int numeroDeVoos;
	public Voo[] listaDeVoos = new Voo[4];
	private Scanner input;
	boolean status;
	
	public Data(int Data) {
		this.data = Data;
		this.numeroDeVoos = 0;
		this.listaDeVoos = null;
		this.status =  true;
	}
		
	public void adicionaVoo(String mes) {
		String nome = null;
		String compania = null;
		String destino = null;
		String partida = null;
		String horarioChegada = null;
		String horarioSaida = null;
		int codigoVoo = -1;
		
		input = new Scanner(System.in);

		System.out.println("Entre dados para o novo Voo");

		System.out.println("Nome do Voo");
		nome = input.nextLine();

		System.out.println("Nome da compania");
		compania = input.nextLine();

		System.out.println("Destino");
		destino = input.nextLine();

		System.out.println("Partida");
		partida = input.nextLine();

		System.out.println("Horario de chegada");
		horarioChegada = input.nextLine();

		System.out.println("Horario de saida");
		horarioSaida =  input.nextLine();

		System.out.println("Código do Voo");
		codigoVoo = input.nextInt();

		listaDeVoos[numeroDeVoos] =  new Voo(nome, compania, destino, partida, horarioChegada, horarioSaida, codigoVoo, mes);
		this.numeroDeVoos++;
	}

	public void removeVoo() { 
		
		int vooRemovido;
		input = new Scanner(System.in);

		System.out.println("Escolha o voo a ser removido");
		vooRemovido = input.nextInt();

		for (int i = 0; i < 4; i++) {
			if(vooRemovido == listaDeVoos[i].getCodigoVoo()) {
				listaDeVoos[i] = null;
				
				if (i == 3) {
					return;
				} else {
					for (int j = i; i < 3; i++) {
						listaDeVoos[j] = listaDeVoos[j+1];
					}
					return;
				}	
			}
		}
		
		//ERRO
	}

	public int buscaVoo(int codigoVoo) {
		for(int i=0; i < 4; i++) {
			if(listaDeVoos[i].getCodigoVoo() == codigoVoo) {
				return i;
			}
		}
		return -1;
	}

	public void imprimeVoosDoDia() {
		for(int i=0; i<4; i++) {
			if (listaDeVoos[i] != null) {
				Voo vooAtual = listaDeVoos[i];
				System.out.println("Voo " +vooAtual.toString());
			}
		}
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public int getNumeroDeVoos() {
		return numeroDeVoos;
	}

	
}
