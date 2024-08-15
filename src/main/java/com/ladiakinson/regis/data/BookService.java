package com.ladiakinson.regis.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveNewBook(){
        Book book = new Book();
        book.getAuthor();
        book.getId();
        book.getTitle();
        return bookRepository.save(book);
    }

    // Other methods like findBookById, saveBook, etc.
}

