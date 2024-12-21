package web.service;

import javax.xml.ws.Endpoint;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import ico.hai704i.tp2soap.Adresse;
import ico.hai704i.tp2soap.Hotel;
import ico.hai704i.tp2soap.TypeChambre;

@SpringBootApplication
public class Tp2soapApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Tp2soapApplication.class, args);
		Adresse adresseHotel = new Adresse ("97", "Route de Clairmarais","62500","Saint-Omer","France");
		//Adresse adresseHotel2 = new Adresse ("23", "Place de la Comédie", "34000", "Montpellier", "France");
		//Adresse adresseHotel3 = new Adresse ("12"," Place du général de Gaulle", "59000","Lille", "France");
		Hotel  saintOtel= new Hotel("à Saint-O", adresseHotel,3);
		//Hotel  mtpFrance= new Hotel("à la Comédie", adresseHotel2,4);
		//Hotel  lilleFrance= new Hotel("chez les flamands", adresseHotel3, 3);
		//lilleFrance.generateurChambre(4, 2, 45);
		//mtpFrance.generateurChambre(5, TypeChambre.Simple);
		saintOtel.generateurChambre(10, TypeChambre.Suite);
		saintOtel.generateurChambre(5,TypeChambre.Suite);
		
		Endpoint.publish("http://localhost:8888/agence",saintOtel);
		System.err.println("Server is ready");
	}

}

/* Ok alors il y a beaucoup de chose à changer, il faut bien vérfier que toutes les associations se font à chaque réservation.
 * Afficher une exception si la Chambre dans un hotel n'est pas disponible
 * Vérifier l'ensemble et voilà tout */
