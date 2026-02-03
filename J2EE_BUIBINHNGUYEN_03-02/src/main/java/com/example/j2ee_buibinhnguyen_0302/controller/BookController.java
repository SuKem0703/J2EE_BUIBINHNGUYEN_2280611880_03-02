package com.example.j2ee_buibinhnguyen_0302.controller;

import com.example.j2ee_buibinhnguyen_0302.model.Book;
import com.example.j2ee_buibinhnguyen_0302.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. Hiển thị danh sách sách [cite: 389]
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // 2. Form thêm sách mới [cite: 394]
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // 3. Xử lý thêm sách [cite: 399]
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // 4. Form sửa sách [cite: 405]
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable int id, Model model) {
        bookService.getBookById(id).ifPresent(book -> {
            model.addAttribute("book", book);
        });
        return "edit-book";
    }

    // 5. Xử lý cập nhật sách [cite: 412]
    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // 6. Xử lý xóa sách [cite: 419]
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}