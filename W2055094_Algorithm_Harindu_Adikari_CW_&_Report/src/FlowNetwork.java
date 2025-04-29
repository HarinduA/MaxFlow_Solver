/**
 * Name: Harindu Hansaka Adikari
 * UOW Number: 20550947
 * IIT Number: 20220808
 */



import java.util.*;

/**
 * Represents a flow network using an adjacency list of edges.
 */
public class FlowNetwork {
    private List<Edge>[] adjList;

    /**
     * Constructs a flow network with a specified number of nodes.
     *
     * @param n the number of nodes
     */
    @SuppressWarnings("unchecked")
    public FlowNetwork(int n) {
        adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    /**
     * Adds an edge to the network, along with its residual edge.
     *
     * @param from     the source node
     * @param to       the destination node
     * @param capacity the capacity of the edge
     */
    public void addEdge(int from, int to, int capacity) {
        Edge e1 = new Edge(from, to, capacity);
        Edge e2 = new Edge(to, from, 0);
        e1.residual = e2;
        e2.residual = e1;
        adjList[from].add(e1);
        adjList[to].add(e2);
    }

    /**
     * Returns the adjacency list of the network.
     *
     * @return the adjacency list
     */
    public List<Edge>[] getAdjList() {
        return adjList;
    }

    /**
     * Returns the list of edges connected to a given node.
     *
     * @param node the node index
     * @return the list of edges
     */
    public List<Edge> getEdges(int node) {
        return adjList[node];
    }
}
