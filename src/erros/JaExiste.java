package erros;

public class JaExiste extends Exception {
	
	public JaExiste(String usuario) {
		System.out.println("O usuario de nome '" + usuario + "' j� est� sendo usado, escolha outro!");	
	}
}
