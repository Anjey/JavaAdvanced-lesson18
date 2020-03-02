package com.barca.ss.controller;

import com.barca.ss.domain.Participant;
import com.barca.ss.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String init(HttpServletRequest request) {
        request.setAttribute("participants", participantService.findAll());
        request.setAttribute("mode", "PARTICIPANT_VIEW");
        return "index";
    }

    @GetMapping("/new")
    public String newParticipant(HttpServletRequest request) {
        request.setAttribute("mode", "PARTICIPANT_CREATE");
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Participant participant, HttpServletRequest request) {
        participantService.save(participant);
        request.setAttribute("participants", participantService.findAll());
        request.setAttribute("mode", "PARTICIPANT_VIEW");

        return "index";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, HttpServletRequest request) {
        request.setAttribute("participant", participantService.findById(id));
        request.setAttribute("mode", "PARTICIPANT_EDIT");

        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, HttpServletRequest request) {
        participantService.delete(id);
        request.setAttribute("participants", participantService.findAll());
        request.setAttribute("mode", "PARTICIPANT_VIEW");

        return "index";
    }
}
