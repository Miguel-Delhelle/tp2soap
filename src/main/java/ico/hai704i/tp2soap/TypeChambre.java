package ico.hai704i.tp2soap;

public enum TypeChambre {

	Simple(1,50),
	Double(2,60),
	Suite(2,120),
	Luxe(2,300);
	
	private int nombreLit;
	private double prix;
	
	
	private TypeChambre(int nombreLit, double prix) {
		this.nombreLit = nombreLit;
		this.prix = prix;
	}


	public int getNombreLit() {
		return nombreLit;
	}


	public void setNombreLit(int nombreLit) {
		this.nombreLit = nombreLit;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
