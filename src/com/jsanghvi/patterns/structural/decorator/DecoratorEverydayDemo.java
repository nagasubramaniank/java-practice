package com.jsanghvi.patterns.structural.decorator;

import java.io.*;

class DecoratorEverydayDemo {
    public static void main(String[] args) {
        try {
            File file = new File("./output.txt");

            try (OutputStream outputStream = new FileOutputStream(file);
                 DataOutputStream dataOutputStream = new DataOutputStream(outputStream)
            ) {
                dataOutputStream.writeBytes("text");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
