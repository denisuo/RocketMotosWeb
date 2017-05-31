package br.com.rocketmotos.dominio;

import java.util.Hashtable;
import java.util.Set;


public class Dominio {
	
	private Hashtable<String, String> aHashTable = new Hashtable<String, String>(); 
	
	public String getValor(String chave) {
		return aHashTable.get(chave);
	}

	public void setValor(String chave, String valor) {
		this.aHashTable.put(chave, valor);
	}
	
	public Set<String> getChaves(){
		return aHashTable.keySet();
	}

}
