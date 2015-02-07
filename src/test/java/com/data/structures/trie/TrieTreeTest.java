package com.data.structures.trie;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for TrieTree data structure.
 */
public class TrieTreeTest {

    @Test
    public void canRetrieveElementsFromTrieTree() {
        TrieTree tree = new TrieTree();
        tree.add("Peter");
        tree.add("Matt");
        tree.add("Name");
        tree.add("Nature");

        Set<String> results =  tree.lookupValuesStartingWith("Na");
        assertEquals(2, results.size());
    }
}
