package br.com.next.beans;

public enum TipoCliente {
	
	COMUM(0), SUPER(1), PREMIUM(2);
	
	private int id;
	
	TipoCliente(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}