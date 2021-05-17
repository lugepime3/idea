package com.idea.entities.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.idea.entities.Location;
import com.idea.entities.Region;
import com.idea.entities.services.ILocationService;
import com.idea.repositories.ILocationRepository;

@Service
@Qualifier("LocationService")
public class LocationServiceImpl implements ILocationService {

	@Autowired
	@Qualifier("LocationRepository")
	ILocationRepository locationRepository;

	@Override
	public Location createLocation(Location location) {
		if (!locationRepository.existsById(location.getLocationId())) {
			location = locationRepository.save(location);
		}
		return location;
	}

	@Override
	public Location updateLocation(Location location, Integer locationId) {
		if (locationRepository.existsById(locationId)) {
			location.setLocationId(locationId);
			locationRepository.save(location);
		}
		return location;
	}

	@Override
	public void deleteLocation(Integer locationId) {
		if (locationRepository.existsById(locationId)) {
			locationRepository.deleteById(locationId);
		}

	}

	@Override
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	@Override
	public Location getLocation(Integer locationId) {
		Location locationFounded = null;
		Optional<Location> l = locationRepository.findById(locationId);
		if (l.isPresent()) {
			locationFounded = l.get();
		}
		return locationFounded;
	}

}
