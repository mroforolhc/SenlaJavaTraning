package com.bookmarket.model;

import com.bookmarket.stores.*;

public class Market {

    private BookList books = new BookList();
    private OrderList orders = new OrderList();
    private RequestList requests = new RequestList();

    public void addBook(Book book) {
        books.add(book);
        requests.complete(book);
    }
    public void updateBook(Book book, int qt) {
        books.update(book, qt);
    }
    public void removeBook(Book book, int qt) {
        books.remove(book, qt);
    }

    public void packOrder(Order order) {
        orders.pack(order);

        // Со склада списываем книги
        for (Book book : order.getListOfBooks()) {
            books.remove(book, 1);
        }
    }
    public void cancelOrder(Order order) {
        orders.cancel(order);

        // Добавляем обратно
        for (Book book : order.getListOfBooks()) {
            books.update(book, 1);
        }
    }
    public void completeOrder(Order order) {
        orders.complete(order);
    }

    public void sendRequest(Request request) {
        requests.add(request);
    }

    public void printAll() {
        for (Book book : books.getBooks()) {
            System.out.println(book.toString());
        }
        System.out.println();
        for (Order order : orders.getOrders()) {
            System.out.println(order.toString());
        }
        System.out.println();
        for (Request request : requests.getRequests()) {
            System.out.println(request.toString());
        }
    }

    public BookList getBooks() {
        return books;
    }
    public OrderList getOrders() {
        return orders;
    }
    public RequestList getRequests() {
        return requests;
    }
}
