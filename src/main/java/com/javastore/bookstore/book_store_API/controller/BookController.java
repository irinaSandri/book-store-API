package com.javastore.bookstore.book_store_API.controller;

import com.javastore.bookstore.book_store_API.entity.Book;
import com.javastore.bookstore.book_store_API.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    //Retrieve a book by its id
    @Operation(summary = "Get a book by its ID")
    @ApiResponse(responseCode = "200", description = "Book found")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }


    //Save book
    @Operation (summary = "Create a new book")
    @ApiResponse(responseCode = "201", description = "Book created")
    @PostMapping
    public ResponseEntity<HttpStatus> saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


   //Delete book
    @Operation(summary = "Delete a book found by its ID")
    @ApiResponse(responseCode = "204", description = "Book deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   //Retrieve all books
    @Operation(summary = "Get all books")
    @ApiResponse(responseCode = "200", description = "Books found")
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    //Update book's fields
    @Operation(summary = "Update book found by its id")
    @ApiResponse(responseCode = "200", description = "Book updated")
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Managing the stock/buying a book
    @Operation(summary = "Purchase a book")
    @ApiResponse(responseCode = "202",description = "Book purchased")
    @PostMapping("/{id}/purchase")
    public ResponseEntity<Book> purchaseBook(@PathVariable Long id) {
         return new ResponseEntity<>(bookService.purchaseBook(id),HttpStatus.ACCEPTED);
    }

    //Retrieve book by title
    @Operation(summary = "Get book by title")
    @ApiResponse(responseCode = "200",description = "Book found")
    @GetMapping("/search/title")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title){
        return new ResponseEntity<>(bookService.getBookByTitle(title),HttpStatus.OK);
    }

    //Retrieve book by author
    @Operation(summary = "Get book by author")
    @ApiResponse(responseCode = "200",description = "Book found")
    @GetMapping ("/search/author")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable String author){
        return new ResponseEntity<>(bookService.getBookByAuthor(author),HttpStatus.OK);
    }

    //Retireve a book by genre
    @Operation(summary = "Get book by genre")
    @ApiResponse(responseCode = "200",description = "Book found")
    @GetMapping("/search/genre")
    public ResponseEntity<Book> getBookByGenre(@PathVariable String genre){
        return new ResponseEntity<>(bookService.getBookByGenre(genre),HttpStatus.OK);
    }

}
