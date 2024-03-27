package com.example.book.book.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.book.book.Response;
import com.example.book.book.Models.Book;
import com.example.book.book.Services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public Response getAll(@RequestParam(value = "search", required = false) String keyword) {
        if (keyword != null) {
            return new Response(HttpStatus.OK, "succes search books", bookService.search(keyword));

        } else {
            return new Response(HttpStatus.OK, "succes get all books", bookService.list());
        }
    }

    @PostMapping("")
    public Response create(@RequestBody Book book) {
        bookService.create(book);
        return new Response(HttpStatus.CREATED, "berhasil menambah buku", book);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody Book book) {
        bookService.update(id, book);
        return new Response(HttpStatus.OK, "berhasil mengedit buku", book);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        bookService.delete(id);
        return new Response(HttpStatus.OK, "berhasil delete buku", null);
    }
}
