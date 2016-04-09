package com.jsanghvi.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

class Registry {
    private final Map<String, Item> items = new HashMap<>();

    public Registry() {
        loadItems();
    }

    public Item createItem(String type) {
        Item item = null;

        try {
            item = items.get(type).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return item;
    }

    private void loadItems() {
        Book book = new Book();
        book.setTitle("Basic Book");
        book.setPrice(19.99);
        book.setNumberOfPages(987);
        items.put("Book", book);

        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(39.99);
        movie.setRuntime("2 hours");
        items.put("Movie", movie);
    }
}
