package ico.hai704i.tp2soap;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import common.MDMethod;

@XmlRootElement
public class Hotel {
	
	// Attribut//
	private String nom;
	private Adresse adresse;
	private int nombreEtoile = 0;
	private ArrayList <Chambre> listeChambre = new ArrayList <Chambre>();
	
	// Constructeur
	
	public Hotel(String nom, Adresse adresse, int nombreEtoile, int nombreChambre, ArrayList<Chambre> listeChambre) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nombreEtoile = nombreEtoile;
		this.listeChambre = listeChambre;
	}
	
	
	public Hotel(String nom, Adresse adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}
	public Hotel(String nom, Adresse adresse, int nbrEtoile) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nombreEtoile = nbrEtoile;
	}

	public Hotel() {
		super();
	}
	

	public Hotel(String nom) {
		super();
		this.nom = nom;
	}


	// Accesseurs//
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public int getNombreEtoile() {
		return nombreEtoile;
	}
	public String getNombreEtoileToString() {
		String str ="";
		for (int i=0; i <= this.nombreEtoile; i++) {
			str = str+"★";
		}
		return str;
	}
	public void setNombreEtoile(int nombreEtoile) {
		this.nombreEtoile = nombreEtoile;
	}
	public ArrayList<Chambre> getListeChambre() {
		return listeChambre;
	}
	/*public Chambre getChambreDispo(LocalDate date) {
		int i=0;
		while(this.getListeChambre().get(i).testDisponible(date)) {
			this.listeChambre.get(i).
		}
		return ;
	} */
	public void setListeChambre(ArrayList<Chambre> listeChambre) {
		this.listeChambre = listeChambre;
	} 
	// Méthode
	public void generateurChambre(int nbrChambre, int nbrLit, double prix) {
		ArrayList <Chambre> listeChambre = new ArrayList<>();
		for (int i =0; i < nbrChambre; i++) {
			Chambre tmpChambre = new Chambre(i+1+this.getListeChambre().size(),nbrLit,prix, this);
			listeChambre.add(tmpChambre);
		}
		this.getListeChambre().addAll(listeChambre);
	}
	public Chambre getChambreDisponible(Reservation reservation) {
		ArrayList <LocalDate> arrayDateReservee = reservation.getArrayDateReservee();
		Chambre tmpChambre= new Chambre();
		for (int i = 0; i< this.getListeChambre().size();i++) {
			if (this.getListeChambre().get(i).getDateDisponible().containsAll(arrayDateReservee) && !this.getListeChambre().get(i).equals(tmpChambre)){
				tmpChambre = this.getListeChambre().get(i);
			}
		}
		return tmpChambre;
	}
	public String listeChambreDisponible(LocalDate uneDate) {
		String str ="";
		Chambre tmpChambre = new Chambre();
		for (int i = 0; i< this.getListeChambre().size();i++) {
			if (this.getListeChambre().get(i).getDateDisponible().contains(uneDate) && !this.getListeChambre().get(i).equals(tmpChambre)){
				str = str+"\n"+this.getListeChambre().get(i).toString();
				tmpChambre = this.getListeChambre().get(i);
			}
		}
		return str+"\nDisponible le: "+ MDMethod.dateToFrenchString(uneDate);
	}
	public String listeChambreDisponible(LocalDate dateEntree, LocalDate dateSortie) {
		String str ="";
		Chambre tmpChambre = new Chambre();
		LocalDate dateTmp = dateEntree;
		// Initialisation liste de date
		ArrayList<LocalDate> arrayDateReservee = new ArrayList<>();
		while (!dateTmp.equals(dateSortie)) {
			arrayDateReservee.add(dateTmp);
			dateTmp = dateTmp.plusDays(1);
		}
		
		for (int i = 0; i< this.getListeChambre().size();i++) {
			if (this.getListeChambre().get(i).getDateDisponible().containsAll(arrayDateReservee) && 
					!this.getListeChambre().get(i).equals(tmpChambre)){
				str = str+"\n"+this.getListeChambre().get(i).toString();
				tmpChambre = this.getListeChambre().get(i);
			}
		}
		if (str.equals("")) {
			return "Aucune date disponible à ce moment";
		}
		return str+"\nDisponible du: "+ MDMethod.dateToFrenchString(dateEntree)+" jusqu'au "+ MDMethod.dateToFrenchString(dateSortie);
	}
	
	public ArrayList<Chambre> listeChambreDisponible_ARRAYLIST(LocalDate dateEntree, LocalDate dateSortie) {
		String str ="";
		Chambre tmpChambre = new Chambre();
		LocalDate dateTmp = dateEntree;
		// Initialisation liste de date
		ArrayList<LocalDate> arrayDateReservee = new ArrayList<>();
		while (!dateTmp.equals(dateSortie)) {
			arrayDateReservee.add(dateTmp);
			dateTmp = dateTmp.plusDays(1);
		}
		ArrayList<Chambre> listeChambreDispo = new ArrayList<>();
		for (int i = 0; i< this.getListeChambre().size();i++) {
			if (this.getListeChambre().get(i).getDateDisponible().containsAll(arrayDateReservee) && 
					!this.getListeChambre().get(i).equals(tmpChambre)){
				str = str+"\n"+this.getListeChambre().get(i).toString();
				listeChambreDispo.add(this.getListeChambre().get(i));
			}
		}
		if (str.equals("")) {
			return null;
		}
		return listeChambreDispo;
	}
	
	@Override
	public String toString() {
		return "Hotel "+ this.getNom() + " à "+ this.getAdresse().getVille() + this.getNombreEtoileToString() + 
				"Nombre de chambre: "+ this.getListeChambre().size();
	}
	public boolean equals(Hotel hotel2) {
		if ((this.getNom().equals(hotel2.getNom())) && (this.getAdresse().equals(hotel2.getAdresse()))) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if (((this.getNom() == null) || this.getNom().isEmpty()) && (this.getNombreEtoile() == 0) && (this.getListeChambre().isEmpty())){
			return true;
		}
		else {
			return false;
		}
	}
	
}
