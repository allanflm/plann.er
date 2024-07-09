package com.allanfelipe.planner.trip;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String destination;

    @Column(name = "starts_at", nullable = false)
    private LocalDateTime startsAt;

    @Column(name = "ends_at", nullable = false)
    private LocalDateTime endsAT;

    @Column(name = "is_confirmed", nullable = false)
    private LocalDateTime isConfirmed;

    @Column(name = "owner_name", nullable = false)
    private LocalDateTime ownerName;

    @Column(name = "owner_email", nullable = false)
    private LocalDateTime ownerEmail;

}
