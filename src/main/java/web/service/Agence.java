package web.service;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ico.hai704i.tp2soap.*;

@WebService(endpointInterface="web.service.IAgence")
public class Agence implements IAgence{
	
	private String nomAgence;
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
			str = str+listeHotel.get(i).toString();
		}
		
		return str;
	}
}
