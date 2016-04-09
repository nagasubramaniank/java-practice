package com.jsanghvi.patterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

abstract class Website {
    List<Page> pages = new ArrayList<>();

    Website() {
        this.createWebsite();
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    protected abstract void createWebsite();
}
