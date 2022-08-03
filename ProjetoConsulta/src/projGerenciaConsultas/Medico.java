package projGerenciaConsultas;

public class Medico extends Pessoa{
		
	String CRM;
	String especialidade;
	
	
	public Medico(String cRM, String nome,String especialidade, String email, long telefones, String CEP) {
		super(nome, email, telefones, CEP);
		
		CRM = cRM;
		this.especialidade = especialidade;
	}
	

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String toString() {
		String s = "";
		
		s += this.nome + " (CRM: " +this.CRM +" )";
		
		return s;
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

	public void setCEP(String cEP) {	
		super.setCEP(cEP);
	}
	
	
}
