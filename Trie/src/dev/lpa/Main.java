package dev.lpa;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("dog");
        trie.insert("cat");
        trie.insert("catch");
        trie.insert("car");
        trie.insert("cards");
        trie.insert("carpet");

        trie.search("catch");
        trie.search("dogs");

        trie.startsWith("cat");
        trie.startsWith("car");
        trie.startsWith("ma");
    }
}
