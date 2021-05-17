package com.idea.entities.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.idea.entities.Region;
import com.idea.entities.services.IRegionService;
import com.idea.repositories.IRegionRepository;

@Service
@Qualifier("RegionService")
public class RegionServiceImpl implements IRegionService {

	@Autowired
	@Qualifier("RegionRepository")
	IRegionRepository regionRepository;

	@Override
	public Region createRegion(Region region) {
		if (!regionRepository.existsById(region.getRegionId())) {
			region = regionRepository.save(region);
		}
		return region;
	}

	@Override
	public Region updateRegion(Region region, Integer regionId) {
		if (regionRepository.existsById(regionId)) {
			region.setRegionId(regionId);
			regionRepository.save(region);
		}
		return region;
	}

	@Override
	public void deleteRegion(Integer regionId) {
		if (regionRepository.existsById(regionId)) {
			regionRepository.deleteById(regionId);
		}

	}

	@Override
	public List<Region> getAllRegions() {
		return regionRepository.findAll();
	}

	@Override
	public Region getRegion(Integer regionId) {
		Region regionFounded = null;
		Optional<Region> r = regionRepository.findById(regionId);
		if (r.isPresent()) {
			regionFounded = r.get();
		}
		return regionFounded;
	}

}
