package com.plur.demo2004122.controllers;

import com.plur.demo2004122.models.Speaker;
import com.plur.demo2004122.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    private SpeakerRepository speakerRepository;

    @Autowired
    public SpeakerController(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
