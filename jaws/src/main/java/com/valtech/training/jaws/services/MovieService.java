package com.valtech.training.jaws.services;

import java.util.List;

import com.valtech.training.jaws.Movie;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}