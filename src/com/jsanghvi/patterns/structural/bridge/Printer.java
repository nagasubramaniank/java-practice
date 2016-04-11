package com.jsanghvi.patterns.structural.bridge;

import java.util.List;

abstract class Printer {

    public String print(Formatter formatter) {
        return formatter.format(this.getHeader(), this.getDetails());
    }

    abstract protected String getHeader();

    abstract protected List<Detail> getDetails();
}
