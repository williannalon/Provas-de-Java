package src;

public class Jogador {
	String nome;
	String modalidade;
	int idade;
	Jogador reserva;
	

	
	public Jogador(String nome, int idade, String modalidade) {
		this.nome = nome;
		this.idade = idade;
		this.modalidade = modalidade;
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String toString() {
		String s = "\nNome: " + nome +
				    "\nModalidade: "+ modalidade;
		return s;
		
		
	}
	
	
}
