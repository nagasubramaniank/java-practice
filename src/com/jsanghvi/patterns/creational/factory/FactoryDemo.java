package com.jsanghvi.patterns.creational.factory;

public class FactoryDemo {
    public static void main(String args[]) {
        Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        System.out.println(site.getPages());

        Website blog = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println(blog.getPages());
    }
}
