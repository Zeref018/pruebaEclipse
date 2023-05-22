package com.empresa.model;

public class Cliente {
	public int sessions;
	public int competiciones;
	public String nombre;
	public String nivel;
	public String peso;
	
	public Cliente(int sessions, int competiciones, String nombre, String nivel, String peso) {
		super();
		this.sessions = sessions;
		this.nombre = nombre;
		this.competiciones = competiciones;
		this.nivel = nivel;
		this.peso = peso;
	}

	public int getSessions() {
		return sessions;
	}

	public void setSessions(int sessions) {
		this.sessions = sessions;
	}

	public int getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(int competiciones) {
		this.competiciones = competiciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	
	
	
}
