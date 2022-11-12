package com.spring.repository;

import com.spring.entity.Location;
import com.spring.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    @Override
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    int countAllByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    int countByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime date);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findFirst3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findByCinemaLocationName(String location);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
    List<MovieCinema> fetchAllAfterDate(@Param("date") LocalDateTime time);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT count(*) FROM movie_cinema WHERE cinema_id = ?1",nativeQuery = true)
    Integer fetchAllByCinema(@Param("id") Long id);

    //Write a native query that returns all movie cinemas by location name

    @Query(value = "SELECT * FROM movie_cinema mc JOIN cinema c ON c.id = mc.cinema_id" +
            " JOIN location l ON c.location_id = l.id WHERE l.name = ?1)",nativeQuery = true)
    List<MovieCinema> fetchAllByLocation(@Param("location") String location);
}
