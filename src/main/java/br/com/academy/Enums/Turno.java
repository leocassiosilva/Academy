package br.com.academy.Enums;

public enum Turno {
	
	MATUTINO("Matutino"),
	VESPERTINO("Vespertino"),
	NOTURNO("Noturno");
	
	private String turno;
	
	private Turno(String turno) {
		this.turno = turno;
	}
}
