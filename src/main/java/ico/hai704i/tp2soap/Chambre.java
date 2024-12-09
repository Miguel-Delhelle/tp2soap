package ico.hai704i.tp2soap;

import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

public class Chambre {

	// Attributs//
	private int numeroChambre;
	private int nombreLit;
	private double prix;
	private Hotel hotel;
	private HashMap <LocalDate, String> disponibilite;
	private Reservation reservation;
	
	// Constructeurs
	
	public Chambre(int numeroChambre, int nombreLit, double prix, Hotel hotel) {
		super();
		this.numeroChambre = numeroChambre;
		this.nombreLit = nombreLit;
		this.prix = prix;
		this.hotel = hotel;
		this.disponibilite = this.setDisponibiliteInitial();
	}
	public Chambre(int numeroChambre, int nombreLit, double prix) {
		super();
		this.numeroChambre = numeroChambre;
		this.nombreLit = nombreLit;
		this.prix = prix;
		this.disponibilite = this.setDisponibiliteInitial();
	}
	public Chambre() {
		super();
		this.disponibilite = this.setDisponibiliteInitial();
	}
	// Accesseurs //
	
	public int getNumeroChambre() {
		return numeroChambre;
	}
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
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
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public void setDisponibilite(HashMap<LocalDate, String> disponibilite) {
		this.disponibilite = disponibilite;
	}
	public HashMap<LocalDate, String> getDisponibilite() {
		return disponibilite;
	}
	public HashMap <LocalDate, String> setDisponibiliteInitial() {
		LocalDate auj = LocalDate.now();
		HashMap <LocalDate, String> ListeDisponibilite = new HashMap<LocalDate, String>();
		ListeDisponibilite.put(auj, "Disponible");
		for (int i = 0; i <= 20; i++) { // le calendrier n'ira plus loin qu'un quart d'année 
			ListeDisponibilite.put(auj.plusDays(i), "Disponible");
		}
		return ListeDisponibilite;
	}
	public ArrayList<LocalDate> getDateDisponible() {
		ArrayList<LocalDate> dateDisponible = new ArrayList<>();
        HashMap <LocalDate, String> dicoDisponibilite= this.getDisponibilite();
		for (Entry<LocalDate, String> iteDico: dicoDisponibilite.entrySet()) {
			if (iteDico.getValue().equals("Disponible")){
				dateDisponible.add(iteDico.getKey());
			}
		}
		Collections.sort(dateDisponible); // Je voulais au départ faire une fonction de tri et j'ai realisé que c'était clairement pas nécessaire
		return dateDisponible;
	}
	// A IMPLANTER: DEVOIR MODIFIER LES VALEURS DES DATES, POUR AVOIR DES DATES DISPONIBLE OU RESERVEE. (Possiblement modifier le String en boolean). 
	// CREE UN TABLEAU DE DATE DISPONIBLE ORDONEE POUR L'AFFICHAGE.
	public String stringDateDisponible() {
		ArrayList<LocalDate> listeDate = this.getDateDisponible();
		String dateDispo ="";
		for (int i = 0; i< listeDate.size(); i++) {
			LocalDate dateTmp = listeDate.get(i);
			dateDispo = dateDispo+frenchDate(dateTmp)+"\n";
		}
		return dateDispo;
	}
	public boolean testDisponible(LocalDate date) {
		if (this.getDisponibilite().get(date).equals("Disponible")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String frenchDate(LocalDate date) {
		
		String[] dateTab = date.toString().split("-");
		String annee = dateTab[0];
		// Affichage mois
		String mois = dateTab[1];
		if (mois.equals("01")) {mois = "janvier";}
		if (mois.equals("02")) {mois = "février";}
		if (mois.equals("03")) {mois = "mars";}
		if (mois.equals("04")) {mois = "avril";}
		if (mois.equals("05")) {mois = "mai";}
		if (mois.equals("06")) {mois = "juin";}
		if (mois.equals("07")) {mois = "juillet";}
		if (mois.equals("08")) {mois = "août";}
		if (mois.equals("09")) {mois = "septembre";}
		if (mois.equals("10")) {mois = "octobre";}
		if (mois.equals("11")) {mois = "novembre";}
		if (mois.equals("12")) {mois = "decembre";}
		// Affichage jour
		String numeroJour = dateTab[2];
		/*
		String jour; 
		if ( date.getDayOfWeek().toString().equals("MONDAY")) {jour = "Lundi";}
		if ( date.getDayOfWeek().toString().equals("TUESDAY")) {jour = "Mardi";}
		if ( date.getDayOfWeek().toString().equals("WEDNESDAY")) {jour = "Mercredi";}
		if ( date.getDayOfWeek().toString().equals("THURSDAY")) {jour = "Jeudi";}
		if ( date.getDayOfWeek().toString().equals("FRIDAY")) {jour = "Vendredi";}
		if ( date.getDayOfWeek().toString().equals("SATURDAY")) {jour = "Samedi";}
		if ( date.getDayOfWeek().toString().equals("SUNDAY")) {jour = "Dimanche";} */


		return numeroJour+" "+mois+" "+annee; 
	}
	@Override
	public String toString() {
		String str = "Numéro: "+this.getNumeroChambre()+"\nNombre lit: "+this.getNombreLit()+"\nPrix: "+this.getPrix();
		return str;
	}
	public boolean idEquals(Chambre chambre2) {
		if (this.getNumeroChambre() == chambre2.getNumeroChambre()) {
			return true;
		}
		return false;
	}
	public boolean equals(Chambre chambre2){
		if ((this.getNombreLit() == chambre2.getNombreLit()) && (this.getPrix() == chambre2.getPrix() && (this.getHotel().equals(chambre2.getHotel()))) 
				&& (this.getHotel().equals(chambre2.getHotel()))){
			return true;
		}
		return false;
	}
		
}