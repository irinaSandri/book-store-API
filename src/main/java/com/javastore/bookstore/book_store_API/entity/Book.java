package com.javastore.bookstore.book_store_API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.processing.Pattern;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Details about the book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "The unique ID of the book", example = "1")
    private Long id;

    @Column(name="title",nullable = false)
    @Schema(description = "Title of the book", example = "The Divine Comedy")
    private String title;

    @Column(name="author",nullable = false)
    @Schema(description = "Author of the book", example = "Dante Alighieri")
    private String author;

    @Column(name="genre",nullable = false)
    @Schema(description = "The genre of the book", example = "Poetry")
    private String genre;

    @Column(name="price",nullable = false)
    @Schema(description = "The price of the book", example = "19.00")
    private Double price;

    @Column(name="stock",nullable = false)
    @Schema(description = "How many books are in stock", example = "25")
    private int stock;

    @Column(name="published_date",nullable = false)
    @Schema(description = "The year when book was published", example = "1300")
    private int publishedDate;

}
