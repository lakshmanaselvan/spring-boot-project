package com.example.codesimple.controller;


import com.example.codesimple.common.APIResponse;
import com.example.codesimple.entity.Author;
import com.example.codesimple.entity.Book;
import com.example.codesimple.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    @Autowired
    public AuthorService authorService;

    @GetMapping("/authors")
    private APIResponse getAuthors(Pageable pageable){
        APIResponse apiResponse = authorService.getAuthors(pageable);
        return apiResponse;
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthors(author);
    }
}
