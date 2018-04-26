package com.bookmarket.util;

import com.bookmarket.model.Book;
import com.bookmarket.model.Client;
import com.bookmarket.model.Order;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderFileUtil implements FileUtil<Order> {
    private static final String FILE = "data/Order.txt";

    private final FileWorker fileWorker;

    public OrderFileUtil() {
        fileWorker = new TextFileWorker(FILE);
    }

    @Override
    public Order[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Order[] result = new Order[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    @Override
    public void writeToFile(Order[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }
        final String[] lines = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            lines[i] = toLine(values[i]);
        }
        fileWorker.writeToFile(lines);
    }

    @Override
    public String toLine(Order entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final ArrayList<String> array = new ArrayList<>();
        array.add(entity.getClient().getFirstName());
        array.add(entity.getClient().getSecondName());
        array.add(entity.getStatus());
        array.add(String.valueOf(entity.getListOfBooks().size()));
        for (int i = 0; i < entity.getListOfBooks().size(); i++) {
            Book book = entity.getListOfBooks().get(i);
            array.add(book.getIsbn());
            array.add(book.getAuthor());
            array.add(String.valueOf(book.getDateOfPublication()));
            array.add(book.getTitle());
            array.add(String.valueOf(book.getPrice()));
            array.add(String.valueOf(book.getQt()));
        }
        array.add(String.valueOf(entity.getPrice()));
        array.add(String.valueOf(entity.getDateOfComplete()));

        return String.join(";", array);
    }

    @Override
    public Order fromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split(";");

        final Order result = new Order(new Client(parts[0], parts[1]));
        result.setStatus(parts[2]);
        ArrayList<Book> list = new ArrayList<>();

        int factor = Integer.parseInt(parts[3]);
        for (int i = 0; i < factor; i++) {
            list.add(new Book(parts[4 + i*6], parts[5 + i*6], LocalDate.parse(parts[6 + i*6]),
                    parts[7 + i*6], Integer.parseInt(parts[8 + i*6]), Integer.parseInt(parts[9 + i*6])));
        }
        result.setListOfBooks(list);
        result.setPrice(Integer.parseInt(parts[4 + factor*6]));
        result.setDateOfComplete(LocalDate.parse(parts[5 + factor*6]));

        return result;
    }
}
