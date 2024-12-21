package web.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import exception.ChambreNonDisponibleException;
import exception.ReservationFailedException;
import ico.hai704i.tp2soap.Chambre;
import ico.hai704i.tp2soap.Hotel;
import ico.hai704i.tp2soap.Personne;
import ico.hai704i.tp2soap.Reservation;
import ico.hai704i.tp2soap.TypeChambre;

@WebService
public interface IHotel{

	// Récupérer Hotel
	// Afficher Hotel
	// NbrTypeChambreDifférente
	// Récupérer prix chambre (id Chambre)
	// Récupérer prix chambre (type Chambre)
	// setReservation
	@WebMethod 
	public Hotel getThis(); // Juste pour test ce que ça fait
	
	@WebMethod
	public String toString();
	
	@WebMethod
	public Chambre getChambreDisponible(Reservation reservation);
	
	@WebMethod
	public Chambre getChambreDisponible(Reservation reservation, TypeChambre typeDeChambre) throws ChambreNonDisponibleException;
	
	@WebMethod
	public List<TypeChambre> listeTypeChambre();
	
	@WebMethod
	public void setReservationWM(String dateEntree, String dateSortie, TypeChambre typeDeChambre) throws ReservationFailedException, ChambreNonDisponibleException;
	
	@WebMethod
	public void setReservationWM(Personne clientAuth); // Pas vraiment implanter puisqu'il faudrait penser un modèle d'authentification, et la base de donnée.
	
}
