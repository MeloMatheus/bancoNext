package br.com.next.beans;

public enum Bandeira {

	MASTERCARD(1),VISA(2), ELO(3);
	
	private int id;
	
	Bandeira(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
