package daca.qma.models;

public enum AjudaTipo {
	
	PRESENCIAL("Presencial"),
	ONLINE("Online");

	private String tipo;
	
	AjudaTipo(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
