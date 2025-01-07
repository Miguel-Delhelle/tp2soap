package web.service;

import java.util.Scanner;

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
		Adresse adresseHotel2 = new Adresse ("23", "Place de la Comédie", "34000", "Montpellier", "France");
		Adresse adresseHotel3 = new Adresse ("12"," Place du général de Gaulle", "59000","Lille", "France");
		Hotel  saintOtel= new Hotel("à Saint-O", adresseHotel,3);
		Hotel  mtpFrance= new Hotel("à la Comédie", adresseHotel2,4);
		Hotel  lilleFrance= new Hotel("Bien au nord", adresseHotel3, 3);
		lilleFrance.generateurChambre(4, TypeChambre.SUITE);
		lilleFrance.generateurChambre(12, TypeChambre.SIMPLE);
		lilleFrance.generateurChambre(30, TypeChambre.DOUBLE);
		mtpFrance.generateurChambre(5, TypeChambre.SIMPLE);
		mtpFrance.generateurChambre(5, TypeChambre.LUXE);
		mtpFrance.generateurChambre(12, TypeChambre.DOUBLE);
		saintOtel.generateurChambre(10, TypeChambre.SUITE);
		saintOtel.generateurChambre(5,TypeChambre.LUXE);
		Scanner sc = new Scanner (System.in);
		System.out.println("précisez le port d'ouverture du serveur: ");
		String port = sc.nextLine();

		if (port.matches("\\d{4}")) {
			System.out.println("Le port est valide.");
		} else {
			System.out.println("Le port rentrée n'est pas valide. \n Il est donc défini sur 8888");
		}
		Endpoint.publish("http://localhost:"+port+"/hotel",mtpFrance);
		//Endpoint.publish("http://localhost:"+port+"/hotel",lilleFrance);
		//Endpoint.publish("http://localhost:"+port+"/hotel",saintOtel);
		System.out.println("Server démarré, \n webservice soap de l'hotel: "+mtpFrance.toString());
	}

}

/* Ok alors il y a beaucoup de chose à changer, il faut bien vérfier que toutes les associations se font à chaque réservation.
 * Afficher une exception si la Chambre dans un hotel n'est pas disponible
 * Vérifier l'ensemble et voilà tout */
