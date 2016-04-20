package com.jsanghvi.algorithms.sorting;

public class QuickSort<Item extends Comparable<Item>> extends AbstractSort<Item> {
    public static void main(final String[] args) {
        final QuickSort<Integer> quickSortInteger = new QuickSort<>();
        quickSortInteger.test(new Integer[]{});
        quickSortInteger.test(new Integer[]{0});
        quickSortInteger.test(new Integer[]{0, 1, 2, 3});
        quickSortInteger.test(new Integer[]{3, 2, 1, 0});

        final QuickSort<String> quickSortString = new QuickSort<>();
        quickSortString.test(new String[]{"to", "be", "or", "not", "to", "be"});
    }

    @Override
    protected void sort(final Item[] list) {
        sort(list, 0, list.length - 1);
    }

    private void sort(final Item[] list, final int startIndex, final int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        final int index = partition(list, startIndex, endIndex);
        sort(list, startIndex, index - 1);
        sort(list, index + 1, endIndex);
    }

    private int partition(final Item[] list, final int startIndex, final int endIndex) {
        int left = startIndex + 1, right = endIndex;
        final Item pivot = list[startIndex];

        // Invariance within 'while' loop:
        // All values from startIndex..left-1  are less than or equal to pivot.
        // All values from right+1..endIndex are greater than pivot.

        while (true) {
            while (list[left].compareTo(pivot) <= 0 && left < right) left++;
            while (list[right].compareTo(pivot) > 0) right--;

            if (left >= right)
                break;

            swap(list, left++, right--);
        }

        swap(list, startIndex, right);
        return right;
    }
}
