package Articoli;
import java.util.ArrayList;
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
		public void AggiungiArticolo(Articolo articolo) 
		{
			ArrayDiArticoli.add(articolo);//con questo aggiungiamo l'oggetto articolo all'array di articoli
		}
		
		
		//Stampa tutti gli oggetti di articoli presenti nell'array
		public void MostraArrayDiArticoli() 
		{
			for(Articolo StampaArrayDiArticoli: ArrayDiArticoli) //questo è un for each e significa per ogni eggetto articolo che ho creato lo stampo
			{
				System.out.println(StampaArrayDiArticoli);
			}
		}
		
		//Ricerca articolo per categoria - da rivedere
		//Ricerca articolo per sconto >= sconto inserito da fare
		
		
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
		
		public void RicercaPerCategoria(String RicercaPerCategoria)
		{
			for(Articolo StampaArticoloPerCategoria: ArrayDiArticoli)
			{
				if (StampaArticoloPerCategoria.getCategoriaArticolo().equals(RicercaPerCategoria))//aVREI POTUTO USARE IL METODO IS EQUAL(CON OGGETTO) PER VERIFICARE L'UGUAGLIANZA INTERA TRA DUE OGGETTI MA DOPO L'UTENTE AVREBBE DOVUTO INSERIRE TUTTI I DATI 
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
