package com.hash1;

public class Main {
    public static void main(String[] args) {
        String paragraph = "Paranoids are not paranoid because they are paranoid but "
                + "because they keep putting themselves deliberately into paranoid avoidable situations";

        // Split the paragraph into words
        String[] words = paragraph.split(" ");

        // Create a hash map with 10 buckets
        HashTable<String, Integer> wordFrequencyMap = new HashTable<>(10);

        // Populate the hash map with word frequencies
        for (String word : words) {
            // Convert the word to lowercase to make it case-insensitive
            word = word.toLowerCase();

            Integer frequency = wordFrequencyMap.get(word);
            if (frequency == null) {
                // If the word is not already in the map, set its frequency to 1
                wordFrequencyMap.put(word, 1);
            } else {
                // If the word is already in the map, increment its frequency
                wordFrequencyMap.put(word, frequency + 1);
            }
        }

        // Display the word frequencies
        wordFrequencyMap.displayFrequency();
    }
}
