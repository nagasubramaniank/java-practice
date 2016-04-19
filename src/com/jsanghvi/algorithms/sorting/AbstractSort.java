package com.jsanghvi.algorithms.sorting;

public abstract class AbstractSort<Item extends Comparable<Item>> {
    protected void test(final Item[] items) {
        System.out.print("Before: ");
        for (Item item : items) {
            System.out.print(item + " ");
        }
        System.out.println();

        sort(items);

        System.out.print(" After: ");
        for (Item item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    protected void swap(final Item[] list, final int index1, final int index2) {
        final Item t = list[index1];
        list[index1] = list[index2];
        list[index2] = t;
    }

    protected abstract void sort(final Item[] items);
}
