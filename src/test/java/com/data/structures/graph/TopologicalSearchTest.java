package com.data.structures.graph;

import org.junit.Test;

/**
 * Topological Search
 */
public class TopologicalSearchTest {

    @Test
    public void canDoTopologicalSearch() {
        DirectedAcyclicGraph<Character> directedAcyclicGraph = new DirectedAcyclicGraph<Character>();
        directedAcyclicGraph.addEdge(new Edge<Character>('A', 'B'));
        directedAcyclicGraph.addEdge(new Edge<Character>('B', 'C'));
        directedAcyclicGraph.addEdge(new Edge<Character>('C', 'D'));
        directedAcyclicGraph.addEdge(new Edge<Character>('E', 'B'));
        directedAcyclicGraph.addEdge(new Edge<Character>('R', 'D'));

        TopologicalSearch.performSearch(directedAcyclicGraph);
    }
}
