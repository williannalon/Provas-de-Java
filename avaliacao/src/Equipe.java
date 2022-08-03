package src;

import java.util.ArrayList;

public class Equipe {
	String nome;
	String modalidade;
	int jogadorQuant;
	Tecnico tecnico;
	ArrayList<Jogador> Jogadores = new ArrayList<Jogador>();
	
	
	
	public Equipe(String no, String mo, int jogadorQuant, Tecnico tec,  ArrayList<Jogador> jogadores) {
		this.nome = no;
		this.modalidade = mo;
		this.jogadorQuant = jogadorQuant;
		this.tecnico = tec;
		this.Jogadores = jogadores;
	}
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getModalidade() {
		return modalidade;
	}


	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}


	public int getJogadorQuant() {
		return jogadorQuant;
	}


	public void setJogadorQuant(int jogadorQuant) {
		this.jogadorQuant = jogadorQuant;
	}


	public Tecnico getTecnico() {
		return tecnico;
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}


	public ArrayList<Jogador> getJogadores() {
		return Jogadores;
	}


	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.Jogadores = jogadores;
	}


	public String toString() {
		String nomesJogadores = "";
		
		for(Jogador j: this.Jogadores) {
			nomesJogadores += String.format("\t %s \n", j.getNome());
		}
		
		
		return String.format("Equipe: %s \n T�cnico: \t%s \n Jogadores: \n %s",
				this.nome, this.tecnico.getNome(), nomesJogadores);
	}
}
