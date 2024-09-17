import java.util.*;

public class SimpleTraversal {
  public static void main(String[] args) {
    MyGraph graph = new MyGraph();

    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);
    graph.addEdge(2, 5);
    graph.addEdge(5, 3);

    graph.bfs(1);
  }

}

class MyGraph {
  private HashMap<Integer, List<Integer>> adjList;

  public MyGraph() {
    adjList = new HashMap<>();
  }

  public void addEdge(int source, int destination) {
    if (adjList.get(source) == null) {
      adjList.put(source, new ArrayList<>());
    }
    adjList.get(source).add(destination);
  }

  public void bfs(int source) {
    HashSet<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    visited.add(source);
    queue.offer(source);

    while (!queue.isEmpty()) {
      int currNode = queue.poll();
      System.out.println(currNode);
      List<Integer> neighbors = adjList.get(currNode) != null ? adjList.get(currNode) : new ArrayList<>();

      for (int node : neighbors) {
        if (!visited.contains(node)) {
          visited.add(node);
          queue.offer(node);
        }
      }
    }
  }

  public void dfs(int source) {
    Set<Integer> visited = new HashSet<>();
    dfsRecursive(source, visited);
  }

  private void dfsRecursive(int currNode, Set<Integer> visited) {
    visited.add(currNode);
    System.out.println(currNode);

    List<Integer> neighbors = adjList.get(currNode) != null ? adjList.get(currNode) : new ArrayList<>();
    for (int neighbor : neighbors) {
      if (!visited.contains(neighbor)) {
        dfsRecursive(neighbor, visited);
      }
    }
  }

}
