package com.jsanghvi.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

class Catalog {
    private final Map<String, Item> items = new HashMap<>();

    public Item createItem(String itemName) {
        if (!items.containsKey(itemName)) {
            items.put(itemName, new Item(itemName));
        }
        return items.get(itemName);
    }

    public int totalItems() {
        return items.size();
    }
}
