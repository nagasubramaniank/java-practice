package com.jsanghvi.patterns.structural.bridge;

public class Detail {
    private final String label;
    private final String value;

    public Detail(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}
