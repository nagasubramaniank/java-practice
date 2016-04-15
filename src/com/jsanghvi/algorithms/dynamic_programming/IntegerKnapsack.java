// Problem 4. Integer Knapsack Problem (Duplicate Items Forbidden)
//
// This is the same problem as the example above, except here it is forbidden to use more than one instance of each type
// of item.

package com.jsanghvi.algorithms.dynamic_programming;

class IntegerKnapsack {

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(0, 0), new Item(8, 1), new Item(4, 2), new Item(12, 3),
                new Item(2, 4), new Item(10, 5), new Item(6, 6), new Item(14, 7),
                new Item(1, 8), new Item(9, 9), new Item(5, 10), new Item(13, 11),
                new Item(3, 12), new Item(11, 13), new Item(7, 14), new Item(15, 15)
        };

        printKnapsacksUpTo(50, items);
    }

    private static void printKnapsacksUpTo(final int maxKnapsackSize, final Item[] items) {

        // setSizeTable[i][j] will contain optimal value of Knapsack of size exactly equal to j, constructed from items
        // in set up to index i-1. If such a combination is not possible, then setSizeTable[i][j] will contain value -1.

        final int[][] setSizeTable = new int[items.length + 1][maxKnapsackSize + 1];

        // isItemIncluded[i][j] will be set to true if items[i-1] is part of the Knapsack resembled by
        // setSizeTable[i][j].
        final boolean[][] isItemIncluded = new boolean[items.length + 1][maxKnapsackSize + 1];

        // It is possible to create a Knapsack of size zero with empty set.
        setSizeTable[0][0] = 0;

        // It is not possible to create a Knapsack of non-zero size with empty set.
        for (int size = 1; size <= maxKnapsackSize; size++) {
            setSizeTable[0][size] = -1;
        }

        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {
            for (int size = 0; size <= maxKnapsackSize; size++) {

                setSizeTable[itemIndex + 1][size] = setSizeTable[itemIndex][size];

                if (size >= items[itemIndex].size) {
                    int sizeWithoutItem = size - items[itemIndex].size;
                    int valueWithoutItem = setSizeTable[itemIndex][sizeWithoutItem];

                    if (setSizeTable[itemIndex + 1][size] < valueWithoutItem + items[itemIndex].value) {
                        setSizeTable[itemIndex + 1][size] = valueWithoutItem + items[itemIndex].value;
                        isItemIncluded[itemIndex + 1][size] = true;
                    }
                }
            }
        }

        for (int knapsackSize = 0; knapsackSize <= maxKnapsackSize; knapsackSize++) {
            int optimumValue = 0;
            int optimumValueLastItemSize = -1;
            for (int size = 0; size <= knapsackSize; size++) {
                if (optimumValue < setSizeTable[items.length - 1][size]) {
                    optimumValue = setSizeTable[items.length - 1][size];
                    optimumValueLastItemSize = size;
                }
            }

            System.out.println("Knapsack Size: " + knapsackSize + ", Optimum Value: " + optimumValue);
            System.out.print("Items: ");
            int size = optimumValueLastItemSize;
            for (int itemIndex = items.length - 1; itemIndex >= 0 && size > 0; itemIndex--) {
                if (isItemIncluded[itemIndex + 1][size]) {
                    System.out.print(items[itemIndex].value + "(" + items[itemIndex].size + ") ");
                    size -= items[itemIndex].size;
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    private static class Item {
        private final int value;
        private final int size;

        public Item(final int value, final int size) {
            this.value = value;
            this.size = size;
        }
    }
}
