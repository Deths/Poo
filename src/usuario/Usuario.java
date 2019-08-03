package usuario;

import agenda.Poltrona;
import agenda.Voo;

public class Usuario {
	private String usuario, senha;

//Construtor
	public Usuario(String usuario, String senha) {
		setUsuario(usuario);
		setSenha(senha);
	}
	
//Getters and Setters
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
	public String getUsuario() {
		return usuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	public String getSenha() {
		return senha;
	}
	
//Métodos que serão sobrescritos na classe filhas "Cliente"
	public void adicionaCompras(Voo voo, Poltrona poltrona) {
	}

	public void imprimeCompras() {
		//Fazer método 
	}

	public void apagaCompra(int codigo) {
	}
}
