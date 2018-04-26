package com.bookmarket.model;

public class Request {

    private Book book;
    private String status;
    private int qt = 1;

    public Request(Book book) {
        setBook(book);
        setStatus("active");
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    @Override
    public String toString() {
        return "Request{" +
                "book=" + book +
                ", status='" + status + '\'' +
                ", qt=" + qt +
                '}';
    }
}
