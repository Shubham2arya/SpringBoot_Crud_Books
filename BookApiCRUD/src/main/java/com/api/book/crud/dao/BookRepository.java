package com.api.book.crud.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.book.crud.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);
}
