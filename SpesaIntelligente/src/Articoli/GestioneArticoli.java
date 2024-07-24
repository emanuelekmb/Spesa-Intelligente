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
		
		
		public boolean ModificaPrezzo(int CodiceArticoloDaModificare, double NuovoPrezzo)
		{
			Articolo articolo = CercaArticoloPerCodice(CodiceArticoloDaModificare);
			if(articolo != null)
			{
				articolo.setPrezzoArticolo(NuovoPrezzo);
				return true;
				
			}
			return false;
		} 
		
		
		
		
		
		
		
		
		public boolean ModificaSconto(int CodiceArticoloDaModificare, double NuovoSconto)
		{
			Articolo articolo = CercaArticoloPerCodice(CodiceArticoloDaModificare);
			if(articolo != null)
			{
				articolo.setScontoArticolo(NuovoSconto);
				return true;
				
			}
			return false;
		} 
		
		
		
		
		
		public boolean ModificaDataInizioOfferta(int CodiceArticoloDaModificare, LocalDate NuovaDataInizio)
		{
			Articolo articolo = CercaArticoloPerCodice(CodiceArticoloDaModificare);
			if(articolo != null && articolo.getDataFineOfferta().isAfter(NuovaDataInizio))
			{
				articolo.setDataInizioOfferta(NuovaDataInizio);;
				return true;
				
			}
			return false;
		} 
		
		
		public boolean ModificaDataFineOfferta(int CodiceArticoloDaModificare, LocalDate NuovaDataInizio)
		{
			Articolo articolo = CercaArticoloPerCodice(CodiceArticoloDaModificare);
			if(articolo != null && articolo.getDataFineOfferta().isBefore(NuovaDataInizio))
			{
				articolo.setDataInizioOfferta(NuovaDataInizio);;
				return true;
				
			}
			return false;
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
