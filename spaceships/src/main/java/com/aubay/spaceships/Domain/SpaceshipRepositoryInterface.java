package com.aubay.spaceships.Domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface SpaceshipRepositoryInterface extends CrudRepository<Spaceship, Long> {
    List<Spaceship> findByNameContaining(String name);
    Optional<Spaceship> findById(Long id);
    Page<Spaceship> findAll(Pageable pageable);
}
