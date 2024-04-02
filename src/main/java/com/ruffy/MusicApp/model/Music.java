package com.ruffy.MusicApp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@RequiredArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@Data
@Entity
@Table(name = "music", uniqueConstraints = @UniqueConstraint(columnNames = {"title","yearOfProduction"}))
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @NotBlank
    private  String title;
    @NotBlank
    @Length(min = 3, max = 25)
    private  String artistName;

    @NotBlank
    @Length(min = 3, max = 25)
    private  String albumName;

    @Size(min = 1, max = 6)
    private  double musicDuration;

    @NotBlank
    @Length(min = 3)
    private  String genre;

    @NotBlank
    @Min(1900)
    @Max(2024)
    private  int yearOfProduction;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setMusicDuration(double musicDuration) {
        this.musicDuration = musicDuration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public double getMusicDuration() {
        return musicDuration;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
