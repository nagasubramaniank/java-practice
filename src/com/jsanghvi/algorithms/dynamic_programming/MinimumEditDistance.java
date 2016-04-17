// Problem 5. Edit Distance
//
// Given two text strings A of length n and B of length m, you want to transform A into B with a minimum number of
// operations of the following types: delete a character from A, insert a character into A, or change some character
// in A into a new character. The minimal number of such operations required to transform A into B is called the edit
// distance between A and B.

package com.jsanghvi.algorithms.dynamic_programming;

class MinimumEditDistance {
    public static void main(String[] args) {
        printMinimumEditSequence("", "", 1.0, 1.0, 1.0);
        printMinimumEditSequence("APART", "", 1.0, 1.0, 1.0);
        printMinimumEditSequence("", "PRETTY", 1.0, 1.0, 1.0);

        printMinimumEditSequence("APART", "PRETTY", 4.0, 1.0, 1.0);
        printMinimumEditSequence("APART", "PRETTY", 1.0, 4.0, 1.0);
        printMinimumEditSequence("APART", "PRETTY", 1.0, 1.0, 4.0);
    }

    private static void printMinimumEditSequence(String oldString, String newString, double insertCost,
                                                 double deleteCost, double replaceCost) {

        double[][] editCosts = new double[oldString.length() + 1][newString.length() + 1];
        Operation[][] operations = new Operation[oldString.length() + 1][newString.length() + 1];

        editCosts[0][0] = 0;
        operations[0][0] = Operation.NOOP;

        for (int oldCharIndex = 0; oldCharIndex < oldString.length(); oldCharIndex++) {
            editCosts[oldCharIndex + 1][0] = deleteCost * (oldCharIndex + 1);
            operations[oldCharIndex + 1][0] = Operation.DELETE;
        }

        for (int newCharIndex = 0; newCharIndex < newString.length(); newCharIndex++) {
            editCosts[0][newCharIndex + 1] = insertCost * (newCharIndex + 1);
            operations[0][newCharIndex + 1] = Operation.INSERT;
        }

        for (int oldCharIndex = 0; oldCharIndex < oldString.length(); oldCharIndex++) {
            for (int newCharIndex = 0; newCharIndex < newString.length(); newCharIndex++) {

                if (oldString.charAt(oldCharIndex) == newString.charAt(newCharIndex)) {
                    editCosts[oldCharIndex + 1][newCharIndex + 1] = editCosts[oldCharIndex][newCharIndex];
                    operations[oldCharIndex + 1][newCharIndex + 1] = Operation.NOOP;
                } else {
                    editCosts[oldCharIndex + 1][newCharIndex + 1] =
                            editCosts[oldCharIndex][newCharIndex] + replaceCost;
                    operations[oldCharIndex + 1][newCharIndex + 1] = Operation.REPLACE;
                }

                double costAfterInsert = editCosts[oldCharIndex + 1][newCharIndex] + insertCost;
                double costAfterDelete = deleteCost + editCosts[oldCharIndex][newCharIndex + 1];

                if (editCosts[oldCharIndex + 1][newCharIndex + 1] > costAfterInsert) {
                    editCosts[oldCharIndex + 1][newCharIndex + 1] = costAfterInsert;
                    operations[oldCharIndex + 1][newCharIndex + 1] = Operation.INSERT;
                }

                if (editCosts[oldCharIndex + 1][newCharIndex + 1] > costAfterDelete) {
                    editCosts[oldCharIndex + 1][newCharIndex + 1] = costAfterDelete;
                    operations[oldCharIndex + 1][newCharIndex + 1] = Operation.DELETE;
                }
            }
        }

        System.out.println("Minimum Edit Distance: " + editCosts[oldString.length()][newString.length()]);
        System.out.println("Edit Sequence (in reverse order):");

        StringBuilder string = new StringBuilder(newString);
        System.out.println(string);

        for (int oldCharIndex = oldString.length() - 1, newCharIndex = newString.length() - 1;
             oldCharIndex >= 0 || newCharIndex >= 0; ) {
            switch (operations[oldCharIndex + 1][newCharIndex + 1]) {
                case NOOP:
                    newCharIndex -= 1;
                    oldCharIndex -= 1;
                    continue;
                case REPLACE:
                    string.setCharAt(newCharIndex, oldString.charAt(oldCharIndex));
                    newCharIndex -= 1;
                    oldCharIndex -= 1;
                    break;
                case INSERT:
                    string.deleteCharAt(newCharIndex);
                    newCharIndex -= 1;
                    break;
                case DELETE:
                    if (newCharIndex + 1 == string.length()) {
                        string.append(oldString.charAt(oldCharIndex));
                    } else {
                        string.insert(newCharIndex + 1, oldString.charAt(oldCharIndex));
                    }
                    oldCharIndex -= 1;
                    break;
            }

            System.out.println(string);
        }

        System.out.println();
    }

    private enum Operation {
        NOOP, INSERT, DELETE, REPLACE
    }
}
