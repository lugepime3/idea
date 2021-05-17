package com.idea.entities.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.idea.entities.Country;
import com.idea.entities.services.ICountryService;
import com.idea.repositories.ICountryRepository;

@Service
@Qualifier("CountryService")
public class CountryServiceImpl implements ICountryService {
	@Autowired
	@Qualifier("CountryRepository")
	ICountryRepository countryRepository;

	@Override
	public Country createCountry(Country country) {
		if (!countryRepository.existsById(country.getCountryId())) {
			country = countryRepository.save(country);
		}
		return country;
	}

	@Override
	public Country updateCountry(Country country, String countryId) {
		if (countryRepository.existsById(country.getCountryId())) {
			country.setCountryId(countryId);
			country = countryRepository.save(country);
		}
		return country;
	}

	@Override
	public void deleteCountry(String countryId) {
		if (countryRepository.existsById(countryId)) {
			countryRepository.deleteById(countryId);
		}


	}

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country getCountry(String countryId) {
		Country countryFounded = null;
		Optional<Country> r = countryRepository.findById(countryId);
		if (r.isPresent()) {
			countryFounded = r.get();
		}
		return countryFounded;
	}

}
