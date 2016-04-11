package com.jsanghvi.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

class Menu extends MenuItem {
    private List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name, String url) {
        super(name, url);
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(": ").append(url).append("\n");
        menuComponents.forEach(builder::append);
        return builder.toString();
    }
}
