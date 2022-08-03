package src;

public class Tecnico {
	String nome;
	int idade;
	String modalidade;
	float salario;
	
	
	
	public Tecnico(String nome, int idade, String modalidade, float salario) {
		this.nome = nome;
		this.idade = idade;
		this.modalidade = modalidade;
		this.salario = salario;
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
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String toString() {
		String s = "\nNome: " + nome +
				    "\nModalidade: "+ modalidade;
		return s;
	}
	
	
}
