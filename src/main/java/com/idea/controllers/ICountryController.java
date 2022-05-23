package com.idea.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.idea.entities.Country;

public interface ICountryController {
	ResponseEntity<String> getCountry(String id);

	List<Country> getAllCountries();

	//Its a test  for git

	ResponseEntity<String> addCountry(Country country);

	ResponseEntity<String> updCountry(Country country, String id);

	ResponseEntity<String> delCountry(String id);

}
