package com.example.j2ee_buibinhnguyen_0302.service

import com.example.j2ee_buibinhnguyen_0302.model.Book
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Consumer

@Service
class BookService {
    val allBooks: MutableList<Book?> = ArrayList<Book?>()
    private var lastId = 0 // Biến đếm để tự tăng ID

    init {
        // Thêm dữ liệu mẫu
        addBook(Book(++lastId, "Spring Boot Action", "Craig Walls"))
        addBook(Book(++lastId, "Clean Code", "Robert C. Martin"))
    }

    fun addBook(book: Book) {
        book.id = ++lastId // Tự động set ID mới
        allBooks.add(book)
    }

    fun getBookById(id: Int): Optional<Book?> {
        return allBooks.stream().filter { b: Book? -> b!!.id == id }.findFirst()
    }

    fun updateBook(book: Book) {
        getBookById(book.id).ifPresent(Consumer { existingBook: Book? ->
            existingBook!!.title = book.title
            existingBook.author = book.author
        })
    }

    fun deleteBook(id: Int) {
        allBooks.removeIf { b: Book? -> b!!.id == id }
    }
}