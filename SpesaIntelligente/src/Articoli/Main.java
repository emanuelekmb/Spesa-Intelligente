package Articoli;
import java.util.Scanner;



public class Main 
{
	
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		GestioneArticoli gestioneArticoli = new GestioneArticoli();
		Articolo articoloprecompilato = new Articolo (123, "Mele","Frutta",5.5,10);
		gestioneArticoli.AggiungiArticolo(articoloprecompilato);
		articoloprecompilato = new Articolo (456, "Prosciutto","Carne",7.5,20);
		gestioneArticoli.AggiungiArticolo(articoloprecompilato);
		articoloprecompilato = new Articolo (789, "Carote","Verdura",2.5,10);
		gestioneArticoli.AggiungiArticolo(articoloprecompilato);
		articoloprecompilato = new Articolo (333, "Salmone","Pesce",8.5,15);
		gestioneArticoli.AggiungiArticolo(articoloprecompilato);
		articoloprecompilato = new Articolo (222, "Pere","Frutta",4.5,10);
		gestioneArticoli.AggiungiArticolo(articoloprecompilato);
		// Loop fino all'autenticazione dell'utente
		AutenticazioneUtente(scanner,gestioneArticoli);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	public static void AutenticazioneUtente (Scanner scanner,GestioneArticoli gestioneArticoli) 
	{
		
		User admin = new User("admin", "admin", true);
		User normalUser = new User("user", "user", false);
		Boolean authenticated = false;
	
		while (!authenticated) 
		{
			
			System.out.print("Inserisci username: ");
			String username = scanner.nextLine();
			System.out.print("Inserisci password: ");
			String password = scanner.nextLine();

			if (admin.getUsername().equals(username) && admin.authenticated(password)) 
			{
				
				authenticated = true;
				showAdminMenu(scanner, gestioneArticoli);
			} 
			else if (normalUser.getUsername().equals(username) && normalUser.authenticated(password)) {
				
				authenticated = true;
				showUserMenu(scanner,gestioneArticoli);
			} 
			else 
			{
				System.out.println("Credenziali non valide. Riprova.");
			}
			}
	
	
	}
	
	
	public static void showAdminMenu(Scanner scanner, GestioneArticoli gestioneArticoli) {
		
		//Ciclo per utente admin
		while(true)
		{
			
			System.out.println("\n0. Menu precedente.\n");//ok
			System.out.println("1. Visualizza articoli.\n");//ok
			System.out.println("2. Inserisci articolo.\n");//ok
			System.out.println("3. Modifica articolo.\n");//ok
			System.out.println("4. Elimina articolo.\n");//ok
			System.out.println("5. Ricerca articoli per categoria .\n");
			System.out.println("6. Ricerca articoli per sconto.\n");
			
			//Visualizza articoli per categoria e per sconto - per lo sconto utilizza un for each e dentro un if e stampi tutti i valori maggiori - esempio 20% e 30% ma non il contrario
			System.out.println();
			int scelta = scanner.nextInt();
			scanner.nextLine();
		//Costruttore condizionale
				switch(scelta) {
				case 0:
					//Torna al menu precedente
					AutenticazioneUtente(scanner,gestioneArticoli);
					return;
				case 1:
					gestioneArticoli.MostraArrayDiArticoli();
					break;
				case 2:
					InserisciArticolo(scanner,gestioneArticoli);
					break;
				case 3:
					ModificaArticolo(scanner, gestioneArticoli);
					
					break;
				case 4:
					EliminaArticolo(scanner, gestioneArticoli);
					break;
				case 5:
					System.out.println("\nInserisci la categoria di prodotti che vuoi visualizzare:\n");
					String CategoriaDiRicerca =scanner.nextLine();
					//chiamata della funzione per la visualizzazione di tutte le categoria filtrate per CategoriaDiRicerca
					
					gestioneArticoli.RicercaPerCategoria(CategoriaDiRicerca);
					break;
					
				case 6:
					System.out.println("\nRicerca per sconto maggiore o uguale:\n");
					double CategoriaDiSconto =scanner.nextDouble();
					//chiamata della funzione per la visualizzazione di tutte le categoria filtrate per CategoriaDiRicerca
					
					gestioneArticoli.RicercaPerSconto(CategoriaDiSconto);
					break;			
					
				default:
					System.out.println("Opzione non valida.");
					break;
				
				
				
					}
		}
	}
	
