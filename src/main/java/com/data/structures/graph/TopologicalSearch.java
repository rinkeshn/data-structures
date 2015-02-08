package com.data.structures.graph;

/**
 * Perform topological search on the Directed Acyclic Graph.
 */
public class TopologicalSearch {

    public static <T> void performSearch(DirectedAcyclicGraph<T> directedAcyclicGraph) {
        while (!directedAcyclicGraph.isEmpty()) {
            Vertex<T> vertex = getNextNode(directedAcyclicGraph);
            System.out.print(vertex.getValue().toString());
            directedAcyclicGraph.deleteNode(vertex.getValue());
        }
    }

    private static <T> Vertex<T> getNextNode(DirectedAcyclicGraph<T> directedAcyclicGraph) {
       if (!directedAcyclicGraph.isEmpty()) {
           for (Vertex<T> vertex : directedAcyclicGraph.getAllVertices()) {
               if (vertex.getInLinks().isEmpty()) {
                   return vertex;
               }
           }
          throw new RuntimeException("Cycle in the DAG found.");
       } else {
           return null;
       }
    }
}
