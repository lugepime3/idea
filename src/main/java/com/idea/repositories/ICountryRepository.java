package com.idea.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idea.entities.Country;

@Repository
@Qualifier("CountryRepository") 
public interface ICountryRepository extends JpaRepository<Country, String> {
}
