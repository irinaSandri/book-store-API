package com.javastore.bookstore.book_store_API.service;

import com.javastore.bookstore.book_store_API.entity.Book;
import com.javastore.bookstore.book_store_API.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;


    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public void updateBook(Long id, Book updatedBook) {
        Book book=bookRepository.findById(id).get();
        book.setAuthor(updatedBook.getAuthor());
        book.setTitle(updatedBook.getTitle());
        book.setGenre(updatedBook.getGenre());
        book.setPrice(updatedBook.getPrice());
        book.setStock(updatedBook.getStock());
        book.setPublishedDate(updatedBook.getPublishedDate());
      bookRepository.save(book);
    }
    @Override
    public Book purchaseBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getStock() > 0) {
            book.setStock(book.getStock() - 1);
        } else {
            throw new RuntimeException("Out of stock");
        }

        return bookRepository.save(book);
    }

    @Override
    public Book getBookByTitle(String title) {
       return (Book) bookRepository.findByTitleContaining(title);
    }

    @Override
    public Book getBookByAuthor(String author) {
       return (Book) bookRepository.findByAuthorContaining(author);
    }

    @Override
    public Book getBookByGenre(String genre) {
        return (Book) bookRepository.findByGenreContaining(genre);
    }


}
