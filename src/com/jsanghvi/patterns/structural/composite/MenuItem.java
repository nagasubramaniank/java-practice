package com.jsanghvi.patterns.structural.composite;

class MenuItem implements MenuComponent {
    protected final String name;
    protected final String url;

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Feature is not implemented at this level.");
    }

    @Override
    public String toString() {
        return name + ": " + url + "\n";
    }
}
