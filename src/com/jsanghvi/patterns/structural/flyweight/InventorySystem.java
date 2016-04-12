package com.jsanghvi.patterns.structural.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class InventorySystem {
    private final Catalog catalog = new Catalog();
    private final List<Order> orders = new CopyOnWriteArrayList<>();

    public void takeOrder(String itemName, int orderNumber) {
        orders.add(new Order(catalog.createItem(itemName), orderNumber));
    }

    public void processOrders() {
        orders.forEach(Order::process);
        orders.clear();
    }

    public String report() {
        return "Total " + catalog.totalItems() + " item objects created.";
    }
}
