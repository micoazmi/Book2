package com.example.book.book.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue
    private Long Id;

    private String penulis;
    private String penerbit;
    private String judul;

    private Long tahun;

}
