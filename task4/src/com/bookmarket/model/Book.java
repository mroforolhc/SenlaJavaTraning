package com.bookmarket.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Book {

    private String isbn; // International Standard Book Number
    private String author;
    private LocalDate dateOfPublication;
    private String title;
    private int price;
    private int qt;     // quantity
    private LocalDate dateOfSupply;
    private String description = "No description";


    public Book(String isbn, String author, LocalDate dateOfPublication, String title, int price, int qt) {
        setIsbn(isbn);
        setAuthor(author);
        setDateOfPublication(dateOfPublication);
        setTitle(title);
        setPrice(price);
        setQt(qt);

        setDateOfSupply(LocalDate.now());
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }
    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public String toString() {
        return "Author: " + author + ", title: " + title + ", price: " + price + ", qt: " + qt;
    }

    public LocalDate getDateOfSupply() {
        return dateOfSupply;
    }
    public void setDateOfSupply(LocalDate dateOfSupply) {
        this.dateOfSupply = dateOfSupply;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getQt() {
        return qt;
    }
    public void setQt(int qt) {
        this.qt = qt;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
