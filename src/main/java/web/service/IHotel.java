package web.service;

import java.time.LocalDate;
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

@WebService(name = "IHotelService", targetNamespace = "http://web.service.hotel/")
public interface IHotel{

	// Récupérer Hotel
	// Afficher Hotel
	// NbrTypeChambreDifférente
	// Récupérer prix chambre (id Chambre)
	// Récupérer prix chambre (type Chambre)
	// setReservation
	
	@WebMethod
	public String afficherHotel();
	
	@WebMethod
	public String listeChambreDisponibleToString(String strDateEntree, String strDateSortie);
	
	@WebMethod
	public String afficherNomHotel();
	
	@WebMethod
	public String toString();
	
	@WebMethod
	public List<TypeChambre> listeTypeChambre();
	
	@WebMethod
	public void setReservationWM(String dateEntree, String dateSortie, String typeDeChambre) throws ReservationFailedException, ChambreNonDisponibleException;
	
	@WebMethod
	public void setReservationWM_Auth(Personne clientAuth); // Pas vraiment implanter puisqu'il faudrait penser un modèle d'authentification, et la base de donnée.
	
}
