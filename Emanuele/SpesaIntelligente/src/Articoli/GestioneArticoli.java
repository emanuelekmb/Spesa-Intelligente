package Articoli;
import java.util.ArrayList;
import java.time.*;
public class GestioneArticoli {

	
	//attributi della classe - creiamo l'arraylist di oggetti
	private ArrayList<Articolo> ArrayDiArticoli;
		
	public boolean test=false;//Ci servirà dopo per verificare se in fase di inserimento un codice esiste già
	
	//costruttore
		public GestioneArticoli()
		{
			this.ArrayDiArticoli=new ArrayList<>();
		}
		
		
		//metodi per la gestione
		
		
		//Inserimento nuovo articolo 
		public void AggiungiArticoloCompleto(Articolo articolo) 
		{
				ArrayDiArticoli.add(articolo);
			   	System.out.println("\nArticolo aggiunto.\n");
		}
		//verifichiamo se l'articolo esiste già con un for each e con dentro un if
		public boolean VerificaCodice( int code)
		{
			if (code<=0 || code>=1000)
			{
			System.out.println("\nPuoi inserire solo un codice articolo compreso tra 001 e 1000 \n");
			return false;
			}
			else
			{
			for (Articolo ArticoloEsisteOppureNo : ArrayDiArticoli) 
			{//for each e verifichiamo se esiste già
	            if (ArticoloEsisteOppureNo.getCodiceArticolo() == code) 
	            {
	               
	                System.out.println("\nArticolo già presente.\n");
	               
	                return false;
	            }
	        }
			//Altrimenti finisce il ciclo for ed esce e riprende il valore true
	        return true;
			}
				
		}
		
		
		public LocalDate getDataFineOfferta(int codiceArticolo) {
	        Articolo articolo = CercaArticoloPerCodice(codiceArticolo);
	            return articolo.getDataFineOfferta(); 
	    }
		//Queste due funzioni sono da rivedere - portiamo di qua parte di quello scritto sul main per la mdoifica della data
		
		public LocalDate getInizioInizioOfferta(int codiceArticolo) {
	        Articolo articolo = CercaArticoloPerCodice(codiceArticolo);
	            return articolo.getDataInizioOfferta(); 
	    }
		
		public boolean VerificaCodiceSePresente( int code)
		{
			if (code<=0 || code>=1000)
			{
			System.out.println("\nPuoi inserire solo un codice articolo compreso tra 001 e 1000 \n");
			return false;
			}
			else
			{
			for (Articolo ArticoloEsisteOppureNo : ArrayDiArticoli) 
			{//for each e verifichiamo se esiste già
	            if (ArticoloEsisteOppureNo.getCodiceArticolo() == code) 
	            {
	            	return true;
	            }
	        }
			//Altrimenti finisce il ciclo for ed esce e riprende il valore true
			 System.out.println("\nArticolo non presente.\n");
			return false;
			
			}
				
		}
		
		 public void ModificaPrezzo(int codice, double nuovoPrezzo) {
		        for (Articolo articolo : ArrayDiArticoli) {
		            if (articolo.getCodiceArticolo() == codice) {
		                articolo.setPrezzoArticolo(nuovoPrezzo);
		                break;
		            }
		        }
		    }

		    public void ModificaSconto(int codice, double nuovoSconto) {
		        for (Articolo articolo : ArrayDiArticoli) {
		            if (articolo.getCodiceArticolo() == codice) {
		                articolo.setScontoArticolo(nuovoSconto);
		                break;
		            }
		        }
		    }

		    public void ModificaDataInizioSconto(int codice, LocalDate nuovaDataInizio) {
		        for (Articolo articolo : ArrayDiArticoli) {
		            if (articolo.getCodiceArticolo() == codice) {
		                articolo.setDataInizioOfferta(nuovaDataInizio);
		                break;
		            }
		        }
		    }

