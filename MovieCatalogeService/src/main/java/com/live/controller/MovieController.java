package com.live.controller;

import com.live.entity.MovieInfo;
import com.live.service.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movieinfo")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/save")
    public MovieInfo saveMovie(@RequestBody MovieInfo movieInfo) {
        movieRepository.save(movieInfo);
        return movieInfo;
    }

    @GetMapping("/fetch")
    public List<MovieInfo> getAllMovies() {
        return movieRepository.findAll();}

    @GetMapping("/fetch/path-by-id/{id}")
    public String getMoviesPath(@PathVariable Long id) {
        Optional<String> path = movieRepository.findPathById(id);
        System.out.println("FILE PATH=====>>>>" + path);
        return path.get();}

    @GetMapping("/movies-list")
    public List<File> returnAllFiles() {
        List<File> moviePath=List.of(new File("D:\\Netflix-Serials").listFiles());
        return moviePath;
    }

    @GetMapping("/search-by-moviename/{movieName}")
    public ResponseEntity<?> getMoviesInfoByMovieName(@PathVariable String movieName){
        List<MovieInfo> movieInfoList=movieRepository.findByMovieInfo(movieName);
        return new ResponseEntity<>(movieInfoList,HttpStatus.ACCEPTED);
    }


}


//steps to service to service communication
//create resttemplate to communicate
//crete endpoingt to fetch interservice data
//