package com.jsanghvi.patterns.structural.facade;

class FacadeJdbcDemo {
    public static void main(String[] args) {
        JdbcTableFacade table = new JdbcTableFacade(Address.getTableName(), Address.getTableFields());

        table.insert(new Address(1, "Rasoolpura", "Secunderabad"));
        table.insert(new Address(2, "Ameerpet", "Hyderabad"));
        table.insert(new Address(3, "Madhapur", "Hyderabad"));

        table.getAddresses().forEach(System.out::println);
    }
}
