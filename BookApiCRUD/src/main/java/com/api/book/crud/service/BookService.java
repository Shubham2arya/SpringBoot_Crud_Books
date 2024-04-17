package com.api.book.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.crud.dao.BookRepository;
import com.api.book.crud.entities.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	//get all books
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book=null;
		try {
			book=this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding book
	public Book addBook(Book b) {
		Book result=this.bookRepository.save(b);
		return result;
	}
	
	//deleting book
	public void deleteBook(int bid) {
		this.bookRepository.deleteById(bid);
		
	}
	
	//updating book
	public void updateBook(Book book, int bid) {
		book.setId(bid);
		this.bookRepository.save(book);	
	}
}
