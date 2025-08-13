package dev.lpa;

public class Trie {
    private TrieNode root; // represents an empty String

    public Trie() {
        root = new TrieNode();
        System.out.println("Trie has been created");
    }

    public void insert(String word){
        // Case 1: Trie is blank
        // Case 2: New String's prefix is common to another String's prefix
        TrieNode current = root;
        // Convert the word into a character array
        // and loop through each character to make new nodes/ links
        for(char c : word.toCharArray()){
            // check if this character exists in the trie, could be null
            // create a new node
            // put that node into the current node's children map
            // set the current node to the character node found or created
            /*
            * computeIfAbsent() creates a new node and associates with the current character
            * if it is not already in the map
            * */
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }

        /*
        * By the end of the loop, we have completed the word
        * so, set the endOfString flag to true
        * */
        current.endOfString = true;
        System.out.println("Successfully inserted " + word + " in Trie");
    }

    public boolean search(String word){
        // Need to traverse the Trie to see if the word is in it
        TrieNode current = root;
        // Loop through each character in the word
        for(char c : word.toCharArray()){
            // Check if current node's children map contains the
            // current character
            current = current.children.get(c);
            if(current == null){
                System.out.println(word + " was not found in the Trie");
                return false;
            }
        }
        // By the end of the loop we have reached the endOfString and we found the word
        System.out.println(word + " was found in the Trie!");
        return true;
    }

    public boolean startsWith(String prefix){
        // Need to find the prefixes of a word
        TrieNode current = root;
        // Loop through each character in the prefix
        for(char c : prefix.toCharArray()){
            // Similar to search method, check if the current node's children map
            // contains the current character
            current = current.children.get(c);
            if(current == null) {
                System.out.println("Prefix, " + prefix + ", was not found in the Trie");
                return false;
            }
        }
        // by the end of the loop we do not care about end of string
        System.out.println("Prefix, " + prefix + ", was found in the Trie");
        return true;
    }
}
