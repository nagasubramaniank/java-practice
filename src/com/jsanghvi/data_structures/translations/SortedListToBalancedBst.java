// Create a balanced binary search tree from a sorted singly linked list.

package com.jsanghvi.data_structures.translations;

public class SortedListToBalancedBst {
    public static void main(String[] args) {

        ListNode listHead = null;
        for (int value = 15; value >= 0; value--) {
            listHead = new ListNode(value, listHead);
        }

        BstNode treeRoot = createBst(listHead);

        System.out.print("Inorder sequence: ");
        printInorder(treeRoot);
        System.out.println();

        System.out.println("Binary Search Tree is balanced? : " + isBalancedBst(treeRoot));
    }

    private static BstNode createBst(final ListNode listHead) {
        int listLength = getListLength(listHead);
        return createBst(listHead, listLength).treeRoot;
    }

    private static SubtreeInformation createBst(ListNode listHead, final int length) {
        if (length <= 0) {
            return new SubtreeInformation(null, listHead);
        }

        SubtreeInformation leftInformation = createBst(listHead, length / 2);
        BstNode treeRoot = new BstNode(leftInformation.listNext.value);
        SubtreeInformation rightInformation = createBst(leftInformation.listNext.next, length - length / 2 - 1);

        treeRoot.left = leftInformation.treeRoot;
        treeRoot.right = rightInformation.treeRoot;
        return new SubtreeInformation(treeRoot, rightInformation.listNext);

    }

    private static int getListLength(final ListNode listHead) {
        int length = 0;
        for (ListNode head = listHead; head != null; head = head.next) {
            length += 1;
        }

        return length;
    }

    private static void printInorder(final BstNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.value + " ");
            printInorder(node.right);
        }
    }

    private static boolean isBalancedBst(final BstNode node) {
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

    private static class SubtreeInformation {
        private final BstNode treeRoot;
        private final ListNode listNext;

        public SubtreeInformation(final BstNode treeRoot, final ListNode listNext) {
            this.treeRoot = treeRoot;
            this.listNext = listNext;
        }
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

    private static class ListNode {
        private final int value;
        private final ListNode next;

        public ListNode(final int value, final ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    private static class BstNode {
        private final int value;
        private BstNode left, right;

        public BstNode(final int value) {
            this.value = value;
        }
    }
}
