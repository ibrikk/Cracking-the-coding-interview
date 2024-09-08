import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class Node {
  private String name;
  private List<Node> adjacent;
  public RouteBetweenNodes.State state;

  public Node(String name) {
    this.name = name;
    adjacent = new ArrayList<>();
  }

  public void addAdjacent(Node node) {
    adjacent.add(node);
  }

  public List<Node> getAdjacent() {
    return adjacent;
  }

  public String getName() {
    return name;
  }
}

class Graph {

  private List<Node> nodes;

  public Graph() {
    nodes = new ArrayList<>();
  }

  public void addNode(Node node) {
    nodes.add(node);
  }

  public List<Node> getNodes() {
    return nodes;
  }
}

public class RouteBetweenNodes {

  enum State {
    Unvisited, Visited, Visiting
  }

  public static void main(String[] args) {
    Graph graph = new Graph();
    Node nodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");
    Node nodeD = new Node("D");

    nodeA.addAdjacent(nodeB);
    nodeB.addAdjacent(nodeC);
    nodeC.addAdjacent(nodeD);

    graph.addNode(nodeA);
    graph.addNode(nodeB);
    graph.addNode(nodeC);
    graph.addNode(nodeD);

    boolean routeExists = search(graph, nodeA, nodeD);
    System.out.println("Route between A and D exists " + routeExists);

    boolean routeExists2 = search(graph, nodeA, nodeC);
    System.out.println("Route between A and D exists " + routeExists2);

    boolean routeExists3 = search(graph, nodeD, nodeA);
    System.out.println("Route between A and D exists " + routeExists3);
  }

  // BFS
  private static boolean search(Graph g, Node start, Node end) {
    if (start == end)
      return true;

    // operates as Queue
    LinkedList<Node> q = new LinkedList<>();
    for (Node u : g.getNodes()) {
      u.state = State.Unvisited;
    }
    start.state = State.Visiting;
    q.add(start);
    Node u;
    while (!q.isEmpty()) {
      u = q.removeFirst();
      if (u != null) {
        for (Node v : u.getAdjacent()) {
          if (v.state == State.Unvisited) {
            if (v == end) {
              return true;
            } else {
              v.state = State.Visiting;
              q.add(v);
            }
          }
        }
        u.state = State.Visited;
      }
    }
    return false;
  }

}