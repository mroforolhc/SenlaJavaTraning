package com.bookmarket.stores;

import com.bookmarket.model.Book;
import com.bookmarket.model.Request;
import com.bookmarket.util.RequestFileUtil;

import java.util.ArrayList;

public class RequestList {

    private ArrayList<Request> requests = new ArrayList<>();
    //private RequestFileUtil fileWorker = new RequestFileUtil();

    public ArrayList<Request> getRequests() {
        return requests;
    }
    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }


    // Если запрос на книгу есть в листе, увеличивает этот запрос
    // Иначе - добавляет в лист
    public void add(Request request) {
        boolean found = false;
        for (Request req : getRequests()) {
            if (req.getBook().equals(request.getBook())) {
                found = true;

                int nowQt = req.getQt();
                int i = getRequests().indexOf(req);
                getRequests().get(i).setQt(nowQt + 1);
                req.setStatus("active");
                break;
            }
        }
        if (!found) {
            getRequests().add(request);
        }
    }

    // Если запросов больше чем книг, уменьшаем qt на количество добавленных книг
    // Иначе - убираем запрос
    public void complete(Book book) {
        for (Request request : getRequests()) {
            if (request.getBook().equals(book)) {
                if (request.getQt() <= book.getQt()) {
                    request.setQt(0);
                    request.setStatus("complete");
                } else {
                    request.setQt(request.getQt() - book.getQt());
                }
            }
        }
    }

    /*
    public void save() {
        Request[] tmpArray = getRequests().toArray(new Request[requests.size()]);
        fileWorker.writeToFile(tmpArray);
    }
    public void load() {
        Request[] requests = fileWorker.readFromFile();
        ArrayList<Request> tmpArray = new ArrayList<>(Arrays.asList(requests));
        setRequests(tmpArray);
    }
    */
}
