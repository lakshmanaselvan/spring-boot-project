package com.example.codesimple.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "description")
    private String desc;

    @Column(name = "Year_of_publication")
    private Integer yearOfPublication;

    @Column(name = "book_type")
    private String bookType;

    public Book(){

    }

    public Book(Long id, String name, String desc, Integer yearOfPublication, String bookType) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
