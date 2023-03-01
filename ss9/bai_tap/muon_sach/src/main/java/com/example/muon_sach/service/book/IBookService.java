package com.example.muon_sach.service.book;

import com.example.muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void save(Book user);
    void delete(int id);
    Book findById(int id);
}
