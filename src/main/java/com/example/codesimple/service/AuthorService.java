package com.example.codesimple.service;


import com.example.codesimple.common.APIResponse;
import com.example.codesimple.entity.Author;
import com.example.codesimple.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    public APIResponse getAuthors(Pageable pageable) {
        APIResponse apiResponse = new APIResponse();
        //db call
        Page<Author> authorPage = authorRepository.findAll(pageable);
        apiResponse.setData(authorPage);
        return apiResponse;
    }

    public Author addAuthors(Author author) {
        return authorRepository.save(author);
    }
}

