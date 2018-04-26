package com.bookmarket.services;

import com.bookmarket.model.Order;
import com.bookmarket.stores.OrderList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderSort {
    private OrderList orders;

    public OrderSort(OrderList orders) {
        setOrders(orders);
    }

    public void setOrders(OrderList orders) {
        this.orders = orders;
    }

    public ArrayList<Order> sortByStatus() {
        ArrayList<Order> sortedOrders = (ArrayList<Order>) orders.getOrders().clone();
        Collections.sort(sortedOrders, Comparator.comparing(Order::getStatus));
        return sortedOrders;
    }

    public ArrayList<Order> sortByPrice() {
        ArrayList<Order> sortedOrders = (ArrayList<Order>) orders.getOrders().clone();
        Collections.sort(sortedOrders, Comparator.comparing(Order::getPrice));
        return sortedOrders;
    }

}