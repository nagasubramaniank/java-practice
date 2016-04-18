package com.jsanghvi.data_structures.binary_search_tree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private Node root;

    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.put(0, 0);
        binarySearchTree.put(8, 1);
        binarySearchTree.put(4, 2);
        binarySearchTree.put(12, 3);
        binarySearchTree.put(2, 4);
        binarySearchTree.put(10, 5);
        binarySearchTree.put(6, 6);
        binarySearchTree.put(14, 7);

        System.out.print("Keys in tree (in sorted order): [ ");
        for (int key : binarySearchTree) {
            System.out.print(key + " ");
        }
        System.out.println("], Size of tree: " + binarySearchTree.size());

        System.out.println("Node value for node with key = -1: " + binarySearchTree.get(-1));
        System.out.println("Node value for node with key = 0: " + binarySearchTree.get(0));
        System.out.println("Node value for node with key = 1: " + binarySearchTree.get(1));

        System.out.println("Floor with key: " + (-1) + " = " + binarySearchTree.floor(-1));
        System.out.println("Floor with key: " + (0) + " = " + binarySearchTree.floor(0));
        System.out.println("Floor with key: " + (1) + " = " + binarySearchTree.floor(1));
        System.out.println("Floor with key: " + (13) + " = " + binarySearchTree.floor(13));
        System.out.println("Floor with key: " + (14) + " = " + binarySearchTree.floor(14));
        System.out.println("Floor with key: " + (15) + " = " + binarySearchTree.floor(15));

        System.out.println("Ceil with key: " + (-1) + " = " + binarySearchTree.ceil(-1));
        System.out.println("Ceil with key: " + (0) + " = " + binarySearchTree.ceil(0));
        System.out.println("Ceil with key: " + (1) + " = " + binarySearchTree.ceil(1));
        System.out.println("Ceil with key: " + (13) + " = " + binarySearchTree.ceil(13));
        System.out.println("Ceil with key: " + (14) + " = " + binarySearchTree.ceil(14));
        System.out.println("Ceil with key: " + (15) + " = " + binarySearchTree.ceil(15));

        System.out.println("Nodes with key < 0: " + binarySearchTree.rank(0));
        System.out.println("Nodes with key < 8: " + binarySearchTree.rank(8));
        System.out.println("Nodes with key < 16: " + binarySearchTree.rank(16));

        binarySearchTree.deleteMin();
        binarySearchTree.deleteMin();

        System.out.print("Keys in tree (after two deleteMins): [ ");
        for (int key : binarySearchTree) {
            System.out.print(key + " ");
        }
        System.out.println("], Size of tree: " + binarySearchTree.size());

        binarySearchTree.delete(8);
        binarySearchTree.delete(9);
        binarySearchTree.delete(10);

        System.out.print("Keys in tree (after deleting nodes with keys 8, 9, 10): [ ");
        for (int key : binarySearchTree) {
            System.out.print(key + " ");
        }
        System.out.println("], Size of tree: " + binarySearchTree.size());
    }

    public void put(final Key key, final Value value) {
        root = put(root, key, value);
    }

    private Node put(final Node node, final Key key, final Value value) {
        if (node == null) {
            return new Node(key, value);
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Value get(final Key key) {
        return get(root, key);
    }

    private Value get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return get(node.left, key);
        } else if (compare > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(final Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, final Key key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = delete(node.left, key);
        } else if (compare > 0) {
            node.right = delete(node.right, key);
        } else {
            // Found the element, adjust the subtree to make up for deleted node.
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // Both left and right subtrees exist. Replace current node with its successor.
                Node saveNode = node;
                node = min(node.right);
                node.right = deleteMin(saveNode.right);
                node.left = saveNode.left;
            }
        }

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    // Returns node with minimum key in given subtree.
    private Node min(final Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    // Returns key of largest node in tree with key <= input key.
    public Key floor(final Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node floor(final Node node, final Key key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare == 0) {
            return node;
        } else if (compare < 0) {
            return floor(node.left, key);
        } else {
            Node rightNode = floor(node.right, key);
            if (rightNode != null) {
                return rightNode;
            } else {
                return node;
            }
        }
    }

    // Returns key of smallest node in tree with key >= input key.
    public Key ceil(final Key key) {
        Node node = ceil(root, key);
        if (node == null) {
            return null;
        } else {
            return node.key;
        }
    }

    private Node ceil(final Node node, final Key key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare == 0) {
            return node;
        } else if (compare > 0) {
            return ceil(node.right, key);
        } else {
            Node leftNode = ceil(node.left, key);
            if (leftNode != null) {
                return leftNode;
            } else {
                return node;
            }
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.count;
        }
    }

    // Returns count of nodes in the tree with key < input key.
    public int rank(final Key key) {
        return rank(root, key);
    }

    private int rank(final Node node, final Key key) {
        if (node == null) {
            return 0;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return rank(node.left, key);
        } else if (compare > 0) {
            return 1 + size(node.left) + rank(node.right, key);
        } else {
            return size(node.left);
        }
    }

    @Override
    public Iterator<Key> iterator() {
        Queue<Key> queue = new ArrayDeque<>();
        inorderFillQueue(root, queue);
        return queue.iterator();
    }

    private void inorderFillQueue(final Node node, final Queue<Key> queue) {
        if (node == null) {
            return;
        }

        inorderFillQueue(node.left, queue);
        queue.add(node.key);
        inorderFillQueue(node.right, queue);
    }

    private class Node {
        final private Key key;
        private Value value;
        private Node left, right;
        private int count;

        public Node(final Key key, final Value value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }
}
