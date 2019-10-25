package fr.gtm.bovoyages.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "dates_voyages")
@NamedQueries({ @NamedQuery(name = "DatesVoyage.deleteDateById", query = "DELETE FROM DatesVoyage d WHERE d.id = :id")
	
})
public class DatesVoyage implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pk_date_voyage")
private long id;
@Column(name = "date_depart")
private Date dateDepart;
@Column(name = "date_retour")
private Date dateRetour;
private float prixHT;
@Column(name = "nb_places")
private int nbPlaces;

public DatesVoyage() {

}

public Date getDateDepart() {
	return dateDepart;
}

public void setDateDepart(Date dateDepart) {
	this.dateDepart = dateDepart;
}

public Date getDateRetour() {
	return dateRetour;
}

public void setDateRetour(Date dateRetour) {
	this.dateRetour = dateRetour;
}

public float getPrixHT() {
	return prixHT;
}

public void setPrixHT(float prixHT) {
	this.prixHT = prixHT;
}

public int getNbPlaces() {
	return nbPlaces;
}

public void setNbPlaces(int nbPlaces) {
	this.nbPlaces = nbPlaces;
}

public long getId() {
	return id;
}



	
}
