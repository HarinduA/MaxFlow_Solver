/**
 * Name: Harindu Hansaka Adikari
 * UOW Number: 20550947
 * IIT Number: 20220808
 */




import java.util.*;

/**
 * Provides a method to compute the maximum flow in a flow network
 * using the Edmonds-Karp (BFS-based Ford-Fulkerson) algorithm.
 */
public class MaxFlowSolver {

    /**
     * Computes the maximum flow from source to sink in the given flow network.
     *
     * @param network the flow network
     * @param source  the source node
     * @param sink    the sink node
     * @return the maximum flow value
     */
    public static int maxFlow(FlowNetwork network, int source, int sink) {
        long startTime = System.currentTimeMillis(); // Start time

        int totalFlow = 0;
        int n = network.getAdjList().length;
        int stepCounter = 1;

        System.out.println("=== FLOW EXECUTION REPORT ===\n");

        while (true) {
            Edge[] parent = new Edge[n];
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(source);
            visited[source] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (Edge edge : network.getEdges(current)) {
                    if (!visited[edge.to] && edge.remainingCapacity() > 0) {
                        visited[edge.to] = true;
                        parent[edge.to] = edge;
                        queue.add(edge.to);
                    }
                }
            }

            if (!visited[sink]) break;

            int pushFlow = Integer.MAX_VALUE;
            for (Edge edge = parent[sink]; edge != null; edge = parent[edge.from]) {
                pushFlow = Math.min(pushFlow, edge.remainingCapacity());
            }

            for (Edge edge = parent[sink]; edge != null; edge = parent[edge.from]) {
                edge.addFlow(pushFlow);
            }

            totalFlow += pushFlow;

            System.out.println("Step #" + stepCounter);
            System.out.print("Augmenting Route: ");
            displayRoute(parent, source, sink);
            System.out.println("Flow sent along this route: " + pushFlow);
            System.out.println("Updated total flow: " + totalFlow);
            System.out.println("----------------------------\n");

            stepCounter++;
        }

        long endTime = System.currentTimeMillis(); // End time

        System.out.println("=== FINAL RESULTS ===");
        System.out.println("Total maximum flow achieved: " + totalFlow);
        System.out.println("Time taken to compute max flow: " + (endTime - startTime) + " milliseconds");
        System.out.println("=======================");

        return totalFlow;
    }

    /**
     * Displays the augmenting path from source to sink.
     *
     * @param parent the array containing the parent edges
     * @param source the source node
     * @param sink   the sink node
     */
    private static void displayRoute(Edge[] parent, int source, int sink) {
        List<Integer> path = new ArrayList<>();
        for (Edge edge = parent[sink]; edge != null; edge = parent[edge.from]) {
            path.add(edge.to);
        }
        path.add(source);
        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
    }
}
