package com.javastore.bookstore.book_store_API.service;

import com.javastore.bookstore.book_store_API.entity.Book;

import java.util.List;

public interface BookService {
    Book getBook(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
    List<Book> getBooks();
    void updateBook(Long id, Book updatedBook);
    Book purchaseBook(Long id);
    Book getBookByTitle(String title);
    Book getBookByAuthor(String author);
    Book getBookByGenre(String genre);
}
