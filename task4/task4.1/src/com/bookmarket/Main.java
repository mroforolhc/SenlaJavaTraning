package com.bookmarket;


import com.bookmarket.model.*;
import com.bookmarket.services.BookSort;
import com.bookmarket.services.OrderSort;
import com.bookmarket.util.BookFileUtil;
import com.bookmarket.util.FileUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("978-5-17-006740-2", "Irvine Welsh",
                LocalDate.of(1993, Month.NOVEMBER, 30), "Trainspotting", 245,5);
        book1.setDescription("Long description");
        Book book2 = new Book("978-5-17-084596-5", "Chuck Palahniuk",
                LocalDate.of(1996, Month.AUGUST, 17), "Fight Club", 310,15);
        book2.setDescription("Long description");
        Book book3 = new Book("978-5-17-080109-1", "Anthony Burgess",
                LocalDate.of(1962, Month.JANUARY, 3), "A Clockwork Orange", 189,12);
        book3.setDescription("Long description");
        Book book4 = new Book("978-5-17-0802512-6", "Gena Gorin",
                LocalDate.of(2017, Month.NOVEMBER, 30), "What are you doing in my fridge?", 500,4);
        book4.setDescription("Are you hungry?");

        final Book[] books = new Book[]{ book1, book2, book3, book4 };
        final FileUtil<Book> util = new BookFileUtil();

        util.writeToFile(books);

        // Check result
        System.out.println("initial array");
        for (int i = 0; i < books.length; i++ ){
            System.out.println(books[i]);
        }

        final Book[] readedValues = util.readFromFile();
        System.out.println("readed array");
        for (int i = 0; i < readedValues.length; i++ ){
            System.out.println(readedValues[i]);
        }

        // Создаем магазик, добавляем стафф
        Market labirint = new Market();
        labirint.addBook(book1);
        labirint.addBook(book2);
        labirint.addBook(book3);
        labirint.addBook(book4);

        // Мало чет экземпляров первой книги, обновим
        labirint.updateBook(book1, 10);
        // А книг №2 слишком много, увозим со склада
        labirint.removeBook(book2, 5);

        // А вот и клиенты подъехали
        Client client1 = new Client("Yan", "Markov");
        Client client2 = new Client("Gena", "Gorin");

        // Первый заказ, набор книг в корзинку
        Order order1 = new Order(client1);
        order1.addBook(book1);
        order1.addBook(book2);
        order1.removeBook(book2);
        order1.addBook(book1);
        // Пакуем всё, отправляем
        labirint.packOrder(order1);
        // Client1 передумал заказывать, курьер едет обратно
        labirint.cancelOrder(order1);

        // Подумал...и решил заказать еще раз
        // Второй заказ
        Order order2 = new Order(client1);
        order2.addBook(book1);
        order2.addBook(book4);
        order2.addBook(book4);
        order2.addBook(book4);
        order2.addBook(book4);
        order2.addBook(book3);

        // Success!
        labirint.packOrder(order2);
        labirint.completeOrder(order2);

        // Client2 решил заказать 4 книгу, но их все скупил client1. Придется реквестировать.
        Request request = new Request(book4);
        labirint.sendRequest(request);

        labirint.addBook(book4);

        //labirint.printAll();
        // Накидаю еще объектов для сортировки
        Order order3 = new Order(client1);
        order3.addBook(book1);
        order3.addBook(book2);
        labirint.packOrder(order3);
        labirint.completeOrder(order3);

        Book book5 = new Book("978-5-17-0802512-6", "Nobody",
                LocalDate.of(1999,2,12), "Nothing", 450, 9);
        Request request2 = new Request(book5);
        Request request3 = new Request(book5);
        Request request4 = new Request(book2);
        labirint.sendRequest(request2);
        labirint.sendRequest(request3);
        labirint.sendRequest(request4);

        // СОРТИРОВКИ (книги)
        BookSort bookSort = new BookSort(labirint.getBooks());

        ArrayList<Book> sortedList = new ArrayList<>(bookSort.sortByAlphabet());
        System.out.println("\nСортировка по названию:");
        for (Book book : sortedList) {
            System.out.println(book.toString());
        }

        sortedList = new ArrayList<>(bookSort.sortByPrice());
        System.out.println("\nСортировка по цене:");
        for (Book book : sortedList) {
            System.out.println(book.toString());
        }

        sortedList = new ArrayList<>(bookSort.sortByQt());
        System.out.println("\nСортировка по количеству:");
        for (Book book : sortedList) {
            System.out.println(book.toString());
        }

        // СОРТИРОВКИ (заказы)
        OrderSort orderSort = new OrderSort(labirint.getOrders());

        ArrayList<Order> sortedList2 = new ArrayList<>(orderSort.sortByPrice());
        System.out.println("\nСортировка по цене:");
        for (Order order : sortedList2) {
            System.out.println(order.toString());
        }

        sortedList2 = new ArrayList<>(orderSort.sortByStatus());
        System.out.println("\nСортировка по статусу:");
        for (Order order : sortedList2) {
            System.out.println(order.toString());
        }

    }
}
