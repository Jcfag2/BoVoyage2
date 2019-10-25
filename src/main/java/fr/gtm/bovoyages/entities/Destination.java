package fr.gtm.bovoyages.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destinations")
@NamedQueries({ @NamedQuery(name = "Destination.getAllDestinations", query = "SELECT d FROM Destination d")
	 })
public class Destination implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pk_destination")
private long id;
private String region;
private String description;
//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////@ElementCollection
//@JoinColumn(name="fk_destination")
//private Set<String> images = new HashSet<>();
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//@ElementCollection
@JoinColumn(name="fk_destination")
private Set<DatesVoyage> dates = new HashSet<>();
private int deleted;

public Destination() {

}


public String getRegion() {
	return region;
}


public void setRegion(String region) {
	this.region = region;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


//public Set<String> getImages() {
//	return images;
//}
//
//
//public void setImages(Set<String> images) {
//	this.images = images;
//}


public Set<DatesVoyage> getDates() {
	return dates;
}



public void setDates(Set<DatesVoyage> dates) {
	this.dates = dates;
}


public long getId() {
	return id;
}


public int getDeleted() {
	return deleted;
}


public void setDeleted(int deleted) {
	this.deleted = deleted;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dates == null) ? 0 : dates.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
//	result = prime * result + ((images == null) ? 0 : images.hashCode());
	result = prime * result + ((region == null) ? 0 : region.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Destination other = (Destination) obj;
	if (dates == null) {
		if (other.dates != null)
			return false;
	} else if (!dates.equals(other.dates))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (id != other.id)
		return false;
//	if (images == null) {
//		if (other.images != null)
//			return false;
//	} else if (!images.equals(other.images))
//		return false;
	if (region == null) {
		if (other.region != null)
			return false;
	} else if (!region.equals(other.region))
		return false;
	return true;
}





}

