package com.idea.entities.services;

import java.util.List;

import com.idea.entities.Location;

public interface ILocationService {
	
	Location createLocation(Location location);

	Location updateLocation(Location location,Integer locationId);

	void deleteLocation(Integer locationId);

	List<Location> getAllLocations();

	Location getLocation(Integer locationId);

}
