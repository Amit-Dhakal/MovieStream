package com.live.controller;

import com.live.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.*;
import java.nio.file.Files;

@RestController
@RequestMapping("/stream")
public class MovieStreamController {
    @Autowired
    RestTemplate restTemplate;
    private String relativePath = Constants.RELATIVE_PATH.getPath();

    @GetMapping("/movie/{videopath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videopath) throws IOException {
        File videoFile = new File(relativePath + videopath);
        String mimeType = Files.probeContentType(videoFile.toPath());
        if (videoFile.exists()) {
            InputStreamResource isr = new InputStreamResource(new FileInputStream(videoFile));
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).body(isr);
        } else {
            return ResponseEntity.notFound().build();}}

    @GetMapping("/moviecatalog/{videoId}")
    public ResponseEntity<InputStreamResource> streamVideoById(@PathVariable Long videoId) throws FileNotFoundException {
        String videopath = getMoviePath(videoId);
        File videoFile = new File(videopath + Constants.FILE_NAME.getPath());
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(videoFile));
        if (videoFile.exists()) {
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(Constants.FILE_FORMAT.getPath())).body(inputStreamResource);
        } else {return ResponseEntity.notFound().build();}}

    public String getMoviePath(Long movieInfoId) {
        return restTemplate.getForObject(Constants.FETCH_URL.getPath()+movieInfoId,String.class);}

    @GetMapping("/movies-list")
    public ResponseEntity<?> fetchMoviesList(){
        System.out.println("INSIDE MOVIES LIST");
        return new ResponseEntity<>(restTemplate.getForEntity(Constants.FETCH_MOVIE_LIST.getPath(),String.class),HttpStatus.ACCEPTED);}

}












//fetch movie list from catalog service
//stream services------
//things to do
// search movie from movie name,
//stream live movie from sites
//create access token and accsess to the free movie stream site
