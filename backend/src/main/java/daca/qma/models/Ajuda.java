package daca.qma.models;

import javax.persistence.Entity;

@Entity
public class Ajuda {
	
	private Tutor tutor;
	private String horario;
	
	
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

}
