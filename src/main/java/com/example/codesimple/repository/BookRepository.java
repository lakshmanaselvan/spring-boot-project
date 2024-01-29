package com.example.codesimple.repository;

import com.example.codesimple.entity.Book;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {



    Book findBookById(@PathParam("id") Long bookid);

    void deleteById(Long id);

    List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop, String bookType);

    @Query(nativeQuery = true, value = "select * from book where year_of_publication IN (?)")
    List<Book> findAllByYearOfPublicationIn(Set<Integer> yop);
}
