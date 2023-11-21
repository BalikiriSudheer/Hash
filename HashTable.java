package com.hash1;

import java.util.LinkedList;

public class HashTable<K,V> {
    private LinkedList<Node<K, V>>[] bucketArray;
    private int numBuckets;

    // Constructor
    public HashTable(int numBuckets) {
        this.numBuckets = numBuckets;
        this.bucketArray = new LinkedList[numBuckets];

        // Initialize each bucket with an empty linked list
        for (int i = 0; i < numBuckets; i++) {
            this.bucketArray[i] = new LinkedList<>();
        }
    }

    // Method to get the index for a key using its hash code
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % numBuckets;
    }

    // Method to get the value for a key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = bucketArray[bucketIndex];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    // Method to add a key-value pair to the hash map
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = bucketArray[bucketIndex];

        // Check if the key is already present, if so, update the value
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // If key is not present, add a new node to the linked list
        Node<K, V> newNode = new Node<>(key, value);
        bucket.add(newNode);
    }

    // Method to display the frequency of words in the hash map
    public void displayFrequency() {
        for (int i = 0; i < numBuckets; i++) {
            LinkedList<Node<K, V>> bucket = bucketArray[i];

            if (!bucket.isEmpty()) {
                System.out.println("Bucket " + i + ":");
                for (Node<K, V> node : bucket) {
                    System.out.println(node.key + ": " + node.value);
                }
            }
        }
    }
}

