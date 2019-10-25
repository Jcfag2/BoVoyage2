package fr.gtm.bovoyages.services;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyages.dao.DatesVoyageDAO;
import fr.gtm.bovoyages.dao.DestinationDAO;
import fr.gtm.bovoyages.entities.DatesVoyage;
import fr.gtm.bovoyages.entities.Destination;

public class DestinationServices {
	private DestinationDAO dao;
	private DatesVoyageDAO dao2;
	
	public DestinationServices(EntityManagerFactory emf) {
		dao = new DestinationDAO(emf);
	}
	
	public List<Destination> getAllDestinations(){
	return dao.getAllDestinations();
}
	
	public Destination findById(long id){
	return dao.findById(id);
}
	public void update(Destination d) {
	dao.update(d);	
	}
	
	
	public void  create(Destination d) {
	dao.create(d);	
	}
	
	public void delete(long id) {
	dao.delete(id);	
	}
	
	public Set<DatesVoyage> getDatesVoyageByDestinationId(long id){
		return dao.getDatesVoyageByDestinationId(id);
	}
	
	public void deleteDatesVoyageByID(long id) {
		dao.deleteDatesVoyageByID(id);
	}
	
	public DatesVoyage findDateById(long id){
		return dao2.findById(id);
	}
	
	
}
