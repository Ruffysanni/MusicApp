package com.ruffy.MusicApp.controller;


import com.ruffy.MusicApp.model.Music;
import com.ruffy.MusicApp.model.MusicResource;
import com.ruffy.MusicApp.service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;
//    private final MusicService musicService;

//    public MusicController(MusicService musicService) {
//        this.musicService = musicService;
//    }

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
        return musicService.deleteMusic(id);
    }

    // getArtisteByName
    @GetMapping("/single/{artisteName}")
    public ResponseEntity<Music>getMusicByArtisteName(@PathVariable String artisteName){
        return musicService.getMusicByArtisteName(artisteName);
    }
    @GetMapping("/single/{title}")
    public ResponseEntity<Music>getMusicByTitle(@PathVariable String title){
        return musicService.getMusicByArtisteName(title);
    }
    @GetMapping("/single/{genre}")
    public ResponseEntity<Music>getMusicByGenre(@PathVariable String genre){
        return musicService.getMusicByArtisteName(genre);
    }
    @GetMapping("/single/{year}")
    public ResponseEntity<Music>getMusicByYearOfProduction(@PathVariable int year){
        return musicService.getMusicByYearOfProduction(year);
    }
    @GetMapping("/single/{albumName}")
    public ResponseEntity<Music>getMusicByAlbumName(@PathVariable String albumName){
        return musicService.getMusicByAlbumName(albumName);
    }
}
