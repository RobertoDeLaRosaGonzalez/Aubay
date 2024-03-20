package com.aubay.spaceships.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceshipRepositoryInterface extends CrudRepository<Spaceship, Long> {
    List<Spaceship> findByNameContaining(String name);
    Optional<Spaceship> findById(Long id);
    Optional<Spaceship> findByName(String name);
    Page<Spaceship> findAll(Pageable pageable);
}
