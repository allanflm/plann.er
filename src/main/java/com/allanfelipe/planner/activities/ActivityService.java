package com.allanfelipe.planner.activities;

import com.allanfelipe.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Actitvity newActivity = new Actitvity(payload.title(), payload.occurs_at(), trip);
        this.repository.save(newActivity);

        return new ActivityResponse(newActivity.getId());

    }

    public List<ActivityData> getAllActivitiesFromId(UUID tripId) {
        return this.repository.findByTripId(tripId).stream().map(activity -> new ActivityData(activity.getId(), activity.getTitle(), activity.getOccursAt())).toList();
    }
}
