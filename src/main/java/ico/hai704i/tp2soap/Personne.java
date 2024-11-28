package ico.hai704i.tp2soap;

import java.time.LocalDate;

import common.MDMethod;
import common.Nationalite;

public class Personne {
	
	// Attributs//
	private int id;
	private String prenom;
	private String nom;
	private Nationalite nationalite;
	private int age;
	private Adresse adressePersonne;
	private Reservation reservation;
	
	// Constructeurs
	
	public Personne(int id, String prenom, String nom, String nationalite, int age) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.nationalite = MDMethod.strToNat(nationalite) ;
		this.age = age;
	}
	public Personne(String nom, String prenom, String nationalite, int age) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.nationalite = MDMethod.strToNat(nationalite); 
		this.age = age;
	}
	public Personne(String nom, String prenom, int age) {
		super();
		this.prenom = prenom;
		this.nom = nom; 
		this.age = age;
	}
	public Personne() {
		
	}
	
	
	//Accesseurs 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Nationalite getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = MDMethod.strToNat(nationalite);
	}
	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Adresse getAdressePersonne() {
		return adressePersonne;
	}
	public void setAdressePersonne(Adresse adressePersonne) {
		this.adressePersonne = adressePersonne;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public void setReservation(Chambre chambre, LocalDate dateEntree, LocalDate dateSortie) {
		Reservation nouvelleReservation = new Reservation (this, chambre, dateEntree, dateSortie);
		this.reservation = nouvelleReservation;
	}
	public void setReservation(Hotel hotel, LocalDate dateEntree, LocalDate dateSortie) {
		Reservation nouvelleReservation = new Reservation (this, hotel, dateEntree, dateSortie);
		this.reservation = nouvelleReservation;
	}
	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", nationalite=" + nationalite + ", age=" + age + "]";
	}
	
}
