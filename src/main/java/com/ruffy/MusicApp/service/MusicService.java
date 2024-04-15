package com.ruffy.MusicApp.service;


import com.ruffy.MusicApp.model.Music;
import com.ruffy.MusicApp.repository.MusicRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//@RequiredArgsConstructor
//@AllArgsConstructor
@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;


    // Get all music
    @Cacheable("allMusic")

    public ResponseEntity<List<Music>>getAllMusic(){
        return new  ResponseEntity<>(musicRepository.findAll(), HttpStatus.OK);
    }

    // Get music by Id
//    @Cacheable(value = "getById", key = "#id")
    public ResponseEntity<Music>getMusicById(int id){
        return new ResponseEntity<>(musicRepository.findById(id).get(), HttpStatus.OK);
    }

    // Add / Post new music
    @CacheEvict(value = "allMusic", allEntries = true)
    public ResponseEntity<Music>addNewMusic(Music music){
        return new ResponseEntity<>(musicRepository.save(music), HttpStatus.CREATED);
    }


    // update music with Id
    @CacheEvict(value = {"allMusic", "getById"}, allEntries = true)
    public ResponseEntity<Music> updateMusic(int id, Music music){
        Music dbMusic = musicRepository.findById(id).get();
        dbMusic.setMusicDuration(music.getMusicDuration());
        dbMusic.setAlbumName(music.getAlbumName());
        dbMusic.setArtistName(music.getArtisteName());
        dbMusic.setGenre(music.getGenre());
        dbMusic.setTitle(music.getTitle());
        dbMusic.setYearOfProduction(music.getYearOfProduction());
        return new ResponseEntity<>(musicRepository.save(music), HttpStatus.CREATED);
    }

    //Update One single music Id entity

//    public ResponseEntity<Music> updateOneMusic(int id, Map<String, Object> updateMusic){
//        Optional<Music> dbMusic = musicRepository.findById(id);
//        if(dbMusic.isPresent()){
//            Music musicToUpdate = dbMusic.get();
//            if(updateMusic.containsKey("musicDuration")){
//                musicToUpdate.setMusicDuration((Double) updateMusic.get("musicDuration"));
//            }
//            if(updateMusic.containsKey("genre")){
//                musicToUpdate.setGenre((String) updateMusic.get("genre"));
//            }
//            if(updateMusic.containsKey("title")){
//                musicToUpdate.setTitle((String) updateMusic.get("title"));
//            }
//            if(updateMusic.containsKey("artisteName")){
//                musicToUpdate.setArtistName((String) updateMusic.get("artisteName"));
//            }
//            if(updateMusic.containsKey("yearOfProduction")){
//                musicToUpdate.setYearOfProduction(Integer.parseInt((String) updateMusic.get("yearOfProduction")));
//            }
//            if(updateMusic.containsKey("albumName")){
//                musicToUpdate.setAlbumName((String) updateMusic.get("albumName"));
//            }
//            Music updatedMusic = musicRepository.save(musicToUpdate);
//
//
//            // Return response entity with the updated Music entity
//            return new ResponseEntity<>(updatedMusic, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//
//    }

    // Delete one music
    @Cacheable(value = "getById", key = "#id")
    public ResponseEntity<Music>deleteMusic(int id){
        return new ResponseEntity<>(musicRepository.findById(id).get(), HttpStatus.OK);
    }

    // Get music by artisteName
    public ResponseEntity<Music>getMusicByArtisteName(String artisteName){
        return new ResponseEntity<>(musicRepository.findByArtisteName(artisteName), HttpStatus.OK);
    }

    // GEt music by  title
    public ResponseEntity<Music>getMusicByTitle(String title){
        return new ResponseEntity<>(musicRepository.findByTitle(title), HttpStatus.OK);
    }


    // Get music by genre
    public ResponseEntity<Music>getMusicByGenre(String genre){
        return new ResponseEntity<>(musicRepository.findByGenre(genre), HttpStatus.OK);
    }


    // Get music by music production year
    public ResponseEntity<Music>getMusicByYearOfProduction(int year){
        return new ResponseEntity<>(musicRepository.findByYearOfProduction(year), HttpStatus.OK);
    }


    // Get music by music album name
    public ResponseEntity<Music>getMusicByAlbumName(String albumName){
        return new ResponseEntity<>(musicRepository.findByAlbumName(albumName), HttpStatus.OK);
    }
}
