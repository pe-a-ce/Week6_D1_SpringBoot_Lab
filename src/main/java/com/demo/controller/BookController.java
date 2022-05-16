package com.demo.controller;

import com.demo.model.Book;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List<Book> getAll(){
        return BookService.getAll();
    }

    @PostMapping("/books")
    private Book post(@RequestBody Book book){
        return BookService.save(book);
    }
}
