package com.allanfelipe.planner.participant;

import com.allanfelipe.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;


    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip) {
        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();
        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip){
        Participant newPaticipant = new Participant(email, trip);
        this.repository.save(newPaticipant);

        return new ParticipantCreateResponse(newPaticipant.getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId) {

    }
    public void triggerConfirmationEmailToParticipant(String email) {

    }
}
