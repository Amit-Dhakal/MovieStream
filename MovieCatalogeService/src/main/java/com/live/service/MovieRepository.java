package com.live.service;

import com.live.entity.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieInfo, Long> {
    @Query(value = "SELECT movie_path FROM moviedb.movie_info WHERE id = ?1", nativeQuery = true)
    Optional<String> findPathById(Long id);

    @Query(value="select * from movieinfo where moviename=?1",nativeQuery = true)
    List<MovieInfo> findByMovieInfo(String movieName);

}