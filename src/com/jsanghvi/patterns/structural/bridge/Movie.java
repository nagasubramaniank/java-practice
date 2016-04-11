package com.jsanghvi.patterns.structural.bridge;

class Movie {
    private final String title;
    private final String genre;
    private final String runtime;
    private final String year;

    public Movie(String title, String genre, String runtime, String year) {
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getYear() {
        return year;
    }
}
