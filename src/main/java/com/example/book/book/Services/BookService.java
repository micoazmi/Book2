package com.example.book.book.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.book.Models.Book;
import com.example.book.book.Repositorys.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> search(String keyword) {
        return bookRepository.findByJudulContainingIgnoreCase(keyword);
    }

    public void create(Book book) {
        bookRepository.save(book);
    }

    public void update(Long id, Book book) {
        bookRepository.findById(id).ifPresent(item -> {
            item.setPenerbit(book.getPenerbit());
            item.setJudul(book.getJudul());
            item.setPenulis(book.getPenulis());
            item.setTahun(book.getTahun());
            bookRepository.save(item);
        });
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
