package com.data.structures.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Trie Node which stores the character value at the node.
 */
public class TrieNode {

    private char value;

    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode() {

    }

    public TrieNode (final char value) {
        this.value = value;
    }
    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrieNode trieNode = (TrieNode) o;

        if (value != trieNode.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }
}
