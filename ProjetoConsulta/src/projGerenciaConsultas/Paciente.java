package projGerenciaConsultas;

public class Paciente extends Pessoa {
	
	long codigo;
	String historico;
	
	//Sem doença
	public Paciente(long codigo,String nome, String email, long telefones, String CEP) {
		super(nome, email, telefones, CEP);
		this.codigo = codigo;
		this.historico = "Paciente sem histórico prévio de doenças (aparentemente).";
	}

	//Com doença
	public Paciente(long codigo,String nome, String email, long telefones, String CEP, String doenca) {
		super(nome, email, telefones, CEP);
		this.codigo = codigo;
		this.historico = "Histórico prévio: " + doenca;
	}
	
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHistorico() {
		return historico;
	}

	
	public void addHistorico(String entrada) {
		this.historico += "\n" + entrada;
	}
	
	public String toString() {
		String s = "\nCódigo: "+codigo +
				   "\nNome: "+ nome; 
		
		return s;
	}
	
	public void exibeHistorico() {
		System.out.println(historico);
	}
	
	//Metodos herdados 

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		super.setEmail(email);
	}

	@Override
	public long getTelefones() {

		return super.getTelefones();
	}

	@Override
	public void setTelefones(int telefones) {

		super.setTelefones(telefones);
	}

	@Override
	public String getCEP() {

		return super.getCEP();
	}


	public void setCEP(int cEP) {
		setCEP(cEP);
	}
	
	
	
	

}
