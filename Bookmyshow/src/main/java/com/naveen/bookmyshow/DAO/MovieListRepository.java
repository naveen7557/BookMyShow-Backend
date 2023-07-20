package com.naveen.bookmyshow.DAO;

import com.naveen.bookmyshow.pojo.MovieList;
import com.naveen.bookmyshow.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieListRepository extends JpaRepository<MovieList,Long> {
    Optional<MovieList> findById(Long id);

}
