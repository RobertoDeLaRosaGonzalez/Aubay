package com.aubay.spaceships.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpaceshipRepositoryInterface extends CrudRepository<Spaceship, Long> {
    List<Spaceship> findByName(String name);
    Spaceship save(Spaceship spaceship);
}
