package agenda;

import java.util.Scanner;

import erros.OpcaoInvalida;

public class Data {
	int data;
	protected int numeroDeVoos;
	public Voo[] listaDeVoos = new Voo[4];
	private Scanner input;
	boolean status = false;
	
	public Data(int Data) {
		System.out.println("Data criada\n");
		this.data = Data;
		this.numeroDeVoos = 0;
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
        try {
        	if(input.hasNextInt())
    			codigoVoo = input.nextInt();
    		else{
    			input.next();
    			throw new OpcaoInvalida();
    		}
        } catch(Exception e) {
        	e.printStackTrace();
        }
        System.out.println("Preço Primeira Classe");
        precoPrimeiraClasse = input.nextFloat();

        System.out.println("Preço Classe Econômica");
        precoClasseEconomica = input.nextFloat();

        listaDeVoos[numeroDeVoos] =  new Voo(nome, compania, destino, partida, horarioChegada, horarioSaida, codigoVoo, precoPrimeiraClasse, precoClasseEconomica);
        this.numeroDeVoos++;
    }

	public void removeVoo() { 
		int vooRemovido;
		boolean bool = true;
		input = new Scanner(System.in);
		
		imprimeVoosDoDia();
		
		System.out.println("Escolha o código do voo a ser removido");
		vooRemovido = 0;
		while(bool) {
			try {
				if(input.hasNextInt()) {
	    			vooRemovido = input.nextInt();
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
		for (int i = 0; i < 4; i++) {
			if(vooRemovido == listaDeVoos[i].getCodigoVoo()) {
				listaDeVoos[i] = null;
				for(int j = i ;i < 3; i++) {
					listaDeVoos[j]=listaDeVoos[j+1];			
				}
				listaDeVoos[3] = null;
				break;
			}
		}
		numeroDeVoos--;
		return;
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
				System.out.println(vooAtual.toString());
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
