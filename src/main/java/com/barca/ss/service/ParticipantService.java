package com.barca.ss.service;

import com.barca.ss.dao.ParticipantRepo;
import com.barca.ss.domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepo participantRepo;

    public List<Participant> findAll() {
        return participantRepo.findAll();
    }

    public Participant findById(Integer id) {
        return participantRepo.findById(id);
    }

    public void save(Participant participant) {
        participantRepo.save(participant);
    }

    public void delete(Integer id) {
        participantRepo.delete(id);
    }
}

