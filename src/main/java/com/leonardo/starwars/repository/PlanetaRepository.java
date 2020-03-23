package com.leonardo.starwars.repository;

import com.leonardo.starwars.model.Planeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PlanetaRepository extends CrudRepository<Planeta,Long> {
}
