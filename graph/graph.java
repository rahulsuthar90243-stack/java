import java.util.ArrayList;
import java.util.List;

public class graph {
    private final int v;
    private final List<List<Integer>> l;

    graph(int V) {
        this.v = V;
        l = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            l.add(new ArrayList<>());
        }
    }

    void addGraph(int u, int v) {
        if (u < 0 || u >= this.v || v < 0 || v >= this.v) {
            throw new IllegalArgumentException("Vertex out of range");
        }

        l.get(u).add(v);
        l.get(v).add(u);
    }

    void adjacency() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int neigh : l.get(i)) {
                System.out.print(neigh + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        graph g = new graph(6);

        g.addGraph(1, 2);
        g.addGraph(1, 3);
        g.addGraph(2, 4);
        g.addGraph(4, 3);
        g.addGraph(3, 5);
        g.addGraph(5, 6);

        g.adjacency();
    }
}