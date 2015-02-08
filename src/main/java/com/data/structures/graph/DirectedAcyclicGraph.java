package com.data.structures.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Directed Acyclic Graph.
 */
public class DirectedAcyclicGraph<T> {

    Map<T, Vertex<T>> verticesMap = new HashMap<T, Vertex<T>>();

    public void addEdge(final Edge<T> edge) {
        if (!verticesMap.containsKey(edge.getStart())) {
            verticesMap.put(edge.getStart(), new Vertex<T>(edge.getStart()));
        }
        if (!verticesMap.containsKey(edge.getEnd())) {
            verticesMap.put(edge.getEnd(), new Vertex<T>(edge.getEnd()));
        }
        verticesMap.get(edge.getStart()).getOutLinks().add(verticesMap.get(edge.getEnd()));
        verticesMap.get(edge.getEnd()).getInLinks().add(verticesMap.get(edge.getStart()));
    }

    public void deleteEdge(final Edge<T> edge) {
        Vertex<T> startVertex = verticesMap.get(edge.getStart());
        Vertex<T> endVertex = verticesMap.get(edge.getEnd());

        startVertex.getOutLinks().remove(endVertex);
        endVertex.getInLinks().remove(startVertex);

        if (startVertex.getInLinks().isEmpty() && endVertex.getOutLinks().isEmpty()) {
            verticesMap.remove(startVertex.getValue());
        }
        if (endVertex.getInLinks().isEmpty() && endVertex.getOutLinks().isEmpty()) {
            verticesMap.remove(endVertex.getValue());
        }
    }

    public Vertex<T> getVertex(final T key) {
      return verticesMap.get(key);
    }

    public Collection<Vertex<T>> getAllVertices() {
        return verticesMap.values();
    }

    public void deleteNode(final T key) {
       Vertex<T> vertex = verticesMap.remove(key);
        for(Vertex<T> inLink : vertex.getInLinks()) {
            verticesMap.get(inLink.getValue()).getOutLinks().remove(vertex);
        }
        for(Vertex<T> outLink : vertex.getOutLinks()) {
            verticesMap.get(outLink.getValue()).getInLinks().remove(vertex);
        }
    }

    public void addVertex(final Vertex<T> vertex) {
        verticesMap.put(vertex.getValue(), vertex);
    }

    public boolean isEmpty() {
        return verticesMap.isEmpty();
    }
}
