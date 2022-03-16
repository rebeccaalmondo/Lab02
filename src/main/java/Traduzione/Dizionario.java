package Traduzione;

import java.util.LinkedList;
import java.util.List;

public class Dizionario {
	
	private String parola;
	List <String> listaTraduzioni=new LinkedList <String>();
	
	
	public Dizionario(String parola) {
		
		this.parola = parola;
		
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public List<String> getListaTraduzioni() {
		return listaTraduzioni;
	}
	public void setListaTraduzioni(List<String> listaTraduzioni) {
		this.listaTraduzioni = listaTraduzioni;
	}
	
	
	

}
