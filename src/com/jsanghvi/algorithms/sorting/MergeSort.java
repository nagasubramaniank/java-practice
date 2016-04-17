package com.jsanghvi.algorithms.sorting;

public class MergeSort<Item extends Comparable<Item>> {
    public static void main(String[] args) {
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] list = new Integer[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        System.out.print("Before: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        mergeSort.sort(list);

        System.out.print("After: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private void sort(Item[] list) {
        @SuppressWarnings("unchecked")
        Item[] auxList = (Item[]) new Comparable[list.length];
        sort(list, auxList, 0, list.length - 1);
    }

    private void sort(Item[] list, Item[] auxList, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int midIndex = (startIndex + endIndex) / 2;
        sort(list, auxList, startIndex, midIndex);
        sort(list, auxList, midIndex + 1, endIndex);
        merge(list, auxList, startIndex, midIndex, endIndex);
    }

    private void merge(Item[] list, Item[] auxList, int startIndex, int midIndex, int endIndex) {
        System.arraycopy(list, startIndex, auxList, startIndex, endIndex - startIndex + 1);

        for (int i = startIndex, j = midIndex + 1, k = startIndex; k <= endIndex; k++) {
            if (i > midIndex) {
                list[k] = auxList[j++];
            } else if (j > endIndex) {
                list[k] = auxList[i++];
            } else if (auxList[i].compareTo(auxList[j]) <= 0) {
                list[k] = auxList[i++];
            } else {
                list[k] = auxList[j++];
            }
        }
    }
}
