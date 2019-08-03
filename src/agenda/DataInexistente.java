package agenda;

public class DataInexistente extends Exception {
	public DataInexistente() {
		System.out.println("A data requerida nao existe!");
	}
}
