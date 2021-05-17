package com.idea.entities.services;

import java.util.List;

import com.idea.entities.Region;

public interface IRegionService {
	Region createRegion(Region region);

	Region updateRegion(Region region,Integer regionId);

	void deleteRegion(Integer regionId);

	List<Region> getAllRegions();

	Region getRegion(Integer regionId);

}
