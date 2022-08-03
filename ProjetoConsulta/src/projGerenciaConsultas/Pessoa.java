package projGerenciaConsultas;

public abstract class Pessoa {
	
	protected String nome;
	protected String email; 
	protected long telefones;
	protected String CEP;
	 
	public Pessoa(String nome, String email, long telefones, String CEP) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefones = telefones;
		this.CEP = CEP;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefones() {
		return telefones;
	}

	public void setTelefones(int telefones) {
		this.telefones = telefones;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	
	
	
	
	 
	 
	 
	
	 
}
