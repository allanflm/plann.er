package com.allanfelipe.planner.activities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Actitvity, UUID> {

    List<Actitvity> findByTripId(UUID id);

}
