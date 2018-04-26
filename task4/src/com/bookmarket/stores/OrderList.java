package com.bookmarket.stores;

import com.bookmarket.model.Order;
import com.bookmarket.util.OrderFileUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderList {

    private ArrayList<Order> orders = new ArrayList<>();
    //private OrderFileUtil fileWorker = new OrderFileUtil();

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    // Заказ упакован и едет к клиенту
    public void pack(Order order) {
        order.calculatePrice();
        order.setStatus("packed");

        getOrders().add(order);
    }

    // Клиент подтвердил заказ
    public void complete(Order order) {
        order.setStatus("completed");
        order.setDateOfComplete(LocalDate.now());
    }

    // Клиент отклонил заказ
    public void cancel(Order order) {
        order.setStatus("canceled");
    }

    /*
    public void save() {
        Order[] tmpArray = getOrders().toArray(new Order[orders.size()]);
        fileWorker.writeToFile(tmpArray);
    }
    public void load() {
        Order[] orders = fileWorker.readFromFile();
        ArrayList<Order> tmpArray = new ArrayList<>(Arrays.asList(orders));
        setOrders(tmpArray);
    }
    */
}
