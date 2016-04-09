package com.jsanghvi.patterns.creational.abstractfactory;

public class AbstractFactoryDemo {

    public static void main(String args[]) {
        // Abstract Factory.
        CreditCardFactory creditCardFactory = CreditCardFactory.getCreditCardFactory(600);

        CreditCard creditCard1 = creditCardFactory.getCreditCard(CardType.GOLD);
        CreditCard creditCard2 = creditCardFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(creditCard1.getClass());
        System.out.println(creditCard2.getClass());

        creditCardFactory = CreditCardFactory.getCreditCardFactory(700);

        Validator validator1 = creditCardFactory.getValidator(CardType.GOLD);
        Validator validator2 = creditCardFactory.getValidator(CardType.PLATINUM);

        System.out.println(validator1.getClass());
        System.out.println(validator2.getClass());
    }
}
