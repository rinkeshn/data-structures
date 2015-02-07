package com.data.structures.trie;

import java.util.HashSet;
import java.util.Set;

/**
 * Trie tree implementation for java strings.
 */
public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void add(final String value) {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Null or empty strings are not allowed.");
        }
        char[] characters = value.toCharArray();
        insert(characters, 0, root);
    }

    public boolean contains(final String key) {
        if (key == null || key.isEmpty()) {
            throw new RuntimeException("Null or empty strings are not allowed.");
        }
        char[] characters = key.toCharArray();
        return contains(characters, 0, root);
    }

    public Set<String> lookupValuesStartingWith(final String key) {
        char[] characters = key.toCharArray();
        TrieNode node = getNode(characters, 0, root);
        StringBuilder builder = new StringBuilder(key);
        Set<String> results = new HashSet<String>();
        traverseStrings(builder, results, node);
        return results;
    }

    private void traverseStrings(StringBuilder buffer, Set<String> results, final TrieNode node) {
        if (node.getChildren().isEmpty()) {
            results.add(buffer.toString());
        } else {
            for (Character character : node.getChildren().keySet()) {
                buffer.append(character);
                traverseStrings(buffer, results, node.getChildren().get(character));
                buffer.deleteCharAt(buffer.length()-1);
            }
        }
    }

    private TrieNode getNode(final char[] characters, final int index, final TrieNode node){
        if (index < characters.length) {
            if(!node.getChildren().containsKey(characters[index])) {
                return null;
            } else {
                return getNode(characters, index + 1, node.getChildren().get(characters[index]));
            }
        }
        return node;
    }
    private boolean contains(final char[] characters, final int index, final TrieNode node){
        if (index < characters.length) {
            if(!node.getChildren().containsKey(characters[index])) {
                return false;
            } else {
                return contains(characters, index + 1, node.getChildren().get(characters[index]));
            }
        } else {
            return true;
        }
    }

    private void insert(final char[] characters, final int index, final TrieNode node) {
        if (index < characters.length) {

            if (!node.getChildren().containsKey(characters[index])) {
                TrieNode nodeToBeInserted = new TrieNode(characters[index]);
                node.getChildren().put(characters[index], nodeToBeInserted);
            }

            TrieNode insertedNode = node.getChildren().get(characters[index]);
            insert(characters, index + 1, insertedNode);
        }
    }
}
