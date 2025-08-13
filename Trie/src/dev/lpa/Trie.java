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

    public void search(){}

    public void startsWith(String word){}
}