		    public void ModificaDataFineSconto(int codice, LocalDate nuovaDataFine) {
		        for (Articolo articolo : ArrayDiArticoli) {
		            if (articolo.getCodiceArticolo() == codice) {
		                articolo.setDataFineOfferta(nuovaDataFine);
		                break;
		            }
		        }
		    }
		
		
		//Stampa tutti gli oggetti di articoli presenti nell'array
		public void MostraArrayDiArticoli() 
		{
			for(Articolo StampaArrayDiArticoli: ArrayDiArticoli) //questo è un for each e significa per ogni eggetto articolo che ho creato lo stampo
			{
				System.out.println(StampaArrayDiArticoli);
			}
		}
		
	//Richiamare Giorgia tipa figa contabilità
		
		
		public Articolo CercaArticoloPerCodice (int Codice) 
		{
			for(Articolo stamparticolo : ArrayDiArticoli)
			{
				if (stamparticolo.getCodiceArticolo()==Codice)//aVREI POTUTO USARE IL METODO IS EQUAL(CON OGGETTO) PER VERIFICARE L'UGUAGLIANZA INTERA TRA DUE OGGETTI MA DOPO L'UTENTE AVREBBE DOVUTO INSERIRE TUTTI I DATI 
				{
					return stamparticolo;
				}
			}
			return null;
		}
		 public static void ModificaDataInizioSconto(int codice, GestioneArticoli gestioneArticoli, LocalDate nuovaDataInizio) {
		        Articolo articolo = gestioneArticoli.CercaArticoloPerCodice(codice);
		        if (articolo != null) {
		            articolo.setDataInizioOfferta(nuovaDataInizio);
		            System.out.println("Data di inizio offerta modificata con successo.");
		        } else {
		            System.out.println("Articolo non trovato.");
		        }
		    }

		    public static void ModificaDataFineSconto(int codice, GestioneArticoli gestioneArticoli, LocalDate nuovaDataFine) {
		        Articolo articolo = gestioneArticoli.CercaArticoloPerCodice(codice);
		        if (articolo != null) {
		            articolo.setDataFineOfferta(nuovaDataFine);
		            System.out.println("Data di fine offerta modificata con successo.");
		        } else {
		            System.out.println("Articolo non trovato.");
		        }
		    }
		public void RicercaPerCategoria(String RicercaPerCategoria)
		{
			for(Articolo StampaArticoloPerCategoria: ArrayDiArticoli)
			{
				if (StampaArticoloPerCategoria.getCategoriaArticolo().equalsIgnoreCase(RicercaPerCategoria))//aVREI POTUTO USARE IL METODO IS EQUAL(CON OGGETTO) PER VERIFICARE L'UGUAGLIANZA INTERA TRA DUE OGGETTI MA DOPO L'UTENTE AVREBBE DOVUTO INSERIRE TUTTI I DATI 
				{
					System.out.println(StampaArticoloPerCategoria);
					
				}
			}
		}
		
		
		public void RicercaPerSconto(double RicercaConSconto)
		{
			for(Articolo StampaArticoloPerSconto: ArrayDiArticoli)
			{
				if (StampaArticoloPerSconto.getScontoArticolo()>=RicercaConSconto)//aVREI POTUTO USARE IL METODO IS EQUAL(CON OGGETTO) PER VERIFICARE L'UGUAGLIANZA INTERA TRA DUE OGGETTI MA DOPO L'UTENTE AVREBBE DOVUTO INSERIRE TUTTI I DATI 
				{
					System.out.println(StampaArticoloPerSconto);
					
				}
			}
		}
		
		
		
		public boolean ModificaArticolo(int CodiceArticoloDaModificare, Articolo ArticoloDaModificare)
		{
			Articolo articolo = CercaArticoloPerCodice(CodiceArticoloDaModificare);
			if(articolo != null)
			{
				
				ArrayDiArticoli.set(ArrayDiArticoli.indexOf(articolo),ArticoloDaModificare);
				return true;
				
			}
			return false;
		} 
		
		
	
		
		public boolean EliminaArticolo(int CodiceArticoloDaEliminare) {
			Articolo articoloElimina= CercaArticoloPerCodice(CodiceArticoloDaEliminare);
			if (articoloElimina != null)
			{
				ArrayDiArticoli.remove(articoloElimina);
				return true;
			}
			return false;
		}	
	
		
		
		
	
}
