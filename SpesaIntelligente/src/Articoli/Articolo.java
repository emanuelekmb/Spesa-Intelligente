package Articoli;
//import java.time.LocalDateTime; // Importa la data di oggi tramite la classe java.time
//import java.time.format.DateTimeFormatter; // Import la formattazione della data tramite l'altra classe
import java.time.*;//Con questo comando importi tutta la classe time.
public class Articolo 
{

	//Attributi
	private int CodiceArticolo;
	private String NomeArticolo;
	private String CategoriaArticolo;
	private double PrezzoArticolo;
	private double ScontoArticolo;
	private double PrezzoScontato;
	private LocalDate DataInizioOfferta;
	private LocalDate DataFineOfferta;
	//costruttore 
	public Articolo(int CodiceArticolo,String NomeArticolo,String CategoriaArticolo,double PrezzoArticolo, double ScontoArticolo,LocalDate DataInizioOfferta, LocalDate DataFineOfferta)
	{
		this.CodiceArticolo=CodiceArticolo;
		this.NomeArticolo=NomeArticolo;
		this.CategoriaArticolo=CategoriaArticolo;
		this.PrezzoArticolo=PrezzoArticolo;
		this.ScontoArticolo=ScontoArticolo;
		this.PrezzoScontato=PrezzoArticolo-((PrezzoArticolo*ScontoArticolo)/100);
		this.DataInizioOfferta=DataInizioOfferta;
		this.DataFineOfferta=DataFineOfferta;
	}
	
	
	//Metodi setter 
	public void setCodiceArticolo(int CodiceArticolo)
	{this.CodiceArticolo=CodiceArticolo;}
	
	public void setNomeArticolo(String NomeArticolo)
	{this.NomeArticolo=NomeArticolo;}
	
	public void setCategoriaArticolo(String CategoriaArticolo)
	{this.CategoriaArticolo=CategoriaArticolo;}
	
	// Modifiche ai setter di PrezzoArticolo e ScontoArticolo
	public void setPrezzoArticolo(double PrezzoArticolo) {
	    this.PrezzoArticolo = PrezzoArticolo;
	    aggiornaPrezzoScontato();
	}
//Altrimenti dopo non li aggiorna se modifico se utilizzo la funzione del modifica
	public void setScontoArticolo(double ScontoArticolo) {
	    this.ScontoArticolo = ScontoArticolo;
	    aggiornaPrezzoScontato();
	}
	
	public void setDataInizioOfferta(LocalDate DataInizioOfferta)
	{this.DataInizioOfferta=DataInizioOfferta;}
	
	public void setDataFineOfferta(LocalDate DataFineOfferta)
	{this.DataFineOfferta=DataFineOfferta;}
	
	//Metodi getter 
	public int getCodiceArticolo() 
	{return CodiceArticolo;}
	
	public String getNomeArticolo() 
	{return NomeArticolo;}
	
	public String getCategoriaArticolo() 
	{return CategoriaArticolo;}
	
	public double getPrezzoArticolo() 
	{return PrezzoArticolo;}
	
	public double getScontoArticolo() 
	{return ScontoArticolo;}
	
	public double getPrezzoScontato()
	{return PrezzoScontato;}
	
	public LocalDate getDataInizioOfferta()
	{return DataInizioOfferta;}
	
	public LocalDate getDataFineOfferta()
	{return DataFineOfferta;}
	
	// Attributo aggiunto
	private void aggiornaPrezzoScontato() {
	    this.PrezzoScontato = PrezzoArticolo - ((PrezzoArticolo * ScontoArticolo) / 100);
	}


	
	//Stampiamo
	@Override
	public String toString() 
	{
	  return "\nCodice articolo:" + CodiceArticolo + "\nNome articolo:"+NomeArticolo+ "\nCategoria articolo:"+CategoriaArticolo+"\nPrezzo articolo:"+PrezzoArticolo+"\nSconto articolo:"+ScontoArticolo+"\nPrezzo Scontato:"+PrezzoScontato+"\nData inizio offerta:"+DataInizioOfferta+"\nData fine offerta:"+DataFineOfferta;
	}

	
}
