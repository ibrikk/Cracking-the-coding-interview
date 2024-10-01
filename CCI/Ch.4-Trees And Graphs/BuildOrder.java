import java.util.*;

public class BuildOrder {

    public static void main(String[] args) {
        String[] projects = { "a", "b", "c", "d", "e", "f" };
        String[][] dependencies = {
                { "a", "d" },
                { "f", "b" },
                { "b", "d" },
                { "f", "a" },
                { "d", "c" }
        };

        // Find build order
        BuildOlderDFS buildOlderDFS = new BuildOlderDFS();
        Stack<Project> buildOrder = buildOlderDFS.findBuildOrderDfs(projects, dependencies);

        if (buildOrder == null) {
            System.out.println("There is a circular dependency, no valid build order.");
        } else {
            for (Project project : buildOrder) {
                System.out.print(project.getName() + " ");
            }
        }

    }

    private static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        IGraph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public static IGraph buildGraph(String[] projects, String[][] dependencies) {
        IGraph graph = new IGraph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    private static Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        /* Add "roots" to the build order first */
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            /*
             * We have a circular dependency since there are no remaining projects with
             * zero dependencies.
             */

            if (current == null) {
                return null;
            }

            /* Remove myself as a dependency. */
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }

            /* Add children that have no one depending on them. */
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    /*
     * A helper function to insert projects with zero dependencies into the order
     * array, starting at index offset.
     */

    private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
}

class IGraph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node); // Add the project to the map
        }
        return map.get(name); // Return the project from the map
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}

class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public enum State {
        COMPLETE, PARTIAL, BLANK
    };

    private State state = State.BLANK;

    public void setState(State st) {
        state = st;
    }

    public Project(String n) {
        name = n;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public int getNumberDependencies() {
        return dependencies;
    }

    public State getState() {
        return state;
    }
}

class BuildOlderDFS {
    public Stack<Project> findBuildOrderDfs(String[] projects, String[][] dependencies) {
        IGraph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public static IGraph buildGraph(String[] projects, String[][] dependencies) {
        IGraph graph = new IGraph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    Stack<Project> orderProjects(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false; // Cycle detected
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL); // Mark the project as being processed
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack)) {
                    return false; // Return false if any child causes a cycle
                }
            }
            project.setState(Project.State.COMPLETE); // Mark the project as processed
            stack.push(project); // Add to the build order
        }

        return true; // No cycle detected
    }

    public enum State {
        COMPLETE, PARTIAL, BLANK
    };

    private State state = State.BLANK;

    public State getState() {
        return state;
    }

    public void setState(State st) {
        state = st;
    }

}
