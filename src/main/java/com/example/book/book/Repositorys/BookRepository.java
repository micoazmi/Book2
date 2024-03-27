package com.example.book.book.Repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book.book.Models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByJudulContainingIgnoreCase(String judul);

    Optional<Book> findById(Long id);
}
