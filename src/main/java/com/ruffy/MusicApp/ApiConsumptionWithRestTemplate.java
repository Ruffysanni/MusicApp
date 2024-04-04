package com.ruffy.MusicApp;

import com.ruffy.MusicApp.model.Music;
import com.ruffy.MusicApp.model.MusicResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiConsumptionWithRestTemplate {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        MusicResource resource = restTemplate.getForObject("http://localhost:8080/resource/resources/3", MusicResource.class);
        assert resource != null;
//        System.out.println(resource.getMusic());
//        resource.getLinks("delete").forEach(System.out::println);

        ResponseEntity<Music> music = restTemplate.getForEntity("http://localhost:8080/music/single/1", Music.class);
        Music toPost = music.getBody();
        System.out.println(toPost);
        System.out.println(music.getHeaders());
        System.out.println(music.getStatusCode());
        System.out.println(music.getClass());

        System.out.println();
        Music music1 = restTemplate.getForObject("http://localhost:8080/music/single/1", Music.class);
        assert toPost != null;
        toPost.setTitle("Abrakatabra");
        toPost.setGenre("Afro-Calypso");
        System.out.println(music1);

        ResponseEntity<Music> posted = restTemplate.postForEntity("http://localhost:8080/music/single", toPost, Music.class);
        System.out.println(posted);
        // ResponseEntity<Music> posted = restTemplate.postForEntity("http://localhost:9091/music/single", toPost, Music.class);
    }
}
