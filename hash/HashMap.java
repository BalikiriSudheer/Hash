package com.hash;

import java.util.LinkedList;

public class HashMap {
    private LinkedList<Node>[] bucketArray;
    private int numBuckets;

    public HashMap(int numBuckets) {
        this.numBuckets = numBuckets;
        this.bucketArray = new LinkedList[numBuckets];

        // Initialize each bucket with an empty linked list
        for (int i = 0; i < numBuckets; i++) {
            bucketArray[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % numBuckets);
    }

    public void insert(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node> linkedList = bucketArray[bucketIndex];

        // Check if the word is already present
        for (Node node : linkedList) {
            if (node.key.equals(key)) {
                node.value++;
                return;
            }
        }

        // If not present, add a new node
        linkedList.add(new Node(key, 1));
    }

    public int getFrequency(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node> linkedList = bucketArray[bucketIndex];

        // Search for the word in the linked list
        for (Node node : linkedList) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        // If the word is not found, return 0
        return 0;
    }
}

