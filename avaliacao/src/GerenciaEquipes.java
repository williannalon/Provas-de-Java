package src;

import java.util.ArrayList;

import java.util.Scanner;




public class GerenciaEquipes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
		ArrayList<Tecnico> listaTecnicos  = new ArrayList<Tecnico>();
		ArrayList<Equipe>  listaEquipes   = new ArrayList<Equipe>();
				
		boolean sair = false;
        int escolha;
        
        while(!sair)   // loop para exibir o menu principal
        {
            menu();
            escolha = sc.nextInt();
            
            switch (escolha)
            {
                case 1:
                	// Cadastrar Jogador
                	cadastrarJogador(listaJogadores);
                    break;
                case 2:
                	// Cadastrar Técnico
                    cadastrarTecnico(listaTecnicos);
                    break;
                case 3:
                    // Cadastrar Equipe
                	cadastrarEquipe(listaEquipes, listaTecnicos, listaJogadores);
                    break;
                case 4:
                	// Listar Equipes
                    listarEquipes(listaEquipes);
                    break;                                
                case 5:
                    return;
                default :
                    System.out.println("Opção invalida!");
                    break;
            }
        }
	}
	
	/* Exibe o menu da aplicação */
	public static void menu() {
		
        String displayMenu = "\n 1 - Cadastrar Jogador " +
        					 "\n 2 - Cadastrar Técnico           " + 
        					 "\n 3 - Cadastrar Equipe     " +
        					 "\n 4 - Exibir Equipes           " +
        					 "\n 5 - Sair";
        
        System.out.println(displayMenu);
    }


	
	public static void cadastrarJogador(ArrayList<Jogador> jogadores) {
		
		String nomeJogador = Console.leString("Digite o nome do Jogador: ");
		String modalidadeJogador = Console.leString("Digite a modalidade do Jogador: ");
		int idadeJogador = Console.leInteiro("Digite a idade do Jogador: ");
		
		Jogador j = new Jogador(nomeJogador, idadeJogador, modalidadeJogador);
		
		
		jogadores.add(j);
		System.out.println("Jogador incluido com sucesso!");
		
	}

	public static void cadastrarTecnico(ArrayList<Tecnico> tecnicos) {
			
		String nomeTecnico = Console.leString("Digite o nome do Técnico: ");
		String modalidadeTecnico = Console.leString("Digite a modalidade do Técnico: ");
		int idadeTecnico = Console.leInteiro("Digite a idade do Técnico: ");
		float salarioTecnico = Console.leReal("Digite o salário do Técnico: ");
		
		Tecnico t = new Tecnico(nomeTecnico, idadeTecnico, modalidadeTecnico, salarioTecnico);
		
		tecnicos.add(t);
		System.out.println("Tecnico incluido com sucesso!");
		
	}
	
	public static void cadastrarEquipe(ArrayList<Equipe> equipes, ArrayList<Tecnico> tecnicos, ArrayList<Jogador> jogadores) {
		String nomeEquipe = Console.leString("Digite o nome da equipe: ");
		String modalidadeEquipe = Console.leString("Digite a modalidade da equipe: ");
		int jogadorQuantEquipe = Console.leInteiro("Digite a quantidade de Jogadores: ");
		
		Tecnico tecnicoConsuta = null;
		
		int numTecnico = 1;
		System.out.println("\nTécnicos disponiveis: ");
		
		for (Tecnico t : tecnicos) {
			System.out.println("\t" + numTecnico + "-" + t.getNome());
			numTecnico++;
		}
		
		int numTecSelecao = Console.leInteiro("\nDigite o número do Técnico: ");
		
		while ( !(numTecSelecao > 0 && numTecSelecao <= tecnicos.size()) ) {
			// Aqui estamos garantindo que o número digitado seja uma
			// posição válida do ArrayList
			System.out.println("Posição do Técnico inválida!");
			numTecSelecao = Console.leInteiro("Digite o número do Técnico: ");
		}
		
		// Agora, a partir do número digitado, vamos recuperar o objeto da lista
		// de medicos. Lembra que temos que subtrair 1, pois o ArrayList é indexado
		// a partir do 0 (zero)			
		
		 Tecnico tecnicoConsulta = tecnicos.get(numTecSelecao-1); 
		 
		 // Seleção da lista de jogadores
		 
			 ArrayList<Jogador> jogadoresEquipe = new ArrayList<Jogador>();
		 for(int i=0; i <jogadorQuantEquipe; i++) {
			 
			 
			 Jogador jogadorEquipe = null;
			 
			 // exibe a lista de jogadores com um numero  ao lado
			 
			 int numJogador = 1;
				System.out.println("\nJogadores disponiveis: ");
				
				for (Jogador j : jogadores) {
					System.out.println("\t" + numJogador + "-" + j.getNome());
					numJogador++;
				}
				
				int numJogSelecao = Console.leInteiro("\nDigite o número do Jogador: ");
				
				while ( !(numJogSelecao > 0 && numJogSelecao <= jogadores.size()) ) {
					// Aqui estamos garantindo que o número digitado seja uma
					// posição válida do ArrayList
					System.out.println("Posição do jogador inválida!");
					numJogSelecao = Console.leInteiro("Digite o número do jogador: ");
				}
				
				jogadorEquipe = jogadores.get(numJogSelecao-1);
				
				jogadoresEquipe.add(jogadorEquipe);
		 }
		 
		 Equipe e = new Equipe(nomeEquipe, modalidadeEquipe, jogadorQuantEquipe, tecnicoConsulta, jogadoresEquipe);
		 
		 equipes.add(e);
		

	}
	
	public static void listarEquipes(ArrayList<Equipe>  equipes) {
		// Itere a lista de equipes e chame o método toString de 
		// cada equipe na lista
		
		for(Equipe e: equipes) {
			System.out.println(e);
		}
	}
}
