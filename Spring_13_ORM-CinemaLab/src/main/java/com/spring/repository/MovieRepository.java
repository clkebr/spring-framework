package com.spring.repository;

import com.spring.entity.Movie;
import com.spring.enums.MovieState;
import com.spring.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Movie findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal price1, BigDecimal price2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findByDurationExists(List<Integer> durationList);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateIsAfter(LocalDate releaseDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> fetchAllBetween(@Param("prc1") BigDecimal price1,@Param("prc2") BigDecimal price2);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<String> fetchAllMovieName();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * FROM movie WHERE name= ?1", nativeQuery = true)
    Movie fetchByName(@Param("name") String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Movie> fetchAllByPriceIn(@Param("prc1") BigDecimal price1,@Param("prc2") BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * FROM movie WHERE duration IN ?1", nativeQuery = true)
    List<Movie> fetchAllByDurationIsIn(@Param("durations") List<Integer> durations);

    //Write a native query to list the top 5 most expensive movies

    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Movie> fetch5Expensive(List<Integer> duration);
}
