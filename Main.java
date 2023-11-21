package com.Tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Construct the binary tree
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        // Search for the value 63
        boolean found = tree.search(63);

        // Output the result
        if (found) {
            System.out.println("Value 63 found in the binary tree.");
        } else {
            System.out.println("Value 63 not found in the binary tree.");
        }
    }
}
