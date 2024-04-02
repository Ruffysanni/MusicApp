package com.ruffy.MusicApp.service;


import com.ruffy.MusicApp.model.Music;
import com.ruffy.MusicApp.repository.MusicRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
//@AllArgsConstructor
@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

//    public MusicService(MusicRepository musicRepository) {
//        this.musicRepository = musicRepository;
//    }

    public ResponseEntity<List<Music>>getAllMusic(){
        return new  ResponseEntity<>(musicRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Music>getMusicById(int id){
        return new ResponseEntity<>(musicRepository.findById(id).get(), HttpStatus.OK);
    }


    public ResponseEntity<Music>addNewMusic(Music music){
        return new ResponseEntity<>(musicRepository.save(music), HttpStatus.CREATED);
    }

    public ResponseEntity<Music> updateMusic(int id, Music music){
        Music dbMusic = musicRepository.findById(id).get();
        dbMusic.setMusicDuration(music.getMusicDuration());
        dbMusic.setAlbumName(music.getAlbumName());
        dbMusic.setArtistName(music.getArtistName());
        dbMusic.setGenre(music.getGenre());
        dbMusic.setTitle(music.getArtistName());
        dbMusic.setYearOfProduction(music.getYearOfProduction());
        return new ResponseEntity<>(musicRepository.save(music), HttpStatus.CREATED);
    }
    public ResponseEntity<Music>deleteMusisc(int id){
        return new ResponseEntity<Music>(musicRepository.findById(id).get(), HttpStatus.OK);
    }
}
