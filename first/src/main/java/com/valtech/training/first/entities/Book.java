package com.valtech.training.first.entities;
 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
 
import jakarta.persistence.SequenceGenerator;
 
@Entity
public class Book {
 
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookseq")
	@SequenceGenerator(name = "bookseq",sequenceName = "book_seq",allocationSize = 1 )
	private long id;
	private String name;
	private int price;
	private int year;
	
	@ManyToOne(targetEntity = Publisher.class)
	@JoinColumn(name = "publisher_id",referencedColumnName = "id")
	private Publisher publisher;
	
	@ManyToMany(targetEntity = Author.class)
	@JoinTable(name = "book_author",
	joinColumns = @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors;
	public Book() {}
	public Book(String name, int price, int year) {
		super();
		this.name = name;
		this.price = price;
		this.year = year;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	
	public void addAuthor(Author a) {
		if(authors==null) authors=new HashSet<Author>();
		authors.add(a);
		if(a.getBooks()==null)a.setBooks(new HashSet<Book>());
		a.getBooks().add(this);
	}
	
	public void removeAuthor(Author a) {
		authors.remove(a);
		a.getBooks().remove(this);
	}
	
	
	
}
