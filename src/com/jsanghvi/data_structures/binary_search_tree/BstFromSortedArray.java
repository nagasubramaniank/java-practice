// Create a balanced binary search tree from a sorted array.

package com.jsanghvi.data_structures.binary_search_tree;

public class BstFromSortedArray {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BstNode rootNode = createBst(array);

        System.out.print("Inorder sequence: ");
        printInorder(rootNode);
        System.out.println();

        System.out.println("Binary Search Tree is balanced? : " + isBalancedBst(rootNode));
    }

    private static BstNode createBst(final int[] array) {
        return createBst(array, 0, array.length - 1);
    }

    private static BstNode createBst(final int[] array, final int left, final int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        return new BstNode(array[mid], createBst(array, left, mid - 1), createBst(array, mid + 1, right));
    }

    public static void printInorder(final BstNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.value + " ");
            printInorder(node.right);
        }
    }

    public static boolean isBalancedBst(final BstNode node) {
        return getBalanceInformation(node).isBalanced;
    }

    private static BalanceInformation getBalanceInformation(final BstNode node) {
        if (node == null) {
            return new BalanceInformation(true);
        }

        BalanceInformation leftInformation = getBalanceInformation(node.left);
        BalanceInformation rightInformation = getBalanceInformation(node.right);

        if (!leftInformation.isBalanced || !rightInformation.isBalanced
                || leftInformation.maxHeight - rightInformation.minHeight > 1
                || rightInformation.maxHeight - leftInformation.minHeight > 1) {
            return new BalanceInformation(false);
        }

        return new BalanceInformation(true, Math.min(leftInformation.minHeight, rightInformation.minHeight),
                Math.max(leftInformation.maxHeight, rightInformation.maxHeight));
    }

    private static class BalanceInformation {
        final boolean isBalanced;
        final int maxHeight;
        final int minHeight;

        public BalanceInformation(final boolean isBalanced, final int minHeight, final int maxHeight) {
            this.isBalanced = isBalanced;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
        }

        public BalanceInformation(final boolean isBalanced) {
            this(isBalanced, 0, 0);
        }
    }

    private static class BstNode {
        final int value;
        final BstNode left, right;

        public BstNode(final int value, final BstNode left, final BstNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
