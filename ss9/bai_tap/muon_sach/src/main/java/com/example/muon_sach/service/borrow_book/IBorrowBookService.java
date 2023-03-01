package com.example.muon_sach.service.borrow_book;


import com.example.muon_sach.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAll();
    void save(BorrowBook borrowBook);
    void delete(String id);
    BorrowBook findById(String id);
}
