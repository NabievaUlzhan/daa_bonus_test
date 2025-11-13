package service;
import model.Edge;
import model.Graph;
import java.util.*;

public class MSTService {
    public List<Edge> buildMST(Graph g) {
        int V = g.getVertices();
        boolean[] inMST = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Edge> mstEdges = new ArrayList<>();

        inMST[0] = true;
        pq.addAll(g.getAdjList().get(0));

        while (!pq.isEmpty() && mstEdges.size() < V - 1) {
            Edge edge = pq.poll();
            if (inMST[edge.getDest()])
                continue;

            mstEdges.add(edge);
            inMST[edge.getDest()] = true;
            for (Edge next : g.getAdjList().get(edge.getDest())) {
                if (!inMST[next.getDest()])
                    pq.add(next);
            }
        }
        return mstEdges;
    }

    public void findReplacementEdge(Graph g, List<Edge> mstEdges, int removeIndex) {
        System.out.println("3) Removing edge: " + mstEdges.get(removeIndex));
        Edge removed = mstEdges.remove(removeIndex);

        Set<Integer> visited = new HashSet<>();
        dfs(removed.getSrc(), visited, mstEdges);

        Set<Integer> comp1 = visited;
        Set<Integer> comp2 = new HashSet<>();
        for (int i = 0; i < g.getVertices(); i++) {
            if (!visited.contains(i))
                comp2.add(i);
        }

        System.out.println("Component 1: " + comp1);
        System.out.println("Component 2: " + comp2);

        Edge replacement = null;
        int minWeight = Integer.MAX_VALUE;

        for (int u : comp1) {
            for (Edge e : g.getAdjList().get(u)) {
                if (comp2.contains(e.getDest()) && e.getWeight() < minWeight) {
                    minWeight = e.getWeight();
                    replacement = e;
                }
            }
        }

        if (replacement != null) {
            System.out.println("4) Replacement edge found: " + replacement);
            mstEdges.add(replacement);
        } else {
            System.out.println("4) No replacement edge found (graph disconnected).");
        }
    }

    private void dfs(int node, Set<Integer> visited, List<Edge> mstEdges) {
        visited.add(node);
        for (Edge e : mstEdges) {
            if (e.getSrc() == node && !visited.contains(e.getDest()))
                dfs(e.getDest(), visited, mstEdges);
            if (e.getDest() == node && !visited.contains(e.getSrc()))
                dfs(e.getSrc(), visited, mstEdges);
        }
    }
}
