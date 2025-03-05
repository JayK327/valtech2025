package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;

public interface BookStoreService {

	int countAllPublisher();

	int countAllBook();
	
	int countAllAuthor();

	List<Book> getBooksByYearBetween(int i, int j);

	

}
