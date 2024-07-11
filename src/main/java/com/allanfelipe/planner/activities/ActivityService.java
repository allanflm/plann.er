package com.allanfelipe.planner.activities;

import com.allanfelipe.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Actitvity newActivity = new Actitvity(payload.title(), payload.occurs_at(), trip);
        this.repository.save(newActivity);

        return new ActivityResponse(newActivity.getId());

    }
}
