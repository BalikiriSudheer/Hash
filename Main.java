package com.hash2;

public class Main {
    public static void main(String[] args) {
        // Given phrase
        String phrase = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        // Word to be removed
        String wordToRemove = "avoidable";

        // Tokenize the phrase into words
        String[] words = phrase.split("\\s+");

        // Create a hash map to store the words without the specified word
        HashTable wordMap = new HashTable(words.length);

        // Iterate through the words and add them to the hash map (excluding the word to be removed)
        for (String word : words) {
            if (!word.equals(wordToRemove)) {
                wordMap.put(word, word);
            }
        }

        // Reconstruct the modified phrase
        StringBuilder modifiedPhrase = new StringBuilder();
        for (String word : words) {
            String replacement = wordMap.get(word);
            if (replacement != null) {
                modifiedPhrase.append(replacement).append(" ");
            }
        }

        // Remove the trailing space
        modifiedPhrase.setLength(modifiedPhrase.length() - 1);

        // Print the modified phrase
        System.out.println("Modified Phrase: " + modifiedPhrase.toString());
    }
}

