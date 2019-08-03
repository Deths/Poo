package agenda;

import java.util.Arrays;
import usuario.*;
import agenda.*;

public class Voo {
	private String mes;
	private String nome;
	private String compania;
	private String destino;
	private String partida;
	private String horarioChegada;
	private String horarioSaida;
	private int poltronasVazias;
	private int poltronasCheias;
	private int codigoVoo;
	private float precoPrimeiraClasse;
	private float precoClasseEconomica;

	Poltrona[][] Primeira = new Poltrona[4][4];
	Poltrona[][] Economica = new Poltrona[4][4];

	public Voo (String nome, String compania,String destino, String partida, String horarioChegada, String horarioSaida, int codigoVoo, String mes) {
		System.out.println("Voo criado\n");
		this.nome = nome;
		this.compania =  compania;
		this.destino =  destino;
		this.partida =  partida;
		this.horarioChegada = horarioChegada;
		this.horarioSaida = horarioSaida;
		this.poltronasVazias = 32; //Total de poltronas no avião =  32 para todos os aviões.
		this.poltronasCheias = 0;
		this.mes = mes;
		setCodigoVoo(codigoVoo);

		this.Primeira = null;
		this.Economica = null;
	}
	
	//Comprar poltronas;
	public void adicionaPoltrona (String Cliente, String Classe, int numeroDeCadeiras, int tipo) {
		int i, j, k = 0;

		/*
		 * tipo 1 = lado a lado.
		 * tipo 2 = não importa.
		 */

		if (tipo == 2 && Classe.equals("Primeira")) {
			for (i = 0; i < 4; i++) {
				for ( j = 0; j < 4; j++) {
					if(Primeira[i][j] == null) {
						Primeira[i][j] =  new Poltrona(Cliente);
						k++;
					}
				}
			}
		} else if (tipo == 2 && Classe.equals("Economica")) {
			for (i = 0; i < 4; i++) {
				for ( j = 0; j < 4; j++) {
					if(Economica[i][j] == null) {
						Economica[i][j] = new Poltrona(Cliente);
						k++;
					}
				}
			}
		} else if (tipo == 1 && Classe.equals("Primeira")){
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					if(Primeira[i][j] == null) {

						//percorre o resto da fileira checkando as cadeiras.
						for (k = 1; k < numeroDeCadeiras; k++) {
							if(Primeira[i][j+k] != null)
								break;
						}

						//Caso existam cadeiras lado a lado suficientes.
						if (k == numeroDeCadeiras - 1) {

							//Adiciona poltronas na fileira.
							for (k = 0; k < numeroDeCadeiras; k++) {
								Primeira[i][j+k] = new Poltrona(Cliente);
							}
						}
					}
				}
			}
		} else if (tipo == 1 && Classe.equals("Economica")){
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					if(Economica[i][j] == null) {

						//percorre o resto da fileira checkando as cadeiras.
						for (k = 1; k < numeroDeCadeiras; k++) {
							if(Economica[i][j+k] != null)
								break;
						}

						//Caso existam cadeiras lado a lado suficientes.
						if (k == numeroDeCadeiras - 1) {

							//Adiciona poltronas na fileira.
							for (k = 0; k < numeroDeCadeiras; k++) {
								Economica[i][j+k] = new Poltrona(Cliente);
							}
						}
					}
				}
			}
		} else {
			//Erro
		}

		this.poltronasVazias =  this.poltronasVazias - numeroDeCadeiras;
		this.poltronasCheias = this.poltronasCheias + numeroDeCadeiras;
	}
	
	public void adicionaPoltrona (int linha, int coluna, int classe, int clienteID) {
		if(classe == 1) {
			if(Primeira[linha][coluna].getClienteID() < 0) {
				Primeira[linha][coluna].ocupaPoltrona(clienteID);
			}
		} else if(classe == 2) {
			if(Economica[linha][coluna].getClienteID() < 0) {
				Economica[linha][coluna].ocupaPoltrona(clienteID);
			}
		}
		this.poltronasVazias--;
		this.poltronasCheias++;
	}
	
	
	public void imprimePoltronas(int classe) {
		System.out.println("x -> poltronas indisponíveis");
		System.out.println("o -> poltronas disponíveis");
		if(classe == 1) {
			System.out.println("  0 1 2 3");
			for(int i=0; i<4; i++) {
				System.out.print(i+ " ");
				for(int j=0; j<4; j++) {
					if(Primeira[i][j].getStatus().equals("vazia")) {
						System.out.print("o ");
					} else {
						System.out.print("x ");
					}
				}
				System.out.println();
			}
		} else if(classe == 2) {
			System.out.println("  0 1 2 3");
			for(int i=0; i<4; i++) {
				System.out.print(i+ " ");
				for(int j=0; j<4; j++) {
					if(Economica[i][j].getStatus().equals("vazia")) {
						System.out.print("o ");
					} else {
						System.out.print("x ");
					}
				}
				System.out.println();
			}
		}
	}
	
	public Poltrona buscaPoltrona(int linha, int coluna, int classe) {
		if(classe == 1) {
			return Primeira[linha][classe];
		} else {
			return Economica[linha][classe];
		}
	}
	
	public void removeDaPoltrona(int linha, int coluna, int classe) {
		if(classe == 1) {
			Primeira[linha][coluna].desocupaPoltrona();
		} else {
			Economica[linha][coluna].desocupaPoltrona();
		}
	}
	
	public float calculaValorTotal(int passagens, int menoresDeIdade, int classe) {
		if(classe == 1) {
			return (precoPrimeiraClasse*(passagens-menoresDeIdade));
		} else {
			return (precoClasseEconomica*(passagens-menoresDeIdade));
		}
	}
	
	@Override
	public String toString() {
		return "Voo [compania=" + compania + ", destino=" + destino + ", horarioChegada=" + horarioChegada
				+ ", horarioSaida=" + horarioSaida + ", nome=" + nome + ", partida=" + partida + ", poltronasCheias="
				+ poltronasCheias + ", poltronasVazias=" + poltronasVazias + ", codigoVoo "+ codigoVoo +"]";
	}

	public String getNome() {
		return nome;
	}

	public String getCompania() {
		return compania;
	}

	public String getDestino() {
		return destino;
	}

	public String getPartida() {
		return partida;
	}

	public String getHorarioChegada() {
		return horarioChegada;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public int getPoltronasVazias() {
		return poltronasVazias;
	}

	public int getPoltronasCheias() {
		return poltronasCheias;
	}
	
	public void setCodigoVoo(int codigoVoo) {
		this.codigoVoo = codigoVoo;
	}

	public int getCodigoVoo(){
		return this.codigoVoo;
	}
	
	public String getMesVoo(){
		return this.mes;
	}
}
