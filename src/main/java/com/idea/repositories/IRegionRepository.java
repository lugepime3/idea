package com.idea.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idea.entities.Region;

@Repository
@Qualifier("RegionRepository")
public interface IRegionRepository extends JpaRepository<Region, Integer> {

}
