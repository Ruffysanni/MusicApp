package com.ruffy.MusicApp.repository;

import com.ruffy.MusicApp.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {
    Music findByArtisteName(String artisteName);
    Music findByTitle(String title);
    Music findByYearOfGenre(String genre);
    Music findByYearOfProduction(int year);
    Music findByAlbumName(String album);
}
