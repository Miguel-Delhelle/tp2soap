package web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IAgence {
	
	@WebMethod
	public String afficherListeHotel();
}
