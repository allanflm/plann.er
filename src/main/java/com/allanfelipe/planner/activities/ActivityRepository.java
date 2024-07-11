package com.allanfelipe.planner.activities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Actitvity, UUID> {
}
