package Articoli;

public class Articolo 
{

	//Attributi
	private int CodiceArticolo;
	private String NomeArticolo;
	private String CategoriaArticolo;
	private double PrezzoArticolo;
	private double ScontoArticolo;
	
	
	//costruttore 
	public Articolo(int CodiceArticolo,String NomeArticolo,String CategoriaArticolo,double PrezzoArticolo,double ScontoArticolo) 
	{	
		this.CodiceArticolo=CodiceArticolo;
		this.NomeArticolo=NomeArticolo;
		this.CategoriaArticolo=CategoriaArticolo;
		this.PrezzoArticolo=PrezzoArticolo;
		this.ScontoArticolo=ScontoArticolo;
	}
	
	
	//Metodi setter 
	public void setCodiceArticolo(int CodiceArticolo)
	{this.CodiceArticolo=CodiceArticolo;}
	
	public void setNomeArticolo(String NomeArticolo)
	{this.NomeArticolo=NomeArticolo;}
	
	public void setCategoriaArticolo(String CategoriaArticolo)
	{this.CategoriaArticolo=CategoriaArticolo;}
	
	public void setPrezzoArticolo(double PrezzoArticolo)
	{this.PrezzoArticolo=PrezzoArticolo;}
	
	public void setScontoArticolo(double ScontoArticolo)
	{this.ScontoArticolo=ScontoArticolo;}
	
	
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
	
	
	//Stampiamo
		@Override
		public String toString() 
		{
			return "\nCodice articolo:\n" + CodiceArticolo + "\nNome articolo: \n"+NomeArticolo+ "\nCategoria articolo:\n"+CategoriaArticolo+"\nPrezzo articolo:\n"+PrezzoArticolo+"\nSconto articolo:\n"+ScontoArticolo+"\n";

		}

	
}
