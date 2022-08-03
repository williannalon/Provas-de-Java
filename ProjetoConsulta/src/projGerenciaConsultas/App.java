package projGerenciaConsultas;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
		ArrayList<Paciente> listaPacientes  = new ArrayList<Paciente>();
		ArrayList<Consulta>  listaConsultas   = new ArrayList<Consulta>();

		boolean sair = false;
		int escolha;

		while(!sair){
			menu();
			escolha = sc.nextInt();

			switch (escolha)
			{
			case 1:
				cadastrarMedico(listaMedicos);
				break;
			case 2:
				cadastrarPaciente(listaPacientes);
				break;
			case 3:
				agendarConsulta(listaMedicos, listaPacientes, listaConsultas);
				break;
			case 4:
				alterarConsulta(listaMedicos, listaPacientes, listaConsultas);
				break;                                
			case 5:
				buscarPessoa(listaMedicos, listaPacientes);
				break;
			case 6:
				listadeConsultas(listaConsultas);
				break;
			case 7:
				return;    
			default :
				System.out.println("OpÃ§Ã£o invalida!");
				break;
			}
		}
	}

	/* menu da aplicaÃ§Ã£o */
	public static void menu() {

		String displayMenu = "\n 1 - Cadastrar MÃ©dico     " +
				"\n 2 - Cadastrar Paciente   " + 
				"\n 3 - Agendar Consulta     " +
				"\n 4 - Alterar Consulta     " +  
				"\n 5 - Buscar Pessoa        " +
				"\n 6 - Lista Consultas"
				+ "\n 7 - Sair";

		System.out.println(displayMenu);
	}

	public static void cadastrarMedico(ArrayList<Medico> listaMedicos) {

		//CRM
		boolean CRMVali = false;
		String msgCRM = Console.leString("Digite o CRM do médico: "); 
		String CRMValidado = "";
		while (CRMVali == false ) {

			CRMVali = Validador.temApenasLetrasENumeros(msgCRM);			 
			if(CRMVali == true) {
				CRMValidado = msgCRM;
			}else {
				msgCRM = Console.leString("CRM incoreto!\n"+"Digite o CRM do médico: ");
			}
		}

		//nome
		boolean MedicoVali = false;
		String msgMedico = Console.leString("Digite o nome completo do médico (sem abreviações): ");
		String MedicoValidado = "";
		while (MedicoVali == false ) {

			MedicoVali = Validador.temApenasLetras(msgMedico);			 
			if(MedicoVali == true) {
				MedicoValidado = msgMedico;
			}else {
				msgMedico = Console.leString("nome incoreto!\n"+"Digite o nome completo do médico (sem abreviações):  ");
			}
		}

		//Especiali	
		boolean EspecVali = false;
		String msgEspec = Console.leString( "Digite a especialização do médico (sem abreviações): ");
		String EspecValidado = "";
		while (EspecVali == false ) {

			EspecVali = Validador.temApenasLetras(msgEspec);			 
			if(EspecVali == true) {
				EspecValidado = msgEspec;
			}else {
				msgEspec = Console.leString("Especialização incoreto!\n"+"Digite a especialização do médico (sem abreviações):  ");
			}
		}

		//Email
		boolean EmailVali = false;
		String msgEmail = Console.leString("Digite o email do Medico: ");
		String EmailValidado = "";
		while (EmailVali == false ) {

			EmailVali = Validador.ValidaEmail(msgEmail);			 
			if(EmailVali == true) {
				EmailValidado = msgEmail;
			}else {
				msgEmail = Console.leString("E-mail incoreto!\n"+"Digite o email do Medico: ");
			}
		}

		//Telefone
		boolean TelefoneVali = false;
		String msgTelefone= Console.leString( "Digite o telefone do médico: ");
		long TelefoneValidado = 0;
		while (TelefoneVali == false ) {

			TelefoneVali = Validador.temApenasDigitos(msgTelefone);			 
			if(TelefoneVali == true) {
				TelefoneValidado = Long.parseLong(msgTelefone);
			}else {
				msgTelefone = Console.leString("Telefone incoreto!\n"+"Digite o telefone do médico:");
			}
		}


		//Cep 
		boolean CEPVali = false;
		String msgCEP= Console.leString( "Digite o CEP do médico: ");
		String CEPValidado = "";
		while (CEPVali == false ) {

			CEPVali = Validador.validaCEP(msgCEP);			 
			if(CEPVali == true) {
				CEPValidado = msgCEP;
			}else {
				msgCEP = Console.leString("CEP incoreto!\n"+"Digite o CEP do médico:");
			}
		}

		Medico p = new Medico(CRMValidado,MedicoValidado,EspecValidado,EmailValidado,TelefoneValidado,CEPValidado); 

		listaMedicos.add(p);		
		System.out.println("Médico incluído com sucesso!");	

	}


	public static void cadastrarPaciente(ArrayList<Paciente> listaPacientes) {
		//codigo
		boolean codigoVali = false;
		String msgCodigo = Console.leString("Digite o codigo do paciente: "); 
		long codigoValidado = 0;
		while (codigoVali == false ) {

			codigoVali = Validador.temApenasDigitos(msgCodigo);			 
			if(codigoVali == true) {
				codigoValidado = Long.parseLong(msgCodigo);
			}else {
				msgCodigo= Console.leString("Codigo incoreto!\n"+"Digite o codigo do paciente: ");
			}
		}

		//nome
		boolean NomeVali = false;
		String msgNome = Console.leString("Digite o nome completo do paciente (sem abreviações): ");
		String NomeValidado = "";
		while (NomeVali == false ) {

			NomeVali = Validador.temApenasLetras(msgNome);			 
			if(NomeVali == true) {
				NomeValidado = msgNome;
			}else {
				msgNome = Console.leString("Nome incoreto!\n"+"Digite o nome completo do paciente (sem abreviações): ");
			}
		}
	

		//Email
		boolean EmailVali = false;
		String msgEmail = Console.leString("Digite o email do Paciente: ");
		String EmailValidado = "";
		while (EmailVali == false ) {

			EmailVali = Validador.ValidaEmail(msgEmail);			 
			if(EmailVali == true) {
				EmailValidado = msgEmail;
			}else {
				msgEmail = Console.leString("E-mail incoreto!\n"+"Digite o email do Paciente: ");
			}
		}

		//Telefone
		boolean TelefoneVali = false;
		String msgTelefone= Console.leString( "Digite o telefone do Paciente: ");
		long TelefoneValidado = 0;
		while (TelefoneVali == false ) {

			TelefoneVali = Validador.temApenasDigitos(msgTelefone);			 
			if(TelefoneVali == true) {
				TelefoneValidado = Long.parseLong(msgTelefone);
			}else {
				msgTelefone = Console.leString("Telefone incoreto!\n"+"Digite o telefone do Paciente:");
			}
		}


		//Cep 
		boolean CEPVali = false;
		String msgCEP= Console.leString( "Digite o CEP do Paciente: ");
		String CEPValidado = "";
		while (CEPVali == false ) {

			CEPVali = Validador.validaCEP(msgCEP);			 
			if(CEPVali == true) {
				CEPValidado = msgCEP;
			}else {
				msgCEP = Console.leString("CEP incoreto!\n"+"Digite o CEP do Paciente:");
			}
		}
		//historico
		int hist = Console.leInteiro("Paciente tem historico medico? (Responda apenas 1 para Sim ou 2 para Não.)");
		
		switch (hist) {
		case 1:
			String doenca = Console.leString("Digite o historico do paciente:");
			Paciente p = new Paciente(codigoValidado,NomeValidado,EmailValidado,TelefoneValidado,CEPValidado,doenca); 
			listaPacientes.add(p);
			break;
		case 2:
			 p = new Paciente(codigoValidado,NomeValidado,EmailValidado,TelefoneValidado,CEPValidado); 
			 listaPacientes.add(p);
			break;
		default:
			break;
		}
	
		
			
		System.out.println("Paciente incluído com sucesso!");

	}


	public static void agendarConsulta(ArrayList<Medico> listaMedicos, ArrayList<Paciente> listaPacientes, 
			ArrayList<Consulta> listaConsultas) throws ParseException {

		// Seleciona o médico para a consulta
		Medico medicoConsulta = null;

		int numMedico = 1;
		System.out.println("\nMedicos disponíveis: ");				
		for (Medico m : listaMedicos) {
			System.out.println("\t" + numMedico + " - " + m.getNome());
			numMedico++; 
		}

		int numMedSelecao = Console.leInteiro("\nDigite o número do médico: ");

		while ( !(numMedSelecao > 0 && numMedSelecao <= listaMedicos.size()) ) {
			System.out.println("Posição do médico inválida!");
			numMedSelecao = Console.leInteiro("Digite o número do médico: ");
		}

		medicoConsulta = listaMedicos.get(numMedSelecao-1); 


		//paciente para consulta
		Paciente pacienteConsulta = null;


		int numPaciente = 1;
		System.out.println("\nPacientes cadastrados: ");
		for (Paciente p : listaPacientes) {
			System.out.println("\t" + numPaciente + " - " + p.getNome());
			numPaciente++; 
		}

		int numPacSelecao = Console.leInteiro("Digite o número do paciente: ");


		while (!(numPacSelecao > 0 && numPacSelecao <= listaPacientes.size())) {
			System.out.println("Posição do paciente inválida!");
			numPacSelecao = Console.leInteiro("Digite o número do paciente: ");
		}	

		pacienteConsulta = listaPacientes.get(numPacSelecao-1); 

		//		mensagens de data e hora
		//Data
		boolean DataVali = false;
				String msgData = Console.leString("Digite a data da consulta (formato DD/MM/YYYY): "); 
				String DataValidado = "";
				while (DataVali == false ) {

					DataVali = Validador.dataValida(msgData);			 
					if(DataVali == true) {
						DataValidado = msgData;
					}else {
						msgData = Console.leString("Data incoreto!\n"+"Digite a data da consulta (formato DD/MM/YYYY): ");
					}
				}
			
		
		//Hora
		boolean HoraVali = false;
		String msgHora = Console.leString("Digite a hora da consulta (formato hh:mm) : "); 
		String HoraValidado = "";
		while (HoraVali == false ) {

			HoraVali = Validador.horaValida(msgHora);			 
			if(HoraVali == true) {
				HoraValidado = msgHora;
			}else {
				msgHora = Console.leString("Hora incoreta!\n"+"Digite a hora da consulta (formato hh:mm) : ");
			}
		}
		
		
		
		LocalDateTime DataHora = Validador.StringData(DataValidado + " " + HoraValidado);
		boolean exConsul = false;
		for (Consulta d : listaConsultas) {
			LocalDateTime dataConsulta = Validador.StringData(d.getData() + " " + d.getHora());
			
			
			if(dataConsulta.compareTo(DataHora) == 0) {
				exConsul = true;
				break;
					
			}
			}
		
		if(exConsul) {
			System.err.println("horario já tem uma  consulta marcada");
		}else {
			Consulta c = new Consulta(pacienteConsulta,
				DataValidado,
				HoraValidado,
				medicoConsulta); 
			// Adiciona na lista de consultas
			listaConsultas.add(c);
			System.out.println("Consulta incluída com sucesso!");		
		}

		

	}

	
	public static void alterarConsulta(ArrayList<Medico> listaMedicos, ArrayList<Paciente> listaPacientes, 
			ArrayList<Consulta> listaConsultas) throws ParseException {
			Consulta selecinaConsulta = null;
		int numConsulta = 1;
		System.out.println("\nConsultas: ");				
		for (Consulta c : listaConsultas) {
			System.out.println("\t" + numConsulta + " - " + c);
			numConsulta++; 
		}
		
		int numConsultaSelecao = Console.leInteiro("Digite o número da consulta: ");


		while (!(numConsultaSelecao > 0 && numConsultaSelecao <= listaConsultas.size())) {
			System.out.println("Posição da consulta inválida!");
			numConsultaSelecao = Console.leInteiro("Digite o número da consulta:: ");
		}	
		
		 selecinaConsulta = listaConsultas.get(numConsultaSelecao-1); 
		 
		 int numAlteracao = 0;
		 do {
			 numAlteracao = Console.leInteiro("Digite 1(Para alterar Horario), 2(Para alterar data), 3(para sair) ");
				
			 if(numAlteracao == 1) {
				 boolean HoraVali = false;
					String msgHora = Console.leString("Digite a hora da consulta (formato hh:mm) : "); 
					String HoraValidado = "";
					while (HoraVali == false ) {

						HoraVali = Validador.horaValida(msgHora);			 
						if(HoraVali == true) {
							HoraValidado = msgHora;
						}else {
							msgHora = Console.leString("Hora incoreta!\n"+"Digite a hora da consulta (formato hh:mm) : ");
						}
						
						LocalDateTime DataHora = Validador.StringData(selecinaConsulta.getData() + " " + HoraValidado);
						boolean exConsul = false;
						for (Consulta d : listaConsultas) {
							LocalDateTime dataConsulta = Validador.StringData(d.getData() + " " + d.getHora());
							
							
							if(dataConsulta.compareTo(DataHora) == 0) {
								exConsul = true;
								break;
									
							}
							}
						
						if(exConsul) {
							System.err.println("horario já tem uma  consulta marcada");
						}else {
							listaConsultas.get(numConsultaSelecao-1).setHora(HoraValidado);
							System.out.println("Hora mudada com sucesso!");		
						}

				}
						 
			 }
			if (numAlteracao == 2) {
					boolean DataVali = false;
					String msgData = Console.leString("Digite a data da consulta (formato DD/MM/YYYY): "); 
					String DataValidado = "";
					while (DataVali == false ) {

						DataVali = Validador.dataValida(msgData);			 
						if(DataVali == true) {
							DataValidado = msgData;
						}else {
							msgData = Console.leString("Data incoreto!\n"+"Digite a data da consulta (formato DD/MM/YYYY): ");
						}
						
						LocalDateTime DataHora = Validador.StringData(DataValidado + " " + selecinaConsulta.getHora());
						boolean exConsul = false;
						for (Consulta d : listaConsultas) {
							LocalDateTime dataConsulta = Validador.StringData(d.getData() + " " + d.getHora());
							
							
							if(dataConsulta.compareTo(DataHora) == 0) {
								exConsul = true;
								break;
									
							}
							}
						
						if(exConsul) {
							System.err.println("horario já tem uma  consulta marcada");
						}else {
							listaConsultas.get(numConsultaSelecao-1).setData(DataValidado);
							System.out.println("Data mudada com sucesso!");		
						}
					
						
					}
					
				}
		} while (numAlteracao != 3);

		
		
	}


	public static void buscarPessoa(ArrayList<Medico> listaMedicos, ArrayList<Paciente> listaPacientes) {
		
		String nomeBusca = Console.leString("Informe o nome da pessoa para realização da busaca:");

		for (Medico m : listaMedicos) {
			if(m.getNome().contains(nomeBusca)) {
				System.out.println("Medico:\n"+"Dr." + m);
			}
			
		}
		for (Paciente p : listaPacientes) {
			if(p.getNome().contains(nomeBusca)) {
				System.out.println("Paciente " + p);
			}
		}
	}

	public static void listadeConsultas(ArrayList<Consulta> listaConsultas){
		Collections.sort(listaConsultas);

		for (Consulta c : listaConsultas) {
			System.out.println(c);	
		}
		
		
		
	}
	
}
