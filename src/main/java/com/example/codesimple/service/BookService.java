package com.example.codesimple.service;


import com.example.codesimple.dto.AuthorDTO;
import com.example.codesimple.dto.BookDTO;
import com.example.codesimple.entity.Author;
import com.example.codesimple.entity.Book;
import com.example.codesimple.entity.BookAuthor;
import com.example.codesimple.repository.AuthorRepository;
import com.example.codesimple.repository.BookAuthorRepository;
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



    @Autowired
    private BookAuthorRepository bookAuthorRepository;
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
    public Book getBookById(Long bookId){
        return bookRepository.findBookById(bookId);
    }

    //update data
    public Book updateBook(Book incomingBook){
        return bookRepository.save(incomingBook);
    }

    public String deleteByBookId(Long id) {
        bookRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public List<Book> getBooksByRawQuery(Set<Integer> yop) {
        List<Book> bookList = bookRepository.findAllByYearOfPublicationIn(yop);
        return bookList;
    }

    public BookDTO getBookAuthorById(Long id, boolean authorData) {

        Book book;
        List<BookAuthor> bookAuthors = null;
        book = bookRepository.findBookById(id);

        if(authorData){

          bookAuthors =  bookAuthorRepository.findAllByBookId(id);
        }
        //set book details
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setDesc(book.getDesc());
        bookDTO.setYearOfPublication(book.getYearOfPublication());
        bookDTO.setBookType(book.getBookType());

        //get author details
        List<AuthorDTO> authorDTOList = new ArrayList<>();
        if(bookAuthors != null){
            for(BookAuthor bookAuthor:bookAuthors){
                Author author = bookAuthor.getAuthor();
                AuthorDTO authorDTO = new AuthorDTO();
                authorDTO.setId(author.getId());
                authorDTO.setName(author.getName());
                authorDTO.setGender(author.getGender());

                authorDTOList.add(authorDTO);

            }
            bookDTO.setAuthors(authorDTOList);
        }
        return  bookDTO;
    }
