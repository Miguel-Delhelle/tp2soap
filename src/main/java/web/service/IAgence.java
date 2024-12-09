package web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IAgence {
	
	@WebMethod
	public String afficherListeHotel();
	
	@WebMethod
	public void setReservation (
			@WebParam(name = "nomHotel") String strHotelReservee, 
	        @WebParam(name = "dateEntree") String strDateEntree, 
	        @WebParam(name = "dateSortie") String strDateSortie);
	
	@WebMethod
	public void setReservationWithPerson(

			@WebParam(name = "prenom")String prenom, 
			@WebParam(name = "nom")String nom, 
			@WebParam(name = "age")int age, 
			@WebParam(name = "nomHotel")String strHotelReservee, 
			@WebParam(name = "dateEntree")String strDateEntree, 
			@WebParam(name = "dateSortie")String strDateSortie);

}

