package com.jsanghvi.algorithms.sorting;

public class MergeSort<Item extends Comparable<Item>> extends AbstractSort<Item> {
    public static void main(String[] args) {

        final MergeSort<Integer> mergeSortInteger = new MergeSort<>();
        mergeSortInteger.test(new Integer[]{});
        mergeSortInteger.test(new Integer[]{0});
        mergeSortInteger.test(new Integer[]{0, 1, 2, 3});
        mergeSortInteger.test(new Integer[]{3, 2, 1, 0});

        final MergeSort<String> mergeSortString = new MergeSort<>();
        mergeSortString.test(new String[]{"to", "be", "or", "not", "to", "be"});
    }

    @Override
    protected void sort(final Item[] list) {
        @SuppressWarnings("unchecked")
        final Item[] auxList = (Item[]) new Comparable[list.length];
        sort(list, auxList, 0, list.length - 1);
    }

    private void sort(final Item[] list, final Item[] auxList, final int startIndex, final int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        final int midIndex = (startIndex + endIndex) / 2;
        sort(list, auxList, startIndex, midIndex);
        sort(list, auxList, midIndex + 1, endIndex);
        merge(list, auxList, startIndex, midIndex, endIndex);
    }

    private void merge(final Item[] list, final Item[] auxList, final int startIndex, final int midIndex,
                       final int endIndex) {
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
