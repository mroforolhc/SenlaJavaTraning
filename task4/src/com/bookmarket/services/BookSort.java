package com.bookmarket.services;

import com.bookmarket.model.Book;
import com.bookmarket.stores.BookList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookSort {
    private BookList books;

    public BookSort(BookList books) {
        setBooks(books);
    }

    public void setBooks(BookList books) {
        this.books = books;
    }

    public ArrayList<Book> sortByAlphabet() {
        ArrayList<Book> sortedBooks = (ArrayList<Book>) books.getBooks().clone();
        Collections.sort(sortedBooks, Comparator.comparing(Book::getTitle));
        return sortedBooks;
    }

    public ArrayList<Book> sortByPrice() {
        ArrayList<Book> sortedBooks = (ArrayList<Book>) books.getBooks().clone();
        Collections.sort(sortedBooks, Comparator.comparing(Book::getPrice));
        return sortedBooks;
    }

    public ArrayList<Book> sortByQt() {
        ArrayList<Book> sortedBooks = (ArrayList<Book>) books.getBooks().clone();
        Collections.sort(sortedBooks, Comparator.comparing(Book::getQt));
        return sortedBooks;
    }
}
