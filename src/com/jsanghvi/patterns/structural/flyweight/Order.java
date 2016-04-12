package com.jsanghvi.patterns.structural.flyweight;

class Order {
    private final Item item;
    private final int orderNumber;

    public Order(Item item, int orderNumber) {
        this.item = item;
        this.orderNumber = orderNumber;
    }

    public void process() {
        System.out.println("Ordering item '" + item + "' for order number: " + orderNumber + ".");
    }
}
