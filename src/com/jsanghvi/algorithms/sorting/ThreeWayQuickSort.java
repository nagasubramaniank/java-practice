package com.jsanghvi.algorithms.sorting;

public class ThreeWayQuickSort<Item extends Comparable<? super Item>> {
    public static void main(String[] args) {
        ThreeWayQuickSort<Integer> threeWayQuickSort = new ThreeWayQuickSort<>();
        Integer[] list = new Integer[]{0, 4, 2, 6, 1, 5, 3, 7, 0, 4, 2, 6, 1, 5, 3, 7};

        System.out.print("Before: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        threeWayQuickSort.sort(list);

        System.out.print("After: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private void sort(Item[] list) {
        sort(list, 0, list.length - 1);
    }

    private void sort(Item[] list, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int left = startIndex, current = startIndex + 1, right = endIndex;
        Item pivot = list[startIndex];

        // Invariance within 'while' loop:
        // All values from startIndex..left-1  are less than pivot.
        // All values from left..current-1 are equal to pivot.
        // All values from right+1..endIndex are greater than pivot.

        while (current <= right) {
            int compare = list[current].compareTo(pivot);

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

    private void swap(Item[] list, int index1, int index2) {
        Item t = list[index1];
        list[index1] = list[index2];
        list[index2] = t;
    }
}
