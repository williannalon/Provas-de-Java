package projGerenciaConsultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta implements Comparable<Consulta>{
	
	Paciente paciente;
	String data;
	String hora;
	Medico medico;
	
	public Consulta(Paciente paciente, String data, String hora, Medico medico) {
		
		this.paciente = paciente;
		this.data = data;
		this.hora = hora;
		this.medico = medico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public String toString() {
		String s = "\n" +
				   "|  Data: "     + this.data + " Hora: " + this.hora + 
				   "  |  Paciente: " + this.paciente.getNome() +    // pega o nome do paciente da consulta	   
				   "  |  Médico: "   + this.medico.getNome() + "  |";		  // pega o nome do medico da consulta	   
				   
		return s;
	}

	public void AtualizaHistorico(String informacao) {;
		String entradaHistorico = "Consulta realizada em "     + this.data + " Hora: " + this.hora + 
 				   				  "\n com o médico "   + this.medico.getNome() + " ("+ this.medico.getEspecialidade() + ")" +
 				   				  "\n Relatório da consulta: " + informacao;	   
				   
		// para adicionar a string recebida como parâmetro (String informacao)
		// no historico do paciente, use o método addHistorico da classe Paciente
		this.paciente.addHistorico(entradaHistorico);
		
	}

	@Override
	public int compareTo(Consulta o) {
		String Strdata1 = this.getData() + " " + this.getHora();
		String Strdata2 = o.getData() + " " + o.getHora();
		
		SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		try {
			Date data1 = formatData.parse(Strdata1);
			Date data2 = formatData.parse(Strdata2);
			
			return data1.compareTo(data2);
		} catch (ParseException pe) {
			System.out.println("Erro de Conversão");
		}
		return 0;
	}	
}
