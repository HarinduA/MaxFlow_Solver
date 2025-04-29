/**
 * Name: Harindu Hansaka Adikari
 * UOW Number: 20550947
 * IIT Number: 20220808
 */



/**
 * Represents an edge in a flow network, including capacity, current flow, and residual edge.
 */
public class Edge {
    int from, to;       // nodes
    int capacity;       // maximum possible flow
    int flow;           // current flow through the edge
    Edge residual;      // reverse edge (used for flow algorithms)

    /**
     * Constructs an edge with given source, destination, and capacity.
     *
     * @param from     the source node
     * @param to       the destination node
     * @param capacity the capacity of the edge
     */
    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    /**
     * Returns the remaining capacity of the edge.
     *
     * @return the remaining capacity
     */
    public int remainingCapacity() {
        return capacity - flow;
    }

    /**
     * Adds flow to this edge and subtracts it from the residual edge.
     *
     * @param flow the amount of flow to add
     */
    public void addFlow(int flow) {
        this.flow += flow;
        this.residual.flow -= flow;
    }
}
