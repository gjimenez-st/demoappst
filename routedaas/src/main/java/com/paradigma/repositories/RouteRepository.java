package com.paradigma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paradigma.entities.Airport;
import com.paradigma.entities.Route;

@RepositoryRestResource(collectionResourceRel = "routes", path = "routes")
public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {
	
	@Query("SELECT DISTINCT r.destination FROM Route r WHERE r.origin = ?1")
	List<Airport> findDistinctDestinationByOrigin(Airport origin);
	
	List<Route> findByOriginAndDestination(Airport origin,Airport destination);
	
	@Query("SELECT DISTINCT origin FROM Route")
	List<Airport> findOrigins();
}
