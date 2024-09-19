import java.util.*;

public class FindConnectedComponents {
  public static void main(String[] args) {
    AGraph graph = new AGraph();
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(4, 5);
    graph.addEdge(4, 6);
    graph.addEdge(7, 8);

    graph.bfs();
    graph.dfs();
  }
}

class AGraph {
  Map<Integer, List<Integer>> adjList;

  public AGraph() {
    adjList = new HashMap<>();
  }

  public void addEdge(int source, int destination) {
    if (adjList.get(source) == null) {
      adjList.put(source, new ArrayList<>());
    }
    if (adjList.get(destination) == null) {
      adjList.put(destination, new ArrayList<>());
    }
    adjList.get(source).add(destination);
    adjList.get(destination).add(source);
  }

  public void bfs() {
    List<List<Integer>> components = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    for (int node : adjList.keySet()) {
      if (!visited.contains(node)) {
        List<Integer> component = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(node);
        queue.offer(node);

        while (!queue.isEmpty()) {
          int curr = queue.poll();
          component.add(curr);

          List<Integer> neighbors = adjList.get(node) == null ? new ArrayList<>() : adjList.get(node);
          for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
              visited.add(neighbor);
              queue.offer(neighbor);
            }
          }
        }

        components.add(component);
      }
    }

    // Print the connected components
    int componentNumber = 1;
    for (List<Integer> component : components) {
      System.out.println("Component " + componentNumber++ + ": " + component);
    }
  }

  public void dfs() {
    List<List<Integer>> components = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    for (int curr : adjList.keySet()) {
      if (!visited.contains(curr)) {
        List<Integer> component = new ArrayList<>();
        dfs(curr, visited, component);
        components.add(component);
      }
    }

    // Print the connected components
    int componentNumber = 1;
    for (List<Integer> component : components) {
      System.out.println("Component " + componentNumber++ + ": " + component);
    }
  }

  private void dfs(int node, Set<Integer> visited, List<Integer> component) {
    visited.add(node);
    component.add(node);
    List<Integer> neighbors = adjList.get(node) == null ? new ArrayList<>() : adjList.get(node);
    for (int neighbor : neighbors) {
      if (!visited.contains(neighbor)) {
        dfs(neighbor, visited, component);
      }
    }
  }
}
