package webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService{
	private List<Movie> movies=new ArrayList<Movie>();
	public List<Movie> getAllMovies(){
		return movies;
	}
	
	public Movie getMovie(int id) {//Otional:idea is to not throw null pointException
//		Optional<Movie> =Optional.empty();
//		Optional<Movie> noIdea =Optional.ofNullable(obj);
//		Optional<Movie> available=Optional.of(new Movie());
		Optional<Movie> movie=movies.stream().filter(f->f.getId()==id).findFirst();
		boolean flag=movie.isPresent();
		if(flag) {
			return movie.get();
		}
		return new Movie();
		
	}
	
	public void addMovie(Movie m) {
		movies.add(m);
	}
	
	public void removeMovie(Movie m) {
		movies.remove(m);
	}
}
