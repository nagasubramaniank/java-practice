package com.jsanghvi.patterns.structural.bridge;

class BridgeDemo {
    public static void main(String[] args) {
        Movie movie = new Movie("John Wick", "Action", "2:15", "2014");

        // Printer: Abstraction, MoviePrinter: Refined Abstraction.
        Printer moviePrinter = new MoviePrinter(movie);

        // Formatter: Implementor, PrintFormatter: Concrete Implementor.
        Formatter printFormatter = new PrintFormatter();
        String printedMaterial = moviePrinter.print(printFormatter);
        System.out.println(printedMaterial);

        Formatter htmlFormatter = new HtmlFormatter();
        String htmlMaterial = moviePrinter.print(htmlFormatter);
        System.out.println(htmlMaterial);
    }
}
