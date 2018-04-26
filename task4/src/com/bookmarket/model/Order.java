package com.bookmarket.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private Client client;
    private String status = "waiting";
    private ArrayList<Book> listOfBooks = new ArrayList<>();
    private int price = 0;
    private LocalDate dateOfComplete = LocalDate.of(1970,1,1);


    @Override
    public String toString() {
        ArrayList<String> books = new ArrayList<>();
        for (Book book : getListOfBooks()) {
            books.add(book.getAuthor() + " - " + book.getTitle());
        }
        return "[Заказ] Список книг: " + String.join(". ", books) +
                ". \nСтатус: " + getStatus() + ". Цена: " + getPrice();
    }

    public Order(Client client) {
        setClient(client);
    }

    public void addBook(Book book) {
        if (book.getQt() > 0) {
            getListOfBooks().add(book);
        } else {
            // Книга отсутствует в продаже, предложение создать реквест
        }
    }

    public void removeBook(Book book) {
        getListOfBooks().remove(book);
    }

    public void calculatePrice() {
        for (Book book : listOfBooks) {
            setPrice(book.getPrice() + getPrice());
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }
    public void setListOfBooks(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public LocalDate getDateOfComplete() {
        return dateOfComplete;
    }
    public void setDateOfComplete(LocalDate dateOfComplete) {
        this.dateOfComplete = dateOfComplete;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

}
