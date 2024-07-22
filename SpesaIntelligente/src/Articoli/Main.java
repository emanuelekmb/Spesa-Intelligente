package Articoli;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestioneArticoli gestioneArticoli = new GestioneArticoli();

        // Articoli inizali
        gestioneArticoli.AggiungiArticolo(new Articolo(123, "Mele", "Frutta", 5.5, 10));
        gestioneArticoli.AggiungiArticolo(new Articolo(456, "Prosciutto", "Carne", 7.5, 20));
        gestioneArticoli.AggiungiArticolo(new Articolo(789, "Carote", "Verdura", 2.5, 10));
        gestioneArticoli.AggiungiArticolo(new Articolo(333, "Salmone", "Pesce", 8.5, 15));
        gestioneArticoli.AggiungiArticolo(new Articolo(222, "Pere", "Frutta", 4.5, 10));

        // Loop fino all'autenticazione dell'utente
        AutenticazioneUtente(scanner, gestioneArticoli);

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
                System.out.println("Credenziali non valide. Riprova.");
            }
        }
    }

    public static void showAdminMenu(Scanner scanner, GestioneArticoli gestioneArticoli) {
        while (true) {
            System.out.println("\n0. Menu precedente.");
            System.out.println("1. Visualizza articoli.");
            System.out.println("2. Inserisci articolo.");
            System.out.println("3. Modifica articolo.");
            System.out.println("4. Elimina articolo.");
            System.out.println("5. Ricerca articoli per categoria.");
            System.out.println("6. Ricerca articoli per sconto.");

            int scelta = leggiIntero(scanner, "Scegli un'opzione: ");

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
                    System.out.print("Inserisci la categoria di prodotti che vuoi visualizzare: ");
                    String categoriaDiRicerca = scanner.nextLine();
                    gestioneArticoli.RicercaPerCategoria(categoriaDiRicerca);
                    break;
                case 6:
                    double categoriaDiSconto = leggiDouble(scanner, "Ricerca per sconto maggiore o uguale: ");
                    gestioneArticoli.RicercaPerSconto(categoriaDiSconto);
                    break;
                default:
                    System.out.println("Opzione non valida.");
                    break;
            }
        }
    }

    public static void showUserMenu(Scanner scanner, GestioneArticoli gestioneArticoli) {
        while (true) {
            System.out.println("\nSchermata user.");
            System.out.println("0. Chiudi il programma.");
            System.out.println("1. Visualizza articoli.");
            System.out.println("2. Visualizza categoria.");
            System.out.println("3. Visualizza sconti.");

            int scelta = leggiIntero(scanner, "Scegli un'opzione: ");

            switch (scelta) {
                case 0:
                    System.out.println("Hai chiuso il programma.");
                    return;
                case 1:
                    gestioneArticoli.MostraArrayDiArticoli();
                    break;
                case 2:
                    System.out.print("Inserisci la categoria di prodotti che vuoi visualizzare: ");
                    String categoria = scanner.nextLine();
                    gestioneArticoli.RicercaPerCategoria(categoria);
                    break;
                case 3:
                    double sconto = leggiDouble(scanner, "Ricerca per sconto maggiore o uguale: ");
                    gestioneArticoli.RicercaPerSconto(sconto);
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }
    }

    public static void InserisciArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) {
        int codiceArt = leggiIntero(scanner, "Inserisci il codice dell'articolo: ");
        System.out.print("Inserisci il nome dell'articolo: ");
        String nomeArt = scanner.nextLine();
        System.out.print("Inserisci la categoria dell'articolo: ");
        String categoriaArt = scanner.nextLine();
        double prezzoArt = leggiDouble(scanner, "Inserisci il prezzo dell'articolo: ");
        double scontoArt = leggiDouble(scanner, "Inserisci l'eventuale sconto dell'articolo, se non presente inserisci 0: ");

        Articolo articoloNuovo = new Articolo(codiceArt, nomeArt, categoriaArt, prezzoArt, scontoArt);
        gestioneArticoli.AggiungiArticolo(articoloNuovo);
    }

    public static void EliminaArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) {
        int articoloDaEliminare = leggiIntero(scanner, "Inserisci il codice dell'articolo da eliminare: ");
        boolean eliminato = gestioneArticoli.EliminaArticolo(articoloDaEliminare);
        if (eliminato) {
            System.out.println("Articolo eliminato");
        } else {
            System.out.println("Articolo non trovato");
        }
    }

    public static void ModificaArticolo(Scanner scanner, GestioneArticoli gestioneArticoli) {
        int codiceDiRicerca = leggiIntero(scanner, "Inserisci il codice dell'articolo da cercare: ");
        int nuovoCodice = leggiIntero(scanner, "Inserisci il nuovo codice dell'articolo: ");
        System.out.print("Inserisci il nuovo nome dell'articolo: ");
        String nuovoNome = scanner.nextLine();
        System.out.print("Inserisci la nuova categoria dell'articolo: ");
        String nuovaCategoria = scanner.nextLine();
        double nuovaPrezzo = leggiDouble(scanner, "Inserisci il nuovo prezzo dell'articolo: ");
        double nuovoSconto = leggiDouble(scanner, "Inserisci il nuovo sconto dell'articolo da modificare, se non presente inserisci 0: ");

        Articolo nuovoArticoloModificato = new Articolo(nuovoCodice, nuovoNome, nuovaCategoria, nuovaPrezzo, nuovoSconto);
        boolean modificatoArt = gestioneArticoli.ModificaArticolo(codiceDiRicerca, nuovoArticoloModificato);
        if (modificatoArt) {
            System.out.println("Articolo modificato");
        } else {
            System.out.println("Articolo non modificato");
        }
    }

    
    
    
    
    //Gli psssiamo una stringa come dato così lo personalizziamo in base a cosa faccio, elimina, modifica o altro...
    // Funzione per leggere un intero con controllo del tipo di dato
    public static int leggiIntero(Scanner scanner, String messaggio) {
    	//Non conviene farlo dentro il codice perché c'è anche il double... Così lo richiami tutte le volte quando vuoi - Per la Stringa è da vedere,  dovrei fare un for con controllo char per ogni carattere? Anche se così va bene lo stesso...
        while (true) {
            System.out.println(messaggio);
            if (scanner.hasNextInt()) {
                int valore = scanner.nextInt();
                scanner.nextLine(); // Consuma lo scANNER 
                return valore;
            } else {
                System.out.println("Errore: Inserisci un numero intero valido.");
                scanner.nextLine(); // Consuma lo scANNER non valido
            }
        }
    }

    // Funzione per leggere un double con controllo del tipo di dato
    public static double leggiDouble(Scanner scanner, String messaggio) {
        while (true) {
            System.out.println(messaggio);
            if (scanner.hasNextDouble()) {
                double valore = scanner.nextDouble();
                scanner.nextLine(); // Consuma lo scANNER 
                return valore;
            } else {
                System.out.println("Errore: Inserisci un numero decimale valido.");
                scanner.nextLine(); // Consuma lo scANNER non valido
            }
        }
    }
}
