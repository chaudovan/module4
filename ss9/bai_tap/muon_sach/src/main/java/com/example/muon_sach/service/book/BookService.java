package com.example.muon_sach.service.book;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        iBookRepository.deleteById(id);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }
}
