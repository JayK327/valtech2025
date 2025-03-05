package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {
	@Autowired
	private HelloWorld helloWorld;
	@Autowired
	private MovieServiceWS movieServiceWS;

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello(" --Valtech-- "));
		movieServiceWS.createMovie(new Movie("Nayagan","Action","Tamil",List.of("Kamal","Sharanya")));
		movieServiceWS.createMovie(new Movie("Alaipayudey","Drama","Tamil",List.of("Madhavan","Shalini")));
		System.out.println(movieServiceWS.getAllMovies());
	}

}
