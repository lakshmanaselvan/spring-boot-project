package com.example.codesimple.validator;


import com.example.codesimple.common.Error;
import com.example.codesimple.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookValidator {


    public List<Error> validateCreateBookRequest(Book book) {

        List<Error> errors = new ArrayList<>();

        //name
        if(book.getName() == null){
            Error error = new Error("name", "Book Name Is Null");
            errors.add(error);
        }
        //yearOfPublication
        if(book.getYearOfPublication() == null){
            Error error = new Error("yearOfPublication","Book Year Of Publication Is Null");
            errors.add(error);
        }
        //bookType
        if(book.getBookType() == null){
            Error error = new Error("bookType", "Book Type Is Null");
            errors.add(error);
        }

        return errors;
    }
}
