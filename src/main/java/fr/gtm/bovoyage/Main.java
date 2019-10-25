package fr.gtm.bovoyage;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.gtm.bovoyages.servlets.Constantes;
import fr.gtm.bovoyages.dao.DestinationDAO;
import fr.gtm.bovoyages.entities.Destination;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bovoyages");
		DestinationDAO dao = new DestinationDAO(emf);
		long id = 1;
		System.out.println(dao.findById(id));
//		List<Commune> communes = dao.getCommunesByCodePostal("972");
//		communes.forEach(System.out::println);
//		List<Departement> departements = dao.getAllDepartement();
//		departements.forEach(System.out::println);
		
		
		
		emf.close();
	}

}


