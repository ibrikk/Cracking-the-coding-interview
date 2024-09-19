import java.util.*;

public class DetectACycle {
  public static void main(String[] args) {
    Mygraph graph = new Mygraph();
    graph.addEdges(1, 2);
    graph.addEdges(1, 3);
    graph.addEdges(2, 4);
    graph.addEdges(2, 5);
    graph.addEdges(5, 3);

    boolean hasCycle = graph.hasCycle();

    System.out.println("Does the graph have a cycle? " + hasCycle);
  }

}

class Mygraph {
  Map<Integer, List<Integer>> adjList;

  public Mygraph() {
    adjList = new HashMap<>();
  }

  public void addEdges(int source, int destination) {
    if (adjList.get(source) == null) {
      adjList.put(source, new ArrayList<>());
    }
    adjList.get(source).add(destination);
  }

  public boolean hasCycle() {
    Set<Integer> visited = new HashSet<>();

    for (int node : adjList.keySet()) {
      if (!visited.contains(node)) {
        if (dfs(node, visited, -1)) {
          return true; // Cycle found
        }
      }
    }
    return false; // No cycle
  }

  public boolean dfs(int curr, Set<Integer> visited, int parent) {
    visited.add(curr);

    List<Integer> neighbors = adjList.get(curr) != null ? adjList.get(curr) : new ArrayList<>();

    for (int neighbor : neighbors) {
      if (!visited.contains(neighbor)) {
        if (dfs(neighbor, visited, curr)) {
          return true; // Cycle found in recursion
        }
      } else if (neighbor != parent) {
        return true; // If the neighbor is visited and not the parent, cycle exists
      }
    }
    return false; // No cycle found in this path
  }
}
