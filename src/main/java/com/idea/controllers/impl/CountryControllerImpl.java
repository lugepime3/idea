package com.idea.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idea.controllers.ICountryController;
import com.idea.entities.Country;
import com.idea.entities.services.ICountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryControllerImpl implements ICountryController {

	@Autowired
	@Qualifier("CountryService")
	ICountryService countryService;

	/**
	 * 
	 */

	@GetMapping("/get/{id}")
	@Override
	public ResponseEntity<String> getCountry(@PathVariable("id") String id) {
		Country country;

		try {
			country = countryService.getCountry(id);
			if (country == null) {
				return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>("OK : " + country, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 */
	@GetMapping("/all")
	@Override
	public List<Country> getAllCountries() {
		try {
			return countryService.getAllCountries();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}

	}

	/**
	 * 
	 */
	@PostMapping("/add")
	@Override
	public ResponseEntity<String> addCountry(@RequestBody Country country) {
		Country c;
		try {
			c = countryService.createCountry(country);
			if (c.getCountryId() != null && c.getCountryId() != "") {
				return new ResponseEntity<>("OK ", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request " + e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}

	/**
	 * 
	 */
	@PutMapping("/edit/{id}")
	@Override
	public ResponseEntity<String> updCountry(@RequestBody Country country, @PathVariable String id) {
		Country c;
		try {
			c = countryService.updateCountry(country, id);
			if (c.getCountryId() == id && c.getCountryId() != "") {
				return new ResponseEntity<>("OK ", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 */
	@DeleteMapping("/delete/{id}")
	@Override
	public ResponseEntity<String> delCountry(@PathVariable String id) {
		try {
			countryService.deleteCountry(id);
			return new ResponseEntity<>("OK ", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}
	// --
}
