package com.barca.ss.dao;

import com.barca.ss.domain.Level;
import com.barca.ss.domain.Participant;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ParticipantRepo {

    private List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init() {
        Participant participant1 = new Participant();
        participant1.setId(1);
        participant1.setName("Igor");
        participant1.setEmail("igor@gmail.com");
        participant1.setLevel(Level.L3);
        participant1.setPrimarySkill("Organization");

        Participant participant2 = new Participant();
        participant2.setId(2);
        participant2.setName("Dima");
        participant2.setEmail("dima@gmail.com");
        participant2.setLevel(Level.L5);
        participant2.setPrimarySkill("Speaking");

        Participant participant3 = new Participant();
        participant3.setId(3);
        participant3.setName("Nazar");
        participant3.setEmail("nazar@gmail.com");
        participant3.setLevel(Level.L4);
        participant3.setPrimarySkill("Something");

        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);
    }


    public List<Participant> findAll() {
        return participants;
    }

    public Participant findById(Integer id) {
        return participants.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void save(Participant participant) {
        Participant updateParticipant = null;

        if(participant.getId() != null) {
            updateParticipant = findById(participant.getId());
            int participantIndex = participants.indexOf(updateParticipant);
            updateParticipant.setName(participant.getName());
            updateParticipant.setEmail(participant.getEmail());
            updateParticipant.setLevel(participant.getLevel());
            updateParticipant.setPrimarySkill(participant.getPrimarySkill());

            participants.set(participantIndex, updateParticipant);
        } else {
            participant.setId(participants.size()+1);
            participants.add(participant);
        }
    }

    public void delete(Integer id) {
        participants.remove(findById(id));
    }
}