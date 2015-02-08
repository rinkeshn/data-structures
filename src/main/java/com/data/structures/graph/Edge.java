package com.data.structures.graph;

/**
 * Edge connecting two vertices in the graph.
 */
public class Edge<T> {
    private T start;
    private T end;
    private double weight;

    public Edge(final T start, final T end) {
        this.start = start;
        this.end = end;
    }
    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
