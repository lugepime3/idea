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

import com.idea.controllers.IRegionController;
import com.idea.entities.Region;
import com.idea.entities.services.IRegionService;

@RestController
@RequestMapping(value = "/region")
public class RegionControllerImpl implements IRegionController {

	@Autowired
	@Qualifier("RegionService")
	IRegionService regionService;

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<String> getRegion(@PathVariable("id") Integer id) {
		Region region;

		try {
			region = regionService.getRegion(id);
			if (region == null) {
				return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>("OK : "+region, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * 
	 * @return
	 */

	@GetMapping("/all")
	public List<Region> getAllRegions() {
		return  regionService.getAllRegions();
	}

	/**
	 * 
	 * @param region
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<String> addRegion(@RequestBody Region region) {
		Region r;
		try {
			r = regionService.createRegion(region);
			if (r.getRegionId() != null && r.getRegionId() > 0) {
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
	 * @param region
	 * @param id
	 * @return
	 */
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> updRegion(@RequestBody Region region, @PathVariable Integer id) {
		Region r;
		try {
			r = regionService.updateRegion(region, id);
			if (r.getRegionId() == id && r.getRegionId() > 0) {
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
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delRegion(@PathVariable Integer id) {
		try {
			regionService.deleteRegion(id);
			return new ResponseEntity<>("OK ", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}
	// ---
}
