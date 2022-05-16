package com.demo.service;

import com.demo.model.Book;
import com.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private static BookRepository bookRepository;

    public static List<Book> getAll() {
        return bookRepository.findAll();
    }

    public static Book save(Book book) {
        return bookRepository.save(book);
    }

    private JdbcTemplate jdbcTemplate;

    public int insertBook(Book book){
        String sql = """ 
        INSERT INTO books(book_name, author_name)
        VALUES(???) """;
        int rowsAffected = jdbcTemplate.update(
                sql,
                book.getId(),
                book.getName(),
                book.getAuthorName()
        );
        return rowsAffected;
    }

    public List<Book> selectAllBooks() {
        String sql = """
                SELECT id, book_name, author_name
                FROM books
                """;

        RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
            Book book = new Book(
                    rs.getLong("id"),
                    rs.getString("book_name"),
                    rs.getString("author_name")
            );
            return book;
        };
        List<Book> books = jdbcTemplate.query(sql, bookRowMapper);
        return books;
    }
}