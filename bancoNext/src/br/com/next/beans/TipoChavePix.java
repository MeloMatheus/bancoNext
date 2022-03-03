package br.com.next.beans;

public enum TipoChavePix {
	CPF(1), EMAIL(2), TELEFONE(3), ALEATORIO(4);
	
	private int id;
	
	TipoChavePix(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
