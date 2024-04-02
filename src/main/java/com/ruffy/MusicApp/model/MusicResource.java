package com.ruffy.MusicApp.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


//@Data
public class MusicResource extends RepresentationModel<MusicResource> {
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
