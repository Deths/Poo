package agenda;

import java.util.Scanner;

public class Data {
//Atributos
	int data;
	protected int numeroDeVoos;
	public Voo[] listaDeVoos = new Voo[4];
	private Scanner input;
	boolean status;
	
//Metodo Construtor
	public Data(int Data) {
		this.data = Data;
		this.numeroDeVoos = 0;
		this.listaDeVoos = null;
		this.status =  true;
	}
	
//Getters and Setters
	public int getNumeroDeVoos() {
		return numeroDeVoos;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
//Metodo que configura todo o voo e adiciona no vetor "listaDeVoos"
	public void adicionaVoo() {
		//declarando variáveis de config do voo
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
		//Entrevista para compra de voo
		System.out.println("Entre dados para o novo Voo");

		System.out.println("Nome do Voo");
		nome = input.nextLine();

		System.out.println("Nome da companhia");
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
		//!!Pode ter erros = numero de voos pode ser maior que 4 - não irá armazenar
		listaDeVoos[numeroDeVoos] =  new Voo(nome, compania, destino, partida, horarioChegada, horarioSaida, codigoVoo, precoPrimeiraClasse, precoClasseEconomica);
		this.numeroDeVoos++;
	}

//Metodo que remove Voos
	public void removeVoo() throws NaoExisteVoo {
		int i;
		int vooRemovido;
		input = new Scanner(System.in);

		System.out.println("Escolha o voo a ser cancelado (Codigo de voo)");
		vooRemovido = input.nextInt();

		for (i =  0; i < 4; i++) {
			if(vooRemovido == listaDeVoos[i].getCodigoVoo()) {
				listaDeVoos[i] = null; //anula o voo especificado
				return;
			}
		}

		if (i == 3) {
			throw new NaoExisteVoo();//Caso não exista voo especificado
		}
	}

//Metodo que procura por voos com seu codigo - retorna a posição no vetor listaDeVoos ou -1 se não existe
	public int buscaVoo(int codigoVoo) {
		for(int i=0; i < 4; i++) {
			if(listaDeVoos[i].getCodigoVoo() == codigoVoo) {
				return i;
			}
		}
		return -1;
	}

//Metodo que imprime os voos do vetor listaDeVoos
	public void imprimeVoosDoMes(Agenda agenda) {
		int i;
		int passou=0;
		for(i=0; i<4; i++) {
			if(listaDeVoos[i].getAgenda().equals(agenda)) {
				System.out.println("Voo " +listaDeVoos[i].toString());
				passou++;
			}			
		}
		if(passou==0) {
			System.out.println("Não existe voos para esse mes");
		}
	}

	public void imprimeData() {
		
	}
	
	
	
}
