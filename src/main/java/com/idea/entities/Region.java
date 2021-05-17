package com.idea.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "regions")
public class Region implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "region_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regionId;

	@Column(name = "region_name")
	private String regionName;
	// =================================================================
	/*ESTO FUNCIONA
	// bi-directional many-to-one association
	@JsonBackReference
	@OneToMany(mappedBy = "region",fetch=FetchType.LAZY)
	private List<Country> countries;
	*/
	// =================================================================
	// bi-directional many-to-one association ESTOY PROBANDO
	@JsonManagedReference
	@OneToMany(mappedBy = "region",fetch=FetchType.LAZY)
	private List<Country> countries;
	
	
	
	
	public Region() {
		super();
		this.countries= new ArrayList<>();
	}

	public Region(Integer regionId, String regionName, List<Country> countries) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
		this.countries = countries;
	}


	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	// ---------------------------------------------------
	// bi-directional many-to-one association
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Country addCountry(Country country) {
		getCountries().add(country);
		country.setRegion(this);
		return country;

	}

	public Country removeCountry(Country country) {
		getCountries().remove(country);
		country.setRegion(null);
		return country;
	}
	// ---------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regionId == null) ? 0 : regionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Region))
			return false;
		Region other = (Region) obj;
		if (regionId == null) {
			if (other.regionId != null)
				return false;
		} else if (!regionId.equals(other.regionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}

}
