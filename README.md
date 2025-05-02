# Max Flow Solver — Edmonds-Karp Algorithm (Java)

This Java project implements the **Edmonds-Karp algorithm**, a breadth-first search (BFS)-based approach to compute the **maximum flow** in a directed flow network. The program reads a graph from a file, runs the algorithm, and prints each step of the flow augmentation process, the total maximum flow achieved, and the time taken to compute it. **Ford - Fulkerson Methodlogy** used for this project to find the max flow.

---

## 📄 Input Format (`bridge_1.txt`)

The input file must be structured as follows:

N from1 to1 capacity1 from2 to2 capacity2 ...

markdown
Copy
Edit

- `N` — total number of nodes in the graph (indexed from `0` to `N-1`)
- Each following line describes an edge from node `from` to node `to` with a given `capacity`

### Example:
6 0 1 3 0 4 2 1 2 4 1 3 3 2 4 1 2 3 1 3 4 2 4 5 4

yaml
Copy
Edit

---

## ▶️ How to Compile and Run

1. Open a terminal in your project folder.

2. **Compile** the Java source files:
   ```bash
   javac *.java
Run the program:

bash
Copy
Edit
java Main
🧠 Algorithm Overview
The program uses the Edmonds-Karp algorithm, which is a BFS-based variant of the Ford-Fulkerson method.

At each iteration, it finds the shortest augmenting path (in terms of number of edges) from source to sink and sends as much flow as possible through it.

The algorithm stops when no more augmenting paths exist.

🖥️ Sample Output
markdown
Copy
Edit
Network loaded from file!
=== FLOW EXECUTION REPORT ===

Step #1
Augmenting Route: 0 -> 1 -> 5
Flow sent along this route: 1
Updated total flow: 1
----------------------------

...

=== FINAL RESULTS ===
Total maximum flow achieved: 5
Time taken to compute max flow: 6 milliseconds
=======================
✅ The final maximum flow is shown once, with clear step-by-step tracing of how the flow builds up.

🛠 Features
Edmonds-Karp algorithm for max flow

Full residual graph support

Detailed console output for each augmenting path

Execution time reporting

Clean and modular Java code (educational & extendable)
