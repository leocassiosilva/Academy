package br.com.academy.Enums;

public enum Status {
	ATIVO("ATIVO"), 
	INATIVO("Inativo"),
	TRANCADO("Trancado"),
	CANCELADO("Cancelado");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}
}
