package com.data.structures.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rinkesh on 2/8/2015.
 */
public class Vertex<T> {
    private T value;
    private List<Vertex<T>> inLinks = new ArrayList<Vertex<T>>();
    private List<Vertex<T>> outLinks = new ArrayList<Vertex<T>>();

    public Vertex () {

    }

    public Vertex (final T value) {
      this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<Vertex<T>> getInLinks() {
        return inLinks;
    }

    public void setInLinks(List<Vertex<T>> inLinks) {
        this.inLinks = inLinks;
    }

    public List<Vertex<T>> getOutLinks() {
        return outLinks;
    }

    public void setOutLinks(List<Vertex<T>> outLinks) {
        this.outLinks = outLinks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (inLinks != null ? !inLinks.equals(vertex.inLinks) : vertex.inLinks != null) return false;
        if (outLinks != null ? !outLinks.equals(vertex.outLinks) : vertex.outLinks != null) return false;
        if (!value.equals(vertex.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (inLinks != null ? inLinks.hashCode() : 0);
        result = 31 * result + (outLinks != null ? outLinks.hashCode() : 0);
        return result;
    }
}
