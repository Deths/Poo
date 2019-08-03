package agenda;

public class MesInexistente extends Exception {
	public MesInexistente(String mesSelecionado) {
		System.out.print("Não existe esse mes <" + mesSelecionado + " >");
	}
}
