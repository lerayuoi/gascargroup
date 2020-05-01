package com.test.gascargroup.service;

import com.test.gascargroup.dto.SpeakerDto;
import com.test.gascargroup.entity.Speaker;

import java.util.List;

public interface SpeakerServiceBean {
    Speaker createSpeaker(SpeakerDto speaker);

    Speaker getSpeakerById(Long id);

    List<Speaker> getSpeakers();

    Speaker updateSpeaker(Long id, SpeakerDto speaker);

    void deleteSpeaker(Long id);
}
