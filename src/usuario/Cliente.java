package usuario;

import agenda.Voo;
import agenda.Poltrona;

public class Cliente extends Usuario{
//Atributos
	Compras compra = new Compras();
	
//Construtor
	public Cliente(String usuario, String senha) {
		super(usuario, senha);		
	}
//Métodos sobrescritos da super "Usuario"
	@Override
	public void adicionaCompras(Voo voo, Poltrona poltrona) {
		compra.salvarCompra(voo, poltrona);
	}
	
	@Override
	public void imprimeCompras() {
		compra.imprimeCompras();
	}
	
	@Override
	public void apagaCompra(int codigo) {
		compra.apagaCompra(codigo);
	}
	
//Getters and Setters
	public void setCompra(Compras compra) {
		this.compra = compra;
	}
	public Compra[] getCompra() {
		return compra.getCompra();
	}
}
