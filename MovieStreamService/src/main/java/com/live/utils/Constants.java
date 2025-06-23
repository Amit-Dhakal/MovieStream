package com.live.utils;

public enum Constants {

    RELATIVE_PATH("D://StreamingServices//"), FILE_NAME("old.mp4"),
    FILE_FORMAT("video/mp4"),
     FETCH_URL("http://localhost:8082/movieinfo/fetch/path-by-id/"),
  //  FETCH_URL("lb://movie-cataloge-service/movieinfo/fetch/path-by-id/"),
    FETCH_MOVIE_LIST("lb://movie-cataloge-service/movieinfo/movies-list");

    private final String path;
    Constants(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }
}
