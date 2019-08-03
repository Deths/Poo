package agenda;
import agenda.Data;

public class Agenda {
	private String mes;
	public Data[] datas;

	public Agenda(String mes) {
		setMes(mes);
		if(mes.equals("Janeiro") || mes.equals("Março") || mes.equals("Maio") || mes.equals("Julho")
		|| mes.equals("Agosto") || mes.equals("Outubro") || mes.equals("Dezembro")) {
		    datas = new Data[31];
		} else if(mes.equals("Abril") || mes.equals("Junho") || mes.equals("Setembro") || mes.equals("Novembro")) {
			datas = new Data[30];
		} else if(mes.equals("Fevereiro")) {
		    datas = new Data[28];
		}
  }

  	public void imprimeVoos() {
	int aux;
	System.out.println("-------------------------------------------------------");
	System.out.println("Voos disponiveis para " +getMes());
	for(int i = 0; i < datas.length; i++) {
		aux = i + 1;
		  if(datas[i] != null) {
		    System.out.println("Dia " +aux);
		    datas[i].imprimeVoosDoDia();
		  }    
	}
	System.out.println("-------------------------------------------------------");
  	}

  	public void setMes(String mes) {
  		this.mes = mes;
  	}

  	public String getMes() {
  		return mes;
  	}
}

