package com.example.codesimple.controller;

import com.example.codesimple.common.APIResponse;
import com.example.codesimple.dto.BookDTO;
import com.example.codesimple.entity.Book;
import com.example.codesimple.service.BookService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public List<Book> getBook(@RequestParam(value = "yearOfPublications", required = false) Set<Integer> yop,
                              @RequestParam(value = "bookType", required = false) String bookType){

    return bookService.getBooks(yop, bookType);
    }

    //Create Book
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){


        return bookService.createBook(book);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book incomingBook){
        return bookService.updateBook(incomingBook);
    }

    @DeleteMapping("/books/delete/{id}")
    public String deleteByBookId(@PathVariable Long id){
        return bookService.deleteByBookId(id);
    }

    //bookAuthor Data
    @GetMapping("/books/author/{id}")
    public BookDTO getBookId(@PathVariable Long id, @RequestParam(value = "authorData", required = false) boolean authorData){
        return bookService.getBookAuthorById(id, authorData);
    }

    @GetMapping("/books/raw")
    public APIResponse getBooksByRawQuery(@RequestParam("yop") Set<Integer> yop){
        return bookService.getBooksByRawQuery(yop);
    }

    //Exception
    @GetMapping("/caughtException")
    public APIResponse getCaughtException(@RequestParam("number") Integer yop){
        return bookService.getCaughtException(yop);
    }
}
