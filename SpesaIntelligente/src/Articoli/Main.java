package Articoli;

import java.util.Scanner;
import java.time.*;
public class Main {

   	

	public static void main(String[] args) 
    {
		LocalDate DataDiOggi = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        GestioneArticoli gestioneArticoli = new GestioneArticoli();
 

        // Articoli inizali - La data di inizio e fine offerta fa riferimento ad oggi...
        gestioneArticoli.AggiungiArticoloCompleto(new Articolo(001, "Mele", "Frutta", 2.5, 10,DataDiOggi, DataDiOggi));
        gestioneArticoli.AggiungiArticoloCompleto(new Articolo(002, "Prosciutto Cotto", "Salumi", 3, 20,DataDiOggi,DataDiOggi));
        gestioneArticoli.AggiungiArticoloCompleto(new Articolo(003, "Carote", "Verdura", 2.2, 10,DataDiOggi,DataDiOggi));
        gestioneArticoli.AggiungiArticoloCompleto(new Articolo(004, "Salmone", "Pesce", 4.5, 15,DataDiOggi,DataDiOggi));
        gestioneArticoli.AggiungiArticoloCompleto(new Articolo(005, "Pere", "Frutta", 3.7, 30,DataDiOggi,DataDiOggi));

        // Loop fino all'autenticazione dell'utente 
        //Dopo lo attiviamo AutenticazioneUtente(scanner, gestioneArticoli);
        showAdminMenu(scanner, gestioneArticoli);
        // Chiudiamo lo scanner alla fine
        scanner.close();
    }

    public static void AutenticazioneUtente(Scanner scanner, GestioneArticoli gestioneArticoli) {
        User admin = new User("admin", "admin", true);
        User normalUser = new User("user", "user", false);
        boolean authenticated = false;

        while (!authenticated) {
            System.out.print("Inserisci username: ");
            String username = scanner.nextLine();
            System.out.print("Inserisci password: ");
            String password = scanner.nextLine();

            if (admin.getUsername().equals(username) && admin.authenticated(password)) {
                authenticated = true;
                showAdminMenu(scanner, gestioneArticoli);
            } else if (normalUser.getUsername().equals(username) && normalUser.authenticated(password)) {
                authenticated = true;
                showUserMenu(scanner, gestioneArticoli);
            } else {
                System.out.println("\nCredenziali non valide. Riprova.\n");
            }
        }
    }

    public static void showAdminMenu(Scanner scanner, GestioneArticoli gestioneArticoli) {
        while (true) {
            System.out.println("\n0. Menu precedente.");
            System.out.println("1. Visualizza articoli.");
            System.out.println("2. Inserisci articolo.");
            System.out.println("3. Modifica articolo completo.");
            System.out.println("4. Elimina articolo.");
            System.out.println("5. Ricerca articoli per categoria.");
            System.out.println("6. Ricerca articoli per sconto.");
            System.out.println("7. Modifica data inizio sconto.");
            System.out.println("8. Modifica data fine sconto.");
            System.out.println("9. Modifica prezzo.");
            System.out.println("10. Modifica sconto.");
            int scelta = VerificaIntero(scanner, "Scegli un'opzione: ");

            switch (scelta) {
                case 0:
                    AutenticazioneUtente(scanner, gestioneArticoli);
                    return;
                case 1:
                    gestioneArticoli.MostraArrayDiArticoli();
                    break;
                case 2:
                    InserisciArticolo(scanner, gestioneArticoli);
                    break;
                case 3:
                    ModificaArticolo(scanner, gestioneArticoli);
                    break;
                case 4:
                    EliminaArticolo(scanner, gestioneArticoli);
                    break;
                case 5:
                    String categoriaDiRicerca = VerificaStringa(scanner, "\nInserisci la categoria di prodotti che vuoi visualizzare:");
                    gestioneArticoli.RicercaPerCategoria(categoriaDiRicerca);
                    break;
                case 6:
                    double categoriaDiSconto = VerficaDouble(scanner, "Ricerca per sconto maggiore o uguale: ");
                    gestioneArticoli.RicercaPerSconto(categoriaDiSconto);
                    break;
                case 7:
                	ModificaDataInizioSconto(scanner, gestioneArticoli);
                    break;
                case 8:
                	ModificaDataFineSconto(scanner, gestioneArticoli);
                    break;
                case 9:
                   ModificaPrezzo(scanner, gestioneArticoli);
                    break;
                case 10:
                	ModificaSconto(scanner, gestioneArticoli);
                    break;
                default:
                    System.out.println("Opzione non valida.");
                    break;
            }
        }
    }

