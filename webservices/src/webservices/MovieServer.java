package webservices;

import java.util.List;

import org.apache.cxf.frontend.ServerFactoryBean;

public class MovieServer {

	public static void main(String[] args) {
		ServerFactoryBean server=new ServerFactoryBean();
		server.setAddress("http://localhost:7777/MovieService");
		
		MovieServiceImpl impl=new MovieServiceImpl();
		impl.addMovie(new Movie(1,"Topgun","English","Action",List.of("Tom","Jennifer")));
		impl.addMovie(new Movie(2,"de dana dan","hindi","Comedy",List.of("Akshay","Sunil")));
		impl.addMovie(new Movie(3,"3 Idiots","hindi","Comedy",List.of("Aamir","kareena","maddy")));
		impl.addMovie(new Movie(4,"alaipaydhey","tamil","Drame",List.of("Madhaven","shalini")));
		impl.addMovie(new Movie(5,"naya","tamil","Drame",List.of("kamalahasn","shalini")));
		
		
		server.setServiceBean(new MovieServiceImpl());
		server.setServiceClass(MovieService.class);
		server.create();
		System.out.println("Movie Service Running....");
	}

}
