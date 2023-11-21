package com.hash2;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Node>[] bucketArray;
    private int numBuckets;

    public HashTable(int numBuckets) {
        this.numBuckets = numBuckets;
        this.bucketArray = new LinkedList[numBuckets];


        // Initialize each bucket with an empty linked list
        for (int i = 0; i < numBuckets; i++) {
            bucketArray[i] = new LinkedList<>();
        }
    }

    // Hash function to determine the index of a key in the hash table
    private int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % numBuckets);
    }

    // Insert key-value pair into the hash table
    public void put(String key, String value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node> bucket = bucketArray[bucketIndex];

        // Check if the key already exists in the bucket
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                // Update the value if the key exists
                node.value = value;
                return;
            }
        }

        // Add a new key-value pair to the bucket
        bucket.add(new Node(key, value));
    }

    // Get the value associated with a key from the hash table
    public String get(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node> bucket = bucketArray[bucketIndex];

        // Search for the key in the bucket
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }

        }
        return null;
    }
}
