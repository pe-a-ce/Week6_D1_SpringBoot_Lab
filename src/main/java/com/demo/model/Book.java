package com.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
           Main Class --> @Entity @ID
           Controller --> @RestController
           Service --> @Service
           Repository --> extends CrudRepository<T,ID>

 */

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    private String name;
    private String authorName;



    public Book(){}

    public Book(Long id, String name, String authorName) {
        Id = id;
        this.name = name;
        this.authorName = authorName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


}
