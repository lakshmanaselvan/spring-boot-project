package com.example.codesimple.service;


import com.example.codesimple.entity.Book;
import com.example.codesimple.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    //static List<Book> bookList = Arrays.asList(
    //        new Book(1,"2 states","desc of 2 states",2007,"fiction"),
    //        new Book(2,"3 states","desc of 3 states",2007,"fiction")
    //);//db call

    //create data
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    //delete data

    //get data
    public List<Book> getBooks(Set<Integer> yop, String bookType){

        List<Book> bookList = new ArrayList<>();

        if (yop == null){
            bookRepository.findAll().forEach(book -> bookList.add(book));
        }else{
            return bookRepository.findAllByYearOfPublicationInAndBookType(yop, bookType);
        }
        return bookList;
    }

    //getting single data form the database
    public Book getBookById(Integer bookId){
        return bookRepository.findBookById(bookId);
    }

    //update data
    public Book updateBook(Book incomingBook){
        return bookRepository.save(incomingBook);
    }

    public String deleteByBookId(Integer id) {
        bookRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public List<Book> getBooksByRawQuery(Set<Integer> yop) {
        List<Book> bookList = bookRepository.findAllByYearOfPublicationIn(yop);
        return bookList;
    }
}
