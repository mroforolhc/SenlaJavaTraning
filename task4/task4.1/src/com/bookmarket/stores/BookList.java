package com.bookmarket.stores;

import com.bookmarket.model.Book;
import com.bookmarket.util.BookFileUtil;

import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> books = new ArrayList<>();
    //private BookFileUtil fileWorker = new BookFileUtil();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    // Добавляет книгу на склад/полку/etc.
    public void add(Book book) {
        getBooks().add(book);
    }

    // Добавляет заданное кол-во определенных книг
    public void update(Book book, int qt) {
        if (getBooks().contains(book)) {
            int nowQt = book.getQt();
            int i = getBooks().indexOf(book);
            getBooks().get(i).setQt(nowQt + qt);
        } else {
            add(book);
            update(book, qt);
        }
    }

    // Убирает заданное кол-во определенных книг
    public void remove(Book book, int qt) {
        int nowQt = book.getQt();
        int i = getBooks().indexOf(book);
        System.out.print("");

        if (nowQt > qt) {
            getBooks().get(i).setQt(nowQt - qt);
        } else if (nowQt == qt) {
            delete(book);
        }
    }

    // Убирает книгу со склада/полки
    public void delete(Book book) {
        getBooks().remove(book);
    }

    /*
    public void save() {
        Book[] tmpArray = getBooks().toArray(new Book[books.size()]);
        fileWorker.writeToFile(tmpArray);
    }
    public void load() {
        Book[] books = fileWorker.readFromFile();
        ArrayList<Book> tmpArray = new ArrayList<>(Arrays.asList(books));
        for (Book book : tmpArray) {
            System.out.println(book.toString());
        }
        setBooks(tmpArray);
    }
    */
}
