package com.jsanghvi.algorithms.sorting;

public class QuickSort<Item extends Comparable<? super Item>> {
    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] list = new Integer[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        System.out.print("Before: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        quickSort.sort(list);

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

        int index = partition(list, startIndex, endIndex);
        sort(list, startIndex, index - 1);
        sort(list, index + 1, endIndex);
    }

    private int partition(Item[] list, int startIndex, int endIndex) {
        int left = startIndex + 1, right = endIndex;
        Item pivot = list[startIndex];

        // Invariance within 'while' loop:
        // All values from startIndex..left-1  are less than or equal to pivot.
        // All values from right+1..endIndex are greater than pivot.

        while (left <= right) {
            if (list[left].compareTo(pivot) <= 0) left++;
            else if (list[right].compareTo(pivot) > 0) right--;
            else swap(list, left++, right--);
        }

        swap(list, startIndex, right);
        return right;
    }

    private void swap(Item[] list, int index1, int index2) {
        Item t = list[index1];
        list[index1] = list[index2];
        list[index2] = t;
    }
}
