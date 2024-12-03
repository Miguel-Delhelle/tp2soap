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
			@WebParam(name = "arg0") String strHotelReservee, 
	        @WebParam(name = "arg1") String strDateEntree, 
	        @WebParam(name = "arg2") String strDateSortie);
}