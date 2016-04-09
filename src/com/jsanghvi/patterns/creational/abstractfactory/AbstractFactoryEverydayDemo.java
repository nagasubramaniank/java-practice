package com.jsanghvi.patterns.creational.abstractfactory;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AbstractFactoryEverydayDemo {
    public static void main(String args[]) throws Exception {

        // Abstract Factory.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        // Factory.
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        String xml = "<document><body><stock>AAPL</stock></body></document>";
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        Document document = documentBuilder.parse(inputStream);

        document.getDocumentElement().normalize();

        System.out.println("Root element: " + document.getDocumentElement().getNodeName());
        System.out.println(documentBuilderFactory.getClass());
        System.out.println(documentBuilder.getClass());
    }
}
