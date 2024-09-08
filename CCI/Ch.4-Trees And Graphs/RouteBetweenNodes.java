import java.util.*;

// Define the Node class representing a node in the graph
class Node {
  private String name;
  private List<Node> neighbors;
  public RouteBetweenNodes.State state;

  public Node(String name) {
    this.name = name;
    neighbors = new ArrayList<>();
  }

  public void addNeighbor(Node neighbor) {
    neighbors.add(neighbor);
  }

  public List<Node> getNeighbors() {
    return neighbors;
  }

  public String getName() {
    return name;
  }
}

// Define the Graph class representing a directed graph
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

// Main class with the solution to find the route between nodes
public class RouteBetweenNodes {

  enum State {
    Unvisited, Visited, Visiting
  }

  public static void main(String[] args) {
    // Create a graph and add nodes
    Graph graph = new Graph();
    Node nodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");
    Node nodeD = new Node("D");

    nodeA.addNeighbor(nodeB);
    nodeB.addNeighbor(nodeC);
    nodeC.addNeighbor(nodeD);

    graph.addNode(nodeA);
    graph.addNode(nodeB);
    graph.addNode(nodeC);
    graph.addNode(nodeD);

    // Test if there's a route between nodeA and nodeD
    boolean routeExists = search(graph, nodeA, nodeD);
    System.out.println("Route between A and D exists: " + routeExists);

    // Test if there's a route between nodeA and nodeC
    boolean routeExists2 = search(graph, nodeA, nodeC);
    System.out.println("Route between A and C exists: " + routeExists2);

    // Test if there's a route between nodeD and nodeA
    boolean routeExists3 = search(graph, nodeD, nodeA);
    System.out.println("Route between D and A exists: " + routeExists3);
  }

  private static boolean search(Graph graph, Node start, Node end) {
    if (start == end) {
      return true;
    }

    // Initialize a queue for BFS
    LinkedList<Node> queue = new LinkedList<>();
    for (Node node : graph.getNodes()) {
      node.state = State.Unvisited;
    }

    start.state = State.Visiting;
    queue.add(start);

    while (!queue.isEmpty()) {
      Node currentNode = queue.removeFirst();
      if (currentNode != null) {
        for (Node neighbor : currentNode.getNeighbors()) {
          if (neighbor.state == State.Unvisited) {
            if (neighbor == end) {
              return true;
            } else {
              neighbor.state = State.Visiting;
              queue.add(neighbor);
            }
          }
        }
        currentNode.state = State.Visited;
      }
    }

    return false;
  }
}
