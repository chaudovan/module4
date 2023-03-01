package com.example.muon_sach.service.borrow_book;

import com.example.muon_sach.model.BorrowBook;
import com.example.muon_sach.repository.IBorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookService implements IBorrowBookService{
    @Autowired
    IBorrowBookRepository iBorrowBookRepository;
    @Override
    public List<BorrowBook> findAll() {
        return iBorrowBookRepository.findAll();
    }

    @Override
    public void save(BorrowBook borrowBook) {
        iBorrowBookRepository.save(borrowBook);
    }

    @Override
    public void delete(String id) {
        iBorrowBookRepository.deleteById(id);
    }

    @Override
    public BorrowBook findById(String id) {
        return iBorrowBookRepository.findById(id).orElse(null);
    }
}
