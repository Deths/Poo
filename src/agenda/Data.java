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
	
	public int getNumeroDeVoos() {
		return numeroDeVoos;
	}
		
	public void adicionaVoo() {

		String nome = null;
		String compania = null;
		String destino = null;
		String partida = null;
		String horarioChegada = null;
		String horarioSaida = null;
		int codigoVoo = -1;
		float precoPrimeiraClasse = 0;
		float precoClasseEconomica = 0;
		
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
		
		System.out.println("Preço Primeira Classe");
		precoPrimeiraClasse = input.nextFloat();
		
		System.out.println("Preço Classe Econômica");
		precoClasseEconomica = input.nextFloat();

		listaDeVoos[numeroDeVoos] =  new Voo(nome, compania, destino, partida, horarioChegada, horarioSaida, codigoVoo, precoPrimeiraClasse, precoClasseEconomica);
		this.numeroDeVoos++;
	}

	public void removeVoo() {
		int i;
		int vooRemovido;
		input = new Scanner(System.in);

		System.out.println("Escolha o voo a ser cancelado");
		vooRemovido = input.nextInt();

		for (i =  0; i < 4; i++) {
			if(vooRemovido == listaDeVoos[i].getCodigoVoo()) {
				listaDeVoos[i] = null;
				return;
			}
		}

		if (i == 3) {
			//Exception
		}
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
			Voo vooAtual = listaDeVoos[i];
			System.out.println("Voo " +vooAtual.toString());
		}
	}
	
	public void imprimeData() {
		
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
}
