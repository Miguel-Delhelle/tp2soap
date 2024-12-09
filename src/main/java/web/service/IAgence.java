package web.service;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ico.hai704i.tp2soap.Hotel;

@WebService
public interface IAgence {
	
	@WebMethod
	public String afficherListeHotel();
	
	
	// Réservation avec constructeur personne vide
	@WebMethod
	public void setReservation (
			@WebParam(name = "nomHotel") String strHotelReservee, 
	        @WebParam(name = "dateEntree") String strDateEntree, 
	        @WebParam(name = "dateSortie") String strDateSortie);
	
	//Réservation avec paramètre pour la personne
	@WebMethod
	public void setReservationWithPerson(

			@WebParam(name = "prenom")String prenom, 
			@WebParam(name = "nom")String nom, 
			@WebParam(name = "age")int age, 
			@WebParam(name = "nomHotel")String strHotelReservee, 
			@WebParam(name = "dateEntree")String strDateEntree, 
			@WebParam(name = "dateSortie")String strDateSortie);

	// Récupération de la liste d'Hotel ? Pas tout à fait sûr de l'utilité, mais celà pourrait être utile pour accéder à des attributs supplémentaire.
	@WebMethod
	public ArrayList<Hotel> getListeHotel();
	
	
}

