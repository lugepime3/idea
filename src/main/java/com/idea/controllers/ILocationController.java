package com.idea.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.idea.entities.Location;

public interface ILocationController {
	ResponseEntity<String> getLocation(Integer id);

	List<Location> getAllLocations();

	ResponseEntity<String> addLocation(Location location);

	ResponseEntity<String> updLocation(Location location, Integer id);

	ResponseEntity<String> delLocation(Integer id);
}