    public static void showUserMenu(Scanner scanner, GestioneArticoli gestioneArticoli) {
        while (true) {
            System.out.println("\nUser\n");
            System.out.println("\n0. Menu precedente.\n");
            System.out.println("\n1. Visualizza articoli.\n");
            System.out.println("\n2. Visualizza categoria.\n");
            System.out.println("\n3. Visualizza sconti.\n");

            int scelta = VerificaIntero(scanner, "\nScegli un'opzione: \n");

            switch (scelta) {
                case 0:
                	AutenticazioneUtente(scanner, gestioneArticoli);
                    return;
                case 1:
                    gestioneArticoli.MostraArrayDiArticoli();
                    break;
                case 2:
                    System.out.print("\nInserisci la categoria di prodotti che vuoi visualizzare: \n");
                    String categoria = scanner.nextLine();
                    gestioneArticoli.RicercaPerCategoria(categoria);
                    break;
                case 3:
                    double sconto = VerficaDouble(scanner, "\nRicerca per sconto maggiore o uguale: \n");
                    gestioneArticoli.RicercaPerSconto(sconto);
                    break;
                default:
                    System.out.println("\nScelta non valida.\n");
                    break;
            }
        }
    }

    
    
    
    public static void InserisciArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) 
    {
    	while(true) {
        int codiceArt = VerificaIntero(scanner, "\nInserisci il codice dell'articolo: \n");
        //mettere qui la verifica se c'è o meno il codice articolo
        boolean verificacodici = gestioneArticoli.VerificaCodice(codiceArt);
        if (verificacodici)//NB di default verifica se è true
        {
        String nomeArt=VerificaStringa(scanner, "\nInserisci il nome dell'articolo: \n");
        //String nomeArt = scanner.nextLine();
        String categoriaArt = VerificaStringa(scanner, "\nInserisci la categoria dell'articolo: \n");
        double prezzoArt = VerficaDouble(scanner, "\nInserisci il prezzo dell'articolo: \n");
        double scontoArt = VerficaDouble(scanner, "\nInserisci l'eventuale sconto dell'articolo, se non presente inserisci 0: \n");
        LocalDate DataInizioOff=null;
        LocalDate DataFineOff=null;
        if(scontoArt>0)
        {
        
        
        while (true) {
            DataInizioOff = InputEVerificaData(scanner, "\nInserisci la data di inizio offerta:\n");
            DataFineOff = InputEVerificaData(scanner, "\nInserisci la data di fine offerta:\n");
            
            if (DataInizioOff.isAfter(DataFineOff)) {
                System.out.println("La data di inizio offerta non può essere successiva alla data di fine offerta.");
            } else {
                break; // Esci dal ciclo solo se le date sono corrette
            }
        }
        }
        
        Articolo articoloNuovo = new Articolo(codiceArt, nomeArt, categoriaArt, prezzoArt, scontoArt,DataInizioOff,DataFineOff);
        gestioneArticoli.AggiungiArticoloCompleto(articoloNuovo);
        break;
        }
        
    	}
    }

    public static LocalDate InputEVerificaData(Scanner scanner, String messaggio) 
    {
    	LocalDate DataDiOggi = LocalDate.now();
        while (true) {
           
                System.out.println(messaggio);
                int anno=VerificaIntero(scanner, "Anno: ");
                int mese=VerificaIntero(scanner, "Mese: ");
                int giorno=VerificaIntero(scanner, "Giorno: ");
                LocalDate DataInserita = LocalDate.of(anno, mese, giorno);

                if (DataInserita.isAfter(DataDiOggi)) 
                {
                    return DataInserita;
                } 
                else 
                {
                    System.out.println("La data inserita non può essere precedente a quella di oggi.");
                    scanner.nextLine();
                }
            
                
            }
        }
    
    public static void EliminaArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) {
        int articoloDaEliminare = VerificaIntero(scanner, "Inserisci il codice dell'articolo da eliminare: ");
        boolean eliminato = gestioneArticoli.EliminaArticolo(articoloDaEliminare);
        if (eliminato) {
            System.out.println("Articolo eliminato");
        } else {
            System.out.println("Articolo non trovato");
        }
    }

    
    public static int inserisciEVerificaArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) {
        while (true) {
            int codiceDiRicerca = VerificaIntero(scanner, "Inserisci il codice dell'articolo da cercare: ");
            boolean verificacodici = gestioneArticoli.VerificaCodiceSePresente(codiceDiRicerca);
            if (verificacodici) {
                return codiceDiRicerca;
            } else {
                System.out.println("Codice articolo non trovato. Riprova.");
            }
        }
    }

    public static void ModificaPrezzo(Scanner scanner, GestioneArticoli gestioneArticoli) {
        while (true) {
            int codiceDiRicerca = inserisciEVerificaArticolo(scanner, gestioneArticoli);
            double nuovoPrezzo = VerficaDouble(scanner, "Inserisci il nuovo prezzo dell'articolo: ");
            boolean modificatoArt = gestioneArticoli.ModificaPrezzo(codiceDiRicerca, nuovoPrezzo);
            if (modificatoArt) {
                System.out.println("Prezzo modificato");
                break;
            } else {
                System.out.println("Errore nella modifica del prezzo. Riprova.");
            }
        }
    }
    
    
    
  
    
    /*public static void ModificaSconto(Scanner scanner, GestioneArticoli gestioneArticoli)
    {
    	int codiceDiRicerca = VerificaIntero(scanner, "Inserisci il codice dell'articolo da cercare: ");
    	boolean ScontoModificato = gestioneArticoli.ModificaArticolo(codiceDiRicerca, nuovoArticoloModificato);
    	 if (ScontoModificato) {
             System.out.println("Articolo modificato");
         } else {
             System.out.println("Articolo non modificato");
         }
    }    */
    
    public static void ModificaArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) {
    	 while (true) {
             int codiceDiRicerca = inserisciEVerificaArticolo(scanner, gestioneArticoli);//Qui verifichiamo se il codice è presente nell'array
             int nuovoCodice = VerificaIntero(scanner, "Inserisci il nuovo codice dell'articolo: ");
             boolean verificacodici = gestioneArticoli.VerificaCodice(nuovoCodice);//COn verifica codice facciamo l'inverso e controlliamo che il nuovo codice inserito dall'utente non sia già presente
             if (verificacodici) {
                 String nuovoNome = VerificaStringa(scanner, "Inserisci il nuovo nome dell'articolo: ");
                 String nuovaCategoria = VerificaStringa(scanner, "Inserisci la nuova categoria dell'articolo: ");
                 double nuovoPrezzo = VerficaDouble(scanner, "Inserisci il nuovo prezzo dell'articolo: ");
                 double nuovoSconto = VerficaDouble(scanner, "Inserisci il nuovo sconto dell'articolo da modificare, se non presente inserisci 0: ");
                 LocalDate DataInizioOff;
                 LocalDate DataFineOff;

                 while (true) {
                     DataInizioOff = InputEVerificaData(scanner, "\nInserisci la data di inizio offerta:\n");
                     DataFineOff = InputEVerificaData(scanner, "\nInserisci la data di fine offerta:\n");

                     if (DataInizioOff.isAfter(DataFineOff)) {
                         System.out.println("La data di inizio offerta non può essere successiva alla data di fine offerta.");
                     } else {
                         break; // Esci dal ciclo solo se le date sono corrette
                     }
                 }

                 Articolo nuovoArticoloModificato = new Articolo(nuovoCodice, nuovoNome, nuovaCategoria, nuovoPrezzo, nuovoSconto, DataInizioOff, DataFineOff);
                 boolean modificatoArt = gestioneArticoli.ModificaArticolo(codiceDiRicerca, nuovoArticoloModificato);
                 if (modificatoArt) {
                     System.out.println("Articolo modificato");
                     break;
                 } else {
                     System.out.println("Errore nella modifica dell'articolo. Riprova.");
                 }
             } else {
                 System.out.println("Il nuovo codice dell'articolo è già presente. Riprova.");
             }
         }
     }

    
    
    
    
    public static int VerificaIntero(Scanner scanner, String messaggio) {
    	//Non conviene farlo dentro il codice perché c'è anche il double... Così lo richiami tutte le volte quando vuoi - Per la Stringa è da vedere,  dovrei fare un for con controllo char per ogni carattere? Anche se così va bene lo stesso...
        while (true) {
            System.out.println(messaggio);
            
            if (scanner.hasNextInt()) {
            	int valore = scanner.nextInt();
                scanner.nextLine(); // Consuma lo scANNER 
                return valore;
            } else {
                System.out.println("\nErrore: Inserisci un numero intero valido.\n");
                scanner.nextLine(); // Consuma lo scANNER non valido
            }
        }
    }
    
    
    // Funzione per leggere una Stringa con controllo del tipo di dato
    public static String VerificaStringa(Scanner scanner, String messaggio) {
    	
    	while (true) {
    			System.out.println(messaggio);
                String valore = scanner.nextLine().trim();//.trim elimina gli spazi vuoti
                if (valore ==null || valore.isEmpty()|| valore.isBlank())
                {
                
                System.out.println("\nErrore: Inserisci una stringa valida.\n");
                } 
                else 
                {
                	boolean SoloLettere=true;
                	for (char ControlliamoCarattere : valore.toCharArray()) 
                	{
                		if (!Character.isLetter(ControlliamoCarattere)) 
                		{
                			 System.out.println("\nErrore: Inserisci solo lettere nella stringa.\n");
                			 SoloLettere=false;
                			 
                		}
                	}	
                	/*Bisogna rivedere il booleano perchè con il ciclo for sulla stringa mi stampa l'errore per 
                	per quante volte ho inserito un valore non valido...
                	
                	*/
                	if(SoloLettere)
                	{
                	return valore;	
                	}
                	
                }
        }
    }

    // Funzione per leggere un double con controllo del tipo di dato
    public static double VerficaDouble(Scanner scanner, String messaggio) {
        while (true) {
            System.out.println(messaggio);
           
            if (scanner.hasNextDouble()) {
            	 double valore = scanner.nextDouble();
                scanner.nextLine(); // Consuma lo scANNER 
                return valore;
            } else {
                System.out.println("\nErrore: Inserisci un numero con la virgola valido.\n");
                scanner.nextLine(); // Consuma lo scANNER non valido
            }
        }
    }
}
