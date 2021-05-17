package com.idea.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.idea.entities.Region;

public interface IRegionController {
	ResponseEntity<String> getRegion(Integer id);

	List<Region> getAllRegions();

	ResponseEntity<String> addRegion(Region region);

	ResponseEntity<String> updRegion(Region region, Integer id);

	ResponseEntity<String> delRegion(Integer id);

}
