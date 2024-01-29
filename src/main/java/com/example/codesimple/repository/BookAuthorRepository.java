package com.example.codesimple.repository;

import com.example.codesimple.entity.Book;
import com.example.codesimple.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
    List<BookAuthor> findAllByBookId(Long id);
}
