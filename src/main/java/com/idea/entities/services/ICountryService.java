package com.idea.entities.services;

import java.util.List;

import com.idea.entities.Country;

public interface ICountryService {

	Country createCountry(Country country);

	Country updateCountry(Country country, String countryId);

	void deleteCountry(String countryId);

	List<Country> getAllCountries();

	Country getCountry(String countryId);

}
