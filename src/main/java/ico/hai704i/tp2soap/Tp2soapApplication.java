package ico.hai704i.tp2soap;

import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import common.MDMethod;

//@SpringBootApplication
public class Tp2soapApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Tp2soapApplication.class, args);
		Adresse adresseHotel = new Adresse ("97", "Route de Clairmarais","62500","Saint-Omer","France");
		Adresse adresseHotel2 = new Adresse ("23", "Place de la Comédie", "34000", "Montpellier", "France");
		Adresse adresseHotel3 = new Adresse ("12"," Place du général de Gaulle", "59000","Lille", "France");
		Hotel  nordFrance= new Hotel("à Saint-O", adresseHotel,3);
		Hotel  mtpFrance= new Hotel("à la Comédie", adresseHotel2,4);
		Hotel  lilleFrance= new Hotel("chez les flamands", adresseHotel3, 3);
		lilleFrance.generateurChambre(30, 2, 45);
		mtpFrance.generateurChambre(15, 1, 300);
		nordFrance.generateurChambre(30, 2, 35);
		nordFrance.generateurChambre(12, 6, 200);
		Agence franceHotel = new Agence("France Hotel");
		franceHotel.addHotel(lilleFrance);franceHotel.addHotel(mtpFrance);franceHotel.addHotel(nordFrance);
		
		Endpoint.publish("http://localhost:8888/agence",franceHotel);
		System.err.println("Server is ready");
	}

} 
