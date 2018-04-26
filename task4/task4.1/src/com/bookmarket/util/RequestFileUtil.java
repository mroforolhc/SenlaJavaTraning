package com.bookmarket.util;

import com.bookmarket.model.Book;
import com.bookmarket.model.Client;
import com.bookmarket.model.Request;
import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;

import java.time.LocalDate;

public class RequestFileUtil implements FileUtil<Request> {
    private static final String FILE = "data/Request.txt";

    private final FileWorker fileWorker;

    public RequestFileUtil() {
        fileWorker = new TextFileWorker(FILE);
    }

    @Override
    public Request[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Request[] result = new Request[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    @Override
    public void writeToFile(Request[] values) {
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
    public String toLine(Request entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final String[] array = new String[] {
                entity.getBook().getIsbn(),
                entity.getBook().getAuthor(),
                String.valueOf(entity.getBook().getDateOfPublication()),
                entity.getBook().getTitle(),
                String.valueOf(entity.getBook().getPrice()),
                String.valueOf(entity.getBook().getQt()),
                entity.getStatus()
        };
        return String.join(";", array);
    }

    @Override
    public Request fromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split(";");

        final Request result = new Request(new Book(parts[0], parts[1], LocalDate.parse(parts[2]),
                parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
        result.setStatus(parts[6]);

        return result;
    }


}
