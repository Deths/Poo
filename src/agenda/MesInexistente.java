package agenda;

public class MesInexistente extends Exception {
	public MesInexistente(String mesSelecionado) {
		System.out.print("N�o existe esse mes <" + mesSelecionado + " >");
	}
}
