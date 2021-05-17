package com.idea.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "countries")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "country_id")
	private String countryId;

	@Column(name = "country_name")
	private String countryName;
	// =================================================================
	// bi-directional many-to-one   ESTO FUNCIONA
	/*
	@JsonManagedReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "region_id")
	Region region;
	*/
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "region_id")
	Region region;	
	// =================================================================
	// bi-directional one-to-many association	
    @JsonManagedReference
	@OneToMany(mappedBy = "country",fetch=FetchType.LAZY)
	private List<Location> locations;
	// =================================================================	
	public Country() {
		super();
		this.locations= new ArrayList<>();
	}	
	

	public Country(String countryId, String countryName, Region region, List<Location> locations) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.region = region;
		this.locations = locations;
	}


	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	// =================================================================
	// bi-directional one-to-many association	
	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCountry(this);
		return location;

	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCountry(this);
		return location;
	}
	// =================================================================

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", region=" + region + "]";
	}

	
	
	
	
	
}
