package com.jsanghvi.patterns.structural.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

class FacadeEverydayDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.github.com/users/jatin085");

            // Function openStream() hides the steps involved in setting up connection, handling streams, etc.
            try (Reader reader = new InputStreamReader(url.openStream());
                 BufferedReader bufferedReader = new BufferedReader(reader)
            ) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
