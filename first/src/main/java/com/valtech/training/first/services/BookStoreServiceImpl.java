package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.AuthorRepo;
import com.valtech.training.first.repos.BookRepo;
import com.valtech.training.first.repos.PublisherRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookStoreServiceImpl implements BookStoreService{
	@Autowired
	private AuthorRepo authorRepo;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private PublisherRepo publisherRepo;
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public List<Author> getAllAuthors(){
		return authorRepo.findAll();
	}
	public List<Publisher> getAllPublishers(){
		return publisherRepo.findAll();
	}
	@Override
	public int countAllPublisher() {
		return (int) publisherRepo.count();
	}
	@Override
	public int countAllBook() {
		return (int) bookRepo.count();	
	}
	@Override
	public int countAllAuthor() {
		return (int) authorRepo.count();
	}
	@Override
	public List<Book> getBooksByYearBetween(int i, int j) {
		return bookRepo.findAllByYearBetween(i, j);
	}
	
	
	
}
