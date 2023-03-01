package com.example.muon_sach.controller;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.BorrowBook;
import com.example.muon_sach.service.book.IBookService;
import com.example.muon_sach.service.borrow_book.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IBorrowBookService iBorrowBookService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("bookList",iBookService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("book",new Book());
        return "create";
    }
    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book){
        iBookService.save(book);
        return "redirect:/book";
    }
    @GetMapping("/borrow")
    public String borrowBook(@RequestParam int id,Model model){
        Book book = iBookService.findById(id);
        int quantity = book.getQuantity();
        if(quantity==0){
            return "quantityError";
        }
        book.setQuantity(quantity-1);
        iBookService.save(book);
        int code = (int) Math.floor(Math.random()*99999);
        String borrowCode =code+"";
        BorrowBook borrowBook = new BorrowBook(borrowCode,book);
        iBorrowBookService.save(borrowBook);
        model.addAttribute("borrowCode",borrowCode);
        return "borrow";
    }
    @GetMapping("/return")
    public String showReturn(Model model){
        model.addAttribute("borrowBook",new BorrowBook());
        return "return";
    }
    @PostMapping("/return")
    public String returnBook(@ModelAttribute BorrowBook borrowBook,Model model){
        BorrowBook borrowBook1 = iBorrowBookService.findById(borrowBook.getBorrowCode());
        if(borrowBook1==null){
            return "nullError";
        }
        Book book = borrowBook1.getBook();
        int quantity = book.getQuantity();
        book.setQuantity(quantity+1);
        iBookService.save(book);
        iBorrowBookService.delete(borrowBook1.getBorrowCode());
        model.addAttribute("bookList",iBookService.findAll());
        model.addAttribute("borrowCode","Bạn đã trả thành công, hẹn gặp lại");
        return "list";
    }
}
