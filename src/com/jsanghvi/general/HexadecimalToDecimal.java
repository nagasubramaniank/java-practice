// Convert a hexadecimal string (with maximum length 8) to decimal value.

package com.jsanghvi.general;

public class HexadecimalToDecimal {
    public static void main(final String[] args) {
        printDecimal("");
        printDecimal("0");
        printDecimal("CafeBabe");
        printDecimal("123456789");
        printDecimal("Abradbra");
    }

    private static void printDecimal(final String hexadecimal) {
        if (hexadecimal.length() > 8) {
            System.out.println("Input hexadecimal string: " + hexadecimal + " is too long.");
            return;
        }

        long decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            int value = getValue(hexadecimal.charAt(i));

            if (value < 0) {
                System.out.println("Input hexadecimal string: " + hexadecimal + " contains invalid character: "
                        + hexadecimal.charAt(i) + ".");
                return;
            }

            decimal = decimal * 16 + value;
        }

        System.out.println(hexadecimal + " (hex) = " + decimal + " (dec).");
    }

    private static int getValue(char hexDigit) {
        if (hexDigit >= 'A' && hexDigit <= 'F') {
            return hexDigit - 'A' + 10;
        } else if (hexDigit >= 'a' && hexDigit <= 'f') {
            return hexDigit - 'a' + 10;
        } else if (hexDigit >= '0' && hexDigit <= '9') {
            return hexDigit - '0';
        } else {
            return -1;
        }
    }
}
