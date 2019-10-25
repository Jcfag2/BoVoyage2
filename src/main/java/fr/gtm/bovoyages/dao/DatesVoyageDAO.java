package fr.gtm.bovoyages.dao;

import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyages.entities.DatesVoyage;

public class DatesVoyageDAO extends AbstractDAO<DatesVoyage, Long> {
	private EntityManagerFactory emf;

	public DatesVoyageDAO(EntityManagerFactory emf) {
			super(emf, DatesVoyage.class);
			this.emf = emf;
		}
	
}