	public static void showUserMenu(Scanner scanner, GestioneArticoli gestioneArticoli) 
	{
		while (true) {
			System.out.println("\nSchermata user.!\n");
			System.out.println("\n0. Chiudi il programma.\n");//ok
			System.out.println("1. Visualizza articoli\n");//ok
			System.out.println("2. Visualizza categoria\n");
			System.out.println("3. Visualizza sconti\n");
			System.out.println("Scegli un'opzione: \n");

		int scelta = scanner.nextInt();
		scanner.nextLine();

		switch (scelta) {
			case 1:
				gestioneArticoli.MostraArrayDiArticoli();         
			   break;
			case 2:
			 //Mostrra in base alla categoria
			   break;
			case 3:
				 //Mostra in base allo sconto inserito>=
				   break;
			case 0:
			   System.out.println("Hai chiuso il programma.");
			   return; 
			default:
			   System.out.println("Scelta non valida.");
			   }
		}

	}
	
	
	
	public static void InserisciArticolo(Scanner scanner, GestioneArticoli gestioneArticoli)
	{
	System.out.println("\nInserisci il codice dell'articolo:\n");
	int CodiceArt=scanner.nextInt();
	scanner.nextLine(); // Consuma il newline e ripulisce il contenitore scanner
	System.out.println("Inserisci il nome dell'articolo:\n");
	String NomeArt=scanner.nextLine();

	System.out.println("\nInserisci la categoria dell'articolo:\n");
	String CategoriaArt=scanner.nextLine();
	System.out.println("\nInserisci il prezzo dell'articolo:");
	double PrezzoArt=scanner.nextDouble();
	scanner.nextLine(); // Consuma il newline e ripulisce il contenitore scanner
	System.out.println("\nInserisci l'eventuale sconto dell'articolo, se non presente inserisci 0.\n");
	double ScontoArt=scanner.nextDouble();
	scanner.nextLine(); // Consuma il newline e ripulisce il contenitore scanner
	Articolo articolonuovo = new Articolo (CodiceArt, NomeArt,CategoriaArt,PrezzoArt,ScontoArt);
	gestioneArticoli.AggiungiArticolo(articolonuovo);
	
	}
	
	public static void EliminaArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) {
		System.out.println("\nInserisci il codice dell'articolo da eliminare:\n");
		int ArticoloDaEliminare=scanner.nextInt();
		boolean eliminato=gestioneArticoli.EliminaArticolo(ArticoloDaEliminare);
		//Stampa dell'eventuale eliminazione
		if(eliminato)
		{
			System.out.println("Articolo eliminato\n");
		}
		else
		{
			System.out.println("Articolo non trovato\n");
		}
	}
	
	

	
	
	
	public static void ModificaArticolo(Scanner scanner, GestioneArticoli gestioneArticoli)
	{
		System.out.println("Inserisci il codice dell'articolo da cercare:");
		int CodiceDiRicerca =scanner.nextInt();
		System.out.println("Inserisci il nuovo codice dell'articolo:");
		int NuovoCodice =scanner.nextInt();
		scanner.nextLine();//Ripuliamo scanner
		System.out.println("Inserisci il nuovo nome dell'articolo da modificare:");
		String NuovoNome =scanner.nextLine();
	
		System.out.println("Inserisci la nuova categoria dell'articolo da modificare:");
		String NuovaCategoria =scanner.nextLine();
		
		System.out.println("Inserisci il nuovo prezzo dell'articolo da modificare:");
		double NuovaPrezzo =scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Inserisci il nuovo sconto dell'articolo da modificare, se non presente inserisci 0:");
		double NuovoSconto =scanner.nextDouble();
		scanner.nextLine();
		//Creiamo un nuovo oggetto con questi dati
		Articolo NuovoArticoloModificato= new Articolo(NuovoCodice, NuovoNome, NuovaCategoria,NuovaPrezzo,NuovoSconto);
		//chiamata della funzione per la modifica del cliente
		boolean modificatoArt = gestioneArticoli.ModificaArticolo(CodiceDiRicerca, NuovoArticoloModificato);
		//diamo conferma viisca all'operatore
		if(modificatoArt)
		{
			System.out.println("Cliente modificato\n");
		}
		else
		{
			System.out.println("Cliente non modificato\n");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
	


