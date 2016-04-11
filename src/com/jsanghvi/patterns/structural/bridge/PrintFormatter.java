package com.jsanghvi.patterns.structural.bridge;

import java.util.List;

public class PrintFormatter implements Formatter {
    @Override
    public String format(String header, List<Detail> details) {
        StringBuilder builder = new StringBuilder();
        builder.append(header);
        builder.append("\n");

        details.forEach(detail -> {
            builder.append(detail.getLabel());
            builder.append(": ");
            builder.append(detail.getValue());
            builder.append("\n");
        });

        return builder.toString();
    }
}
