package com.jsanghvi.discrete_mathematics;

public class ExtendedEuclideanAlgorithm {
    public static void main(final String[] args) {
        printCoefficients(10, 15);
        printCoefficients(35, 15);
        printCoefficients(56, 27);
    }

    private static void printCoefficients(final int number1, final int number2) {
        GcdResult gcdResult = computeGcd(number1, number2);
        System.out.println(gcdResult.coefficient1 + " * " + number1 + " + " + gcdResult.coefficient2 + " * " + number2
                + " = " + gcdResult.gcd);
    }

    private static GcdResult computeGcd(final int number1, final int number2) {
        if (number1 == 0) {
            return new GcdResult(number2, 0, 1);
        }

        GcdResult gcdResult = computeGcd(number2 % number1, number1);
        return new GcdResult(gcdResult.gcd, gcdResult.coefficient2 - (number2 / number1) * gcdResult.coefficient1,
                gcdResult.coefficient1);
    }

    private static class GcdResult {
        private final int gcd;
        private final int coefficient1;
        private final int coefficient2;

        public GcdResult(final int gcd, final int coefficient1, final int coefficient2) {
            this.gcd = gcd;
            this.coefficient1 = coefficient1;
            this.coefficient2 = coefficient2;
        }
    }
}
