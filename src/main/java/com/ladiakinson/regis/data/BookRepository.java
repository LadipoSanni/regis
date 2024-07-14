package com.ladiakinson.regis.data;

import org.springframework.data.jpa.repository.JpaRepository;

// BookRepository.java (Repository)
public interface BookRepository extends JpaRepository<Book, Long> {

}
