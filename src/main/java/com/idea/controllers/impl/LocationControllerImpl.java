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

import com.idea.controllers.ILocationController;
import com.idea.entities.Location;
import com.idea.entities.services.ILocationService;

@RestController
@RequestMapping(value = "/location")
public class LocationControllerImpl implements ILocationController {
	@Autowired
	@Qualifier("LocationService")
	ILocationService locationService;

	/**
	 * 
	 */
	@GetMapping("/get/{id}")
	@Override
	public ResponseEntity<String> getLocation(@PathVariable("id") Integer id) {
		Location location;

		try {
			location = locationService.getLocation(id);
			if (location == null) {
				return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>("OK : " + location, HttpStatus.OK);
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
	public List<Location> getAllLocations() {
		return locationService.getAllLocations();
	}

	/**
	 * 
	 */
	@PostMapping("/add")
	@Override
	public ResponseEntity<String> addLocation(@RequestBody Location location) {
		System.out.println("Esto es lo que recibe  Ciudad: "+location.getCity() +" Country: ");
		System.out.println(" Country: "+location.getCountry());
		Location l;
		try {
			l = locationService.createLocation(location);
			if (l.getLocationId() != null && l.getLocationId() > 0) {
				return new ResponseEntity<>("OK ", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("BAD Request XXX", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request "+e.getStackTrace().toString(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 */
	@PutMapping("/edit/{id}")
	@Override
	public ResponseEntity<String> updLocation(@RequestBody Location location, @PathVariable Integer id) {
		Location l;
		try {
			l = locationService.updateLocation(location, id);
			if (l.getLocationId() == id && l.getLocationId() > 0) {
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
	public ResponseEntity<String> delLocation(@PathVariable Integer id) {
		try {
			locationService.deleteLocation(id);
			return new ResponseEntity<>("OK ", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}

}
