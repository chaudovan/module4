package com.example.muon_sach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<BorrowBook> borrowBookSet;

    public Book() {
    }

    public Book(int id, String bookName, int quantity, Set<BorrowBook> borrowBookSet) {
        this.id = id;
        this.bookName = bookName;
        this.quantity = quantity;
        this.borrowBookSet = borrowBookSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<BorrowBook> getBorrowBookSet() {
        return borrowBookSet;
    }

    public void setBorrowBookSet(Set<BorrowBook> borrowBookSet) {
        this.borrowBookSet = borrowBookSet;
    }
}
