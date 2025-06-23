package com.live.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIE_INFO")
public class MovieInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_description")
    private String desription;
    @Column(name = "movie_path")
    private String path;
    @Column(name = "movie_poster")
    private byte[] moviePoster;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public byte[] getMoviePoster() {
        return moviePoster;
    }
    public void setMoviePoster(byte[] moviePoster) {
        this.moviePoster = moviePoster;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getDesription() {
        return desription;
    }
    public void setDesription(String desription) {
        this.desription = desription;
    }
}
