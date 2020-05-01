package com.test.gascargroup.controller;

import com.test.gascargroup.dto.SpeakerDto;
import com.test.gascargroup.entity.Speaker;
import com.test.gascargroup.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService service;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Speaker> createSpeaker(@Valid @RequestBody final SpeakerDto speakerDto) {
        Speaker newSpeaker = service.createSpeaker(speakerDto);
        return new ResponseEntity<>(newSpeaker, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Speaker> getSpeakerById(@PathVariable final Long id) {
        Speaker speaker = service.getSpeakerById(id);
        return new ResponseEntity<>(speaker, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Speaker>> getSpeakers() {
        List<Speaker> list =  service.getSpeakers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<Speaker> updateSpeaker(@PathVariable final Long id, @Valid @RequestBody final SpeakerDto speakerDto) {
        Speaker updatedSpeaker = service.updateSpeaker(id, speakerDto);
        return new ResponseEntity<>(updatedSpeaker, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<HttpStatus> deleteSpeaker(@PathVariable final Long id) {
        service.deleteSpeaker(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

