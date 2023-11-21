package com.Tree;

public class BinaryTree {
    Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Method to search for a value in the binary tree
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // Recursive helper method for search
    private boolean searchRecursive(Node root, int value) {
        // Base case: the tree is empty or the value is found
        if (root == null || root.data == value) {
            return root != null; // Return true if the value is found
        }

        // If the value is less than the current node's value, search in the left subtree
        if (value < root.data) {
            return searchRecursive(root.left, value);
        }

        // If the value is greater than the current node's value, search in the right subtree
        return searchRecursive(root.right, value);
    }


}
