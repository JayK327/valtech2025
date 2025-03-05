package com.valtech.training.jaws.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.jaws.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {

}
