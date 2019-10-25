package fr.gtm.bovoyages.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.gtm.bovoyages.entities.*;




public class DestinationDAO extends AbstractDAO<Destination, Long> {
private EntityManagerFactory emf;

public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
		this.emf = emf;
	}
	
public List<Destination> getAllDestinations(){
	EntityManager em = emf.createEntityManager();
	List<Destination> destinations = em.createNamedQuery("Destination.getAllDestinations", Destination.class).getResultList();
	em.close();
	return destinations;
}
	
public Set<DatesVoyage> getDatesVoyageByDestinationId(long id){
	EntityManager em = emf.createEntityManager();
	Destination destination = em.find(Destination.class, id);
	Set<DatesVoyage> datesVoyage = new HashSet<DatesVoyage>();
	for (DatesVoyage d : destination.getDates()){
		datesVoyage.add(d);
		}
	return datesVoyage;
}

public void deleteDatesVoyageByID(long id) {
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	DatesVoyage datesVoyage = em.find(DatesVoyage.class, id);
	em.remove(datesVoyage);
	em.getTransaction().commit();
	em.close();	
}

}
