package model;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<List<Edge>> adjList;

    public Graph(int V) {
        this.V = V;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int w) {
        adjList.get(u).add(new Edge(u, v, w));
        adjList.get(v).add(new Edge(v, u, w));
    }

    public int getVertices() {
        return V;
    }
    public List<List<Edge>> getAdjList() {
        return adjList;
    }
}
