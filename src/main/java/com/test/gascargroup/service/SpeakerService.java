package com.test.gascargroup.service;

import com.test.gascargroup.dto.SpeakerDto;
import com.test.gascargroup.entity.Speaker;
import com.test.gascargroup.exception.EntityNotFoundException;
import com.test.gascargroup.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService implements SpeakerServiceBean {
    @Autowired
    private SpeakerRepository repository;

    @Override
    public Speaker createSpeaker(SpeakerDto speakerDto) {
        Speaker speaker = new Speaker(speakerDto.getFirstName(), speakerDto.getLastName(), speakerDto.getMiddleName());
        return repository.save(speaker);
    }

    @Override
    public Speaker getSpeakerById(Long id) {
        this.findSpeaker(id);
        return repository.getOne(id);
    }

    @Override
    public List<Speaker> getSpeakers() {
        return repository.findAll();
    }

    @Override
    public Speaker updateSpeaker(Long id, SpeakerDto speaker) {
        Speaker updatedSpeaker = this.findSpeaker(id);

        updatedSpeaker.setFirstName(speaker.getFirstName() != null ? speaker.getFirstName() : updatedSpeaker.getFirstName());
        updatedSpeaker.setLastName(speaker.getLastName() != null ? speaker.getLastName() : updatedSpeaker.getLastName());
        updatedSpeaker.setMiddleName(speaker.getMiddleName() != null ? speaker.getMiddleName() : updatedSpeaker.getMiddleName());

        return repository.save(updatedSpeaker);
    }

    @Override
    public void deleteSpeaker(Long id) {
        this.findSpeaker(id);
        repository.deleteById(id);
    }

    private Speaker findSpeaker(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Speaker " + id + " does not exist!"));
    }
}
