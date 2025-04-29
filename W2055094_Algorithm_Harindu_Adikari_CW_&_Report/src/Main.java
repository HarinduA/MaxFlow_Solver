/**
 * Name: Harindu Hansaka Adikari
 * UOW Number: 20550947
 * IIT Number: 20220808
 */



import java.io.*;
import java.util.*;

/**
 * Main program to load a flow network from a file and compute its maximum flow.
 */
public class Main {
    public static void main(String[] args) {
        String filename = "src/bridge_1.txt";
        FlowNetwork network = null;
        int n = 0;

        try {
            Scanner sc = new Scanner(new File(filename));
            n = sc.nextInt();
            network = new FlowNetwork(n);

            while (sc.hasNext()) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int capacity = sc.nextInt();
                network.addEdge(from, to, capacity);
            }

            sc.close();
            System.out.println("Network loaded from file!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return;
        }

        MaxFlowSolver.maxFlow(network, 0, n - 1);  // just call it, don't print again
    }
}
