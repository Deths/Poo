package erros;

public class JaExiste extends Exception {
	
	public JaExiste(String usuario) {
		System.out.println("O usuario de nome '" + usuario + "' já está sendo usado, escolha outro!");	
	}
}
