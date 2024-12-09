package web.service;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import common.MDMethod;
import ico.hai704i.tp2soap.Hotel;
import ico.hai704i.tp2soap.Personne;
import ico.hai704i.tp2soap.Reservation;

@WebService(endpointInterface="web.service.IAgence")
public class Agence implements IAgence{
	
	private String nomAgence = "agence";
	private ArrayList <Hotel> listeHotel = new ArrayList <>();

	public Agence(String nomAgence, ArrayList<Hotel> listeHotel) {
		super();
		this.nomAgence = nomAgence;
		this.listeHotel = listeHotel;
	}
	
	public Agence(String nomAgence) {
		super();
		this.nomAgence = nomAgence;
	}
	public Agence() {
		super();
	}

	public ArrayList<Hotel> getListeHotel() {
		return listeHotel;
	}

	public void setListeHotel(ArrayList<Hotel> listeHotel) {
		this.listeHotel = listeHotel;
	}
	public Hotel stringToHotel(String str) {
		Hotel hotelTmp = new Hotel();
		for (Hotel hotel: this.getListeHotel()) {
			if (str.equalsIgnoreCase(hotel.getNom())) {
				hotelTmp = hotel;
			}
		}
		if(hotelTmp == null || hotelTmp.isEmpty()) {
			return null;
		}
		else {
			return hotelTmp;
		}
	}
	
	public void addHotel(Hotel hotel) {
		this.listeHotel.add(hotel);
	}
	
	@Override
	public String toString() {
		String str ="";
		for (int i=0; i<listeHotel.size();i++) {
			str = str+listeHotel.get(i).toString();
		}
		return str;
	}
	@WebMethod
	public String afficherListeHotel() {
		String str ="";
		for (int i=0; i<listeHotel.size();i++) {
			str = str+listeHotel.get(i).toString()+"\n";
		}
		
		return str;
	}
	
	@WebMethod
	public void setReservation(String strHotelReservee, String strDateEntree, String strDateSortie) {
		System.out.println("les paramètres rentrées sont bel et bien"+strHotelReservee+strDateEntree+strDateSortie);
		Hotel hotelReservee = stringToHotel(strHotelReservee);
		LocalDate dateEntree = MDMethod.strToDat(strDateEntree);
		LocalDate dateSortie = MDMethod.strToDat(strDateSortie);
		Personne client = new Personne();
		Reservation reservation = new Reservation(client,hotelReservee, dateEntree, dateSortie);
		
		System.out.println(reservation.toString());
		
	}
	@WebMethod
	public void setReservationWithPerson(String prenom, String nom, int age, String strHotelReservee, String strDateEntree, String strDateSortie) {
		System.out.println("les paramètres rentrées sont bel et bien"+strHotelReservee+strDateEntree+strDateSortie);
		Hotel hotelReservee = stringToHotel(strHotelReservee);
		LocalDate dateEntree = MDMethod.strToDat(strDateEntree);
		LocalDate dateSortie = MDMethod.strToDat(strDateSortie);
		Personne client = new Personne(nom,prenom,age);
		Reservation reservation = new Reservation(client,hotelReservee, dateEntree, dateSortie);
		System.out.println(reservation.toString());
		
	}
}
