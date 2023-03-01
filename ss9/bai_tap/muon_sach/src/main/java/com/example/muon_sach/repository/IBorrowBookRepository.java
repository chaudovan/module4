package com.example.muon_sach.repository;

import com.example.muon_sach.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook,String> {
}
