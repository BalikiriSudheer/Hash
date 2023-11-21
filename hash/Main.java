package com.hash;

public class Main {
    public static void main(String[] args) {
        String sentence = "To be or not to be";
        String[] words = sentence.split("\\s+");

        // Choose an appropriate number of buckets for the hash table
        int numBuckets = 10;
        HashMap wordFrequencyMap = new HashMap(numBuckets);

        // Insert each word into the hash table
        for (String word : words) {
            wordFrequencyMap.insert(word);
        }

        // Print the frequency of each word
        for (String word : words) {
            System.out.println("Frequency of '" + word + "': " + wordFrequencyMap.getFrequency(word));
        }
    }
}
