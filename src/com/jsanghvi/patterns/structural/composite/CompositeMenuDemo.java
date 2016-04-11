package com.jsanghvi.patterns.structural.composite;

class CompositeMenuDemo {
    public static void main(String[] args) {
        MenuComponent mainMenu = new Menu("Main", "/main");

        MenuComponent fileMenu = new Menu("File", "/file");
        mainMenu.add(fileMenu);
        MenuComponent aboutMenu = new Menu("About", "/about");
        mainMenu.add(aboutMenu);

        MenuComponent openMenu = new Menu("Open", "/open");
        fileMenu.add(openMenu);
        fileMenu.add(new MenuItem("Save", "/save"));
        fileMenu.add(new MenuItem("Exit", "/exit"));

        openMenu.add(new MenuItem("New", "/open-new"));
        openMenu.add(new MenuItem("Existing", "/open-existing"));

        System.out.println(mainMenu);
    }
}
