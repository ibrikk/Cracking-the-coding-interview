import java.util.*;

public class NewGraphTraversal {
  public static void main(String[] args) {
    NewGraph graph = new NewGraph();
    graph.addEdge('A', 'B');
    graph.addEdge('A', 'C');
    graph.addEdge('C', 'D');

    graph.bfs('A');
    graph.dfs('A');
  }
}

class NewGraph {
  Map<Character, List<Character>> adjList;

  public NewGraph() {
    adjList = new HashMap<>();
  }

  public void addEdge(char source, char destination) {
    if (adjList.get(source) == null) {
      adjList.put(source, new ArrayList<>());
    }
    adjList.get(source).add(destination);
  }

  public void bfs(char source) {
    Set<Character> visited = new HashSet<>();
    Queue<Character> queue = new LinkedList<>();

    visited.add(source);
    queue.offer(source);

    while (!queue.isEmpty()) {
      char curr = queue.poll();
      System.out.print(curr);

      List<Character> neighbors = adjList.get(curr) != null ? adjList.get(curr) : new ArrayList<>();

      for (char neighbor : neighbors) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.offer(neighbor);
        }
      }
    }
    System.out.println();
  }

  public void dfs(char source) {
    Set<Character> visited = new HashSet<>();
    dfsRecursive(source, visited);
    System.out.println();
  }

  private void dfsRecursive(char source, Set<Character> visited) {
    visited.add(source);
    System.out.print(source);

    List<Character> neighbors = adjList.get(source) != null ? adjList.get(source) : new ArrayList<>();
    for (char neighbor : neighbors) {
      if (!visited.contains(neighbor)) {
        dfsRecursive(neighbor, visited);
      }
    }
  }
}
