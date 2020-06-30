package graph;
public class Graph {

    private static class Vertex {

        private char info;
        private Object next;
        private Object line;

        public Vertex() {
        }
    }

    public class Edge {

        int weight;
        Edge next;
        Vertex node;
    }
    Vertex first;

    Graph() {
        first = null;
    }

    void addVertex(char c) {
        Vertex node = new Vertex();
        node.info = c;
        node.next = null;
        node.line = null;
        if (first == null) {
            first = node;
        } else {
            Vertex last = first;
            while (last.next != null) {
                last = (Vertex) last.next;
            }
            last.next = node;
        }
    }

    void addEdge(Vertex dest, int weight, Vertex src) {
        Edge line = new Edge();
        line.weight = weight;
        line.next = null;
        line.node = dest;
        if (src.line == null) {
            src.line = line;
        } else {
            Edge last = (Edge) src.line;
            while (last.next != null) {
                last = last.next;
            }
            last.next = line;
        }
    }

    Vertex findVertex(char c) {
        Vertex result = null;
        Vertex node = first;
        boolean found = false;
        while ((node != null) && (found == false)) {
            if (node.info == c) {
                result = node;
                found = true;
            } else {
                node = (Vertex) node.next;
            }
        }
        return result;
    }

    void printGraph() {
        Vertex node = first;
        if (node != null) {
            while (node != null) {
                System.out.println("vertex : " + node.info);
                Edge line = (Edge) node.line;
                while (line != null) {
                    System.out.println(" - edge to ->" + line.node.info + ", weight : " + line.weight);
                    line = line.next;
                }
                node = (Vertex) node.next;
            }
        } else {
            System.out.println("graph kosong");
        }
    }
}
