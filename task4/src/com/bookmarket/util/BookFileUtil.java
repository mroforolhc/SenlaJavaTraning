package com.bookmarket.util;

import com.bookmarket.model.Book;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import java.time.LocalDate;

public class BookFileUtil implements FileUtil<Book> {
    private static final String FILE = "data/Book.txt";

    private final FileWorker fileWorker;

    public BookFileUtil() {
        fileWorker = new TextFileWorker(FILE);
    }

    @Override
    public Book[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Book[] result = new Book[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    @Override
    public void writeToFile(Book[] values) {
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
    public String toLine(Book entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final String[] array = new String[] {
                entity.getIsbn(),
                entity.getAuthor(),
                String.valueOf(entity.getDateOfPublication()),
                entity.getTitle(),
                String.valueOf(entity.getPrice()),
                String.valueOf(entity.getQt()),
                entity.getDescription()
        };
        return String.join(";", array);
    }

    @Override
    public Book fromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split(";");

        final Book result = new Book(
                parts[0],
                parts[1],
                LocalDate.parse(parts[2]),
                parts[3],
                Integer.parseInt(parts[4]),
                Integer.parseInt(parts[5])
        );
        result.setDescription(parts[6]);
        return result;
    }
}
