package com.ruffy.MusicApp.controller;


import com.ruffy.MusicApp.model.Music;
import com.ruffy.MusicApp.model.MusicResource;
import com.ruffy.MusicApp.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/allMusic")
    public ResponseEntity<List<Music>> getAllMusic(){
        return musicService.getAllMusic();
    }

    @GetMapping("single/{id}")
    public ResponseEntity<Music>getMusicById(@PathVariable int id){
        return musicService.getMusicById(id);
    }

    @PostMapping("/single")
    public ResponseEntity<Music>addNewMusic(@RequestBody @Valid Music music){
        return musicService.addNewMusic(music);
    }

    @PutMapping("/single/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int id, @RequestBody Music music){

        return musicService.updateMusic(id, music);
    }

    @DeleteMapping("/single/{id}")
    public ResponseEntity<Music>deleteMusisc(@PathVariable int id){
        return musicService.deleteMusisc(id);
    }

    @GetMapping("/resources/{id}")
    public ResponseEntity<MusicResource> getMusicResource(@PathVariable int id){
        Music musicToSend = musicService.getMusicById(id).getBody();
        MusicResource musicResource = new MusicResource();
        musicResource.setMusic(musicToSend);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicById(id)).withSelfRel();
        Link delete = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusisc(id)).withRel("delete");
        Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).updateMusic(id, musicToSend)).withRel("update");
        musicResource.add(selfLink, delete, update);
        return new ResponseEntity<>(musicResource, HttpStatus.OK);
    }


}
