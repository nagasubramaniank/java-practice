package com.jsanghvi.algorithms.sorting;

public class ThreeWayQuickSort<Item extends Comparable<Item>> extends AbstractSort<Item> {
    public static void main(String[] args) {
        final ThreeWayQuickSort<Integer> threeWayQuickSortInteger = new ThreeWayQuickSort<>();
        threeWayQuickSortInteger.test(new Integer[]{});
        threeWayQuickSortInteger.test(new Integer[]{0});
        threeWayQuickSortInteger.test(new Integer[]{0, 1, 2, 3});
        threeWayQuickSortInteger.test(new Integer[]{3, 2, 1, 0});

        final ThreeWayQuickSort<String> threeWayQuickSortString = new ThreeWayQuickSort<>();
        threeWayQuickSortString.test(new String[]{"to", "be", "or", "not", "to", "be"});
    }

    @Override
    protected void sort(final Item[] list) {
        sort(list, 0, list.length - 1);
    }

    private void sort(final Item[] list, final int startIndex, final int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int left = startIndex, current = startIndex + 1, right = endIndex;
        final Item pivot = list[startIndex];

        // Invariance within 'while' loop:
        // All values from startIndex..left-1  are less than pivot.
        // All values from left..current-1 are equal to pivot.
        // All values from right+1..endIndex are greater than pivot.

        while (current <= right) {
            final int compare = list[current].compareTo(pivot);

            if (compare < 0) {
                swap(list, left++, current++);
            } else if (compare > 0) {
                swap(list, current, right--);
            } else {
                current++;
            }
        }

        sort(list, startIndex, left - 1);
        sort(list, right + 1, endIndex);
    }
}
